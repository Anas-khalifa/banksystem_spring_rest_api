package com.BackEnd.MyBankSystem_RestApi.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

//       return new JdbcUserDetailsManager(dataSource);

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username,password,enabled from users where username=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username, authority from authorities where username=?");

        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(config->
                config

                        .requestMatchers(HttpMethod.POST,"/Authentication/register").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/loans").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/Transfer/**").hasRole("EMPLOYEE")

//                        .requestMatchers(HttpMethod.GET,"/loans/**").hasRole("USER")
//                        .requestMatchers(HttpMethod.POST,"/loans").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST,"/Authentication/register").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.PUT,"/loans/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.DELETE,"/loans/**").hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(userService); //set the custom user details service
//        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
//        return auth;
//    }

}
