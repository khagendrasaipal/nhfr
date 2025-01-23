package com.saipal.Health_Facility_Registry.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.saipal.Health_Facility_Registry.service.MyuserDetailsService;
import com.saipal.Health_Facility_Registry.util.JwtUtils;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

	@Autowired
	MyuserDetailsService myUserDetailsService;
	@Autowired
	JwtUtils jwtUtils;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requestPath = request.getServletPath();
	    if (requestPath.startsWith("/api/v1")) {
	        filterChain.doFilter(request, response);
	        return;
	    }

		final String authorizationHeader = request.getHeader("Authorization");
		String jwt =null;
		String username= null;
		if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer")) {
			jwt = authorizationHeader.substring(7);
			username = jwtUtils.extractUsername(jwt);
		}
		if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(username);
			if(jwtUtils.validateToken(jwt, userDetails)) {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
		}
		filterChain.doFilter(request, response);
	}

}
