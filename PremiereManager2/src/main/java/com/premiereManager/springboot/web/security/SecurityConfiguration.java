package com.premiereManager.springboot.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * Configures global security by adding authentication in memory. Class creates
	 * new login and password. Created user gets roles user and admin.
	 * 
	 * @author Lukasz Blaszkowski
	 */
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Rafal").password("{noop}dostep").roles("USER", "ADMIN");
	}

	/**
	 * Class overriding configure method in the web security. Permits to login. If
	 * somebody wants to login it permits everybody to do this. If somebody wants to
	 * go to any other pages, it checks if he has the role of user. If he doesn't
	 * have this role, application will show a form to login.
	 *
	 * @author Lukasz Blaszkowski
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login", "/h2-console/**").permitAll().antMatchers("/", "/*premiere*/**")
				.access("hasRole('USER')").and().formLogin();

		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
}