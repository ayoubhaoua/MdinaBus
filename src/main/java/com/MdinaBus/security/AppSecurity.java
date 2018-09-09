package com.MdinaBus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class AppSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("Dessineur").password("123").roles("DESSINEUR");
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("Roulement").password("123").roles("E_ROULEMENT");
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("Consommation").password("123").roles("E_CONSOMMATION");
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("All").password("123").roles("ADMIN");
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().disable()
		.authorizeRequests()
		
		.antMatchers("/bootstrap/**","/img/**","/js/**","/css/**").permitAll()
		 .anyRequest()
		 .authenticated()
		  .and()
		.formLogin()
		 .loginPage("/login")
		   .defaultSuccessUrl("/success")
		    .failureUrl("/login")
		   .permitAll()
		   .and()
		.logout()
		   .invalidateHttpSession(true)
		   .logoutUrl("/logout")
		   .permitAll();
	}

	
}
