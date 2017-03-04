package com.stevebarreira.football.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.stevebarreira.football.service.impl.AccountsAuthService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {
	
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth, AccountsAuthService accountsService) throws Exception {
//       //auth.userDetailsService(accountsService);
//    	auth
//    		.inMemoryAuthentication()
//    			.withUser("username").password("password").roles("USER_ROLE");
//    }
//    
    @Override
    public void configure(WebSecurity web) throws Exception {
    	web.ignoring()
    		.antMatchers()
    		.antMatchers("/api/**")
    		.antMatchers("/javascripts/**")
    		.antMatchers("/css/**");
    }
    
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/api/**").permitAll() //Need to remove
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }

}
