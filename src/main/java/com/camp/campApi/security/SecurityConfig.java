package com.camp.campApi.security;

import com.camp.campApi.exception.ApiException;
import com.camp.campApi.exception.GlobalExceptionHandler;
import com.camp.campApi.exception.JwtAuthEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String[] PUBLIC_MATCHERS = { "/api/authenticate/login", "/api/authenticate/register", "/api/authenticate/resetPassword/**", "/image/**" };
    private static final String[] ADMIN_ROLE={"/user/userList"};

	@Qualifier("userDetaileServiceImpl")
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private JwtAuthEntryPoint unauthorizedHandler;

	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		JwtAuthentication jwtAuthentication = new JwtAuthentication(authenticationManager());
		jwtAuthentication.setFilterProcessesUrl(PUBLIC_MATCHERS[0]);
		http.csrf().disable().cors().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()	

			//	.authorizeRequests().antMatchers(ADMIN_ROLE).access("hasRole('ADMIN')")
			 //   .antMatchers("/","/**").permitAll()
				.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll()
				.anyRequest().authenticated()
		.and()
				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler)

		.and()
		.addFilter(jwtAuthentication)
		.addFilterBefore(new JwtAuthorization(), UsernamePasswordAuthenticationFilter.class);
	}
}
