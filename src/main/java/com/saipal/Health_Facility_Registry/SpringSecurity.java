package com.saipal.Health_Facility_Registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saipal.Health_Facility_Registry.filters.JwtRequestFilter;

import com.saipal.Health_Facility_Registry.service.MyCustomApiDetailsUser;
import com.saipal.Health_Facility_Registry.service.MyuserDetailsService;

@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{

	@Autowired
	private MyuserDetailsService myUserDetailsService;
	
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	MyCustomApiDetailsUser myCustomApiDetailsUser;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
	
		
		auth.userDetailsService(myUserDetailsService).passwordEncoder(getPasswordEncoder());
		auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
		
		
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().cors().and()
		.authorizeRequests().antMatchers("/userSignup",
				"/health_registry/user_list/list",
				//"/surgical/list"
				"/surgical/create","/surgical/update/{id}",
				//"/specialized/list",
				"/specialized/create","/specialized/update/{id}",
				//"/service-type/list",

//				"/services/list",
				"/services/create","/services/update/{id}",
				//"/radiology/list"
				"/radiology/create","/radiology/update/{id}",
				//"/ownership/list",
				"/ownership/create","/ownership/update/{id}",
				//"/opd/list",
				"/opd/create","/opd/update/{id}","/opd/edit/{id}",
				//"/laboratory/list",
				"/laboratory/create","/laboratory/update/{id}",
				//"/facility-type/list",
				"/facility-type/create","/facility-type/update/{id}",
				//"/facility-level/list",
				"/facility-level/create","/facility-level/update/{id}",
				//"/bipanna/list",
				"/bipanna/create","/bipanna/update/{id}"

				).authenticated()
		.anyRequest().permitAll()
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);
	}


	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}


	@Bean(name = "noOpencoder")
	 PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance(); 
	}
	@Bean(name = "encoder")
	 PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}
	
	@Bean 
	ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() 
    {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(java.util.Collections.singletonList("*"));
        configuration.setAllowedMethods(java.util.Collections.singletonList("*"));
        configuration.setAllowedHeaders(java.util.Collections.singletonList("*"));  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	

	
}
