package com.example.dockerexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.dockerexample.security.oauth.CustomOAuth2UserService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private CustomOAuth2UserService oAuth2UserService;

    @Autowired
    @Qualifier("authenticationProvider")
    AuthenticationProvider authenticationProvider;
    
    @Bean
    AuthenticationSuccessHandler authenticationSuccessHandler() {
      return new CustomAuthenticationSuccessHandler();
    }

    
    AuthenticationFailureHandler authenticationFailureHandler() {
      return new CustomAuthenticationFailureHandler();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/oauth2/**")
//        .permitAll().antMatchers("/resources/**").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .loginPage("/login")
//                    .loginProcessingUrl("/process-login")
//                    .successHandler(authenticationSuccessHandler())
//                    .failureHandler(authenticationFailureHandler())
//                    .permitAll()
//                .and()
//                .oauth2Login()
//                .loginPage("/login")
//                .userInfoEndpoint()
//                .userService(oAuth2UserService).and().and()
//                .logout().logoutSuccessUrl("/").permitAll();
        http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/login", "/home", "/v2/api-docs", 
                "/swagger-resources/**", 
                "/configuration/ui",
                "/configuration/security", 
                "/swagger-ui.html",
                "swagger-ui/index.html",
                "/webjars/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .httpBasic();
        
    }

   
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.authenticationProvider(authenticationProvider);
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
}
