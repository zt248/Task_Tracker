package com.task.tracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("developer").password("123").roles("DEVELOPER")
//                .and()
//                .withUser("manager").password("321").roles("MANAGER")
//                .and()
////                .withUser("admin").password("root").authorities("ROLE_DEVELOPER","ROLE_ADMIN","ROLE_MANAJER");
//                .withUser("admin").password("root").roles("ADMIN", "MANAGER", "DEVELOPER");

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select email,password, enabled from user where email=?")
                .authoritiesByUsernameQuery(
                        "select email, role from user where email=?");

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .and()
                .authorizeRequests().antMatchers("/manager**", "/manager/project**").hasRole("MANAGER")
                .and()
                .authorizeRequests().antMatchers("/developer**", "/developer/developer**").hasRole("DEVELOPER")
                .and()
//                .authorizeRequests().antMatchers("/admin**").access("hasRole('DEVELOPER') and hasRole('ADMIN') and hasRole('MANAGER')")
//                .authorizeRequests().antMatchers("/admin**").access("hasAnyRole('DEVELOPER', 'ADMIN', 'MANAGER')")
//                .and()
//                .formLogin()
                .formLogin().successHandler(customAuthenticationSuccessHandler)
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));


        //Русская кодировка
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);
    }
}
