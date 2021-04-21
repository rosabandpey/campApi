package com.camp.campApi.security;

import java.io.IOException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.camp.campApi.exception.ApiException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtAuthorization extends OncePerRequestFilter {

	public DecodedJWT jwt;
	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		response.addHeader("Access-Control-Allow-Origin", SecurityConstants.CLIENT_DOMAIN_URL);

		response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, "
				+ "Content-Type, Access-Control-Request-Method, " + "Access-Control-Request-Headers, Authorization");

		response.addHeader("Access-Control-Expose-Headers",
				"Access-Control-Allow-Origin, " + "Access-Control-Allow-Credntials, " + "Authorization");

		response.addHeader("Access-Control-Allow-Methods", "GET," + "POST, " + "DELETE");

		if ((request.getMethod().equalsIgnoreCase("OPTIONS"))) {
			try {
				response.setStatus(HttpServletResponse.SC_OK);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			String jwtToken = request.getHeader(SecurityConstants.HEADER_TYPE);
			if (jwtToken == null || !jwtToken.startsWith(SecurityConstants.TOKEN_PREFIX)) {
				filterChain.doFilter(request, response);
				return;
			}

		//	try {

			JWT.require(Algorithm.HMAC256(SecurityConstants.SECRET));
			jwt = JWT.decode(jwtToken.substring(SecurityConstants.TOKEN_PREFIX.length()));
/*
		} catch (IllegalArgumentException e) {
			logger.error("an error occured during getting username from token", e);
		} catch (JWTVerificationException e) {
			logger.warn("the token is expired and not valid anymore", e);
		} */
			String username = jwt.getSubject();
			List<String> roles = jwt.getClaims().get("roles").asList(String.class);
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
			UsernamePasswordAuthenticationToken authenticatedUser = new UsernamePasswordAuthenticationToken(username,
					null, authorities);
			SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
			filterChain.doFilter(request, response);
		}
	}
}
