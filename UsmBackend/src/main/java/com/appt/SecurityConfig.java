package com.appt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.appt.service.MyUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(customProvider());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//				.antMatchers(HttpMethod.PUT, "/api/admin/update/{isinNo}").hasAuthority("Admin")

				.antMatchers(HttpMethod.GET, "/api/user/login").authenticated().anyRequest().permitAll().and()
				.httpBasic().and().csrf().disable();

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	DaoAuthenticationProvider customProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		// password Encoder info
		dao.setPasswordEncoder(getPasswordEncoder());
		// give DB info
		dao.setUserDetailsService(myUserDetailsService);

		return dao;
	}
}
