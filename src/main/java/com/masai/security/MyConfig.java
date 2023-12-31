package com.masai.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MyConfig {
    @Bean
    public SecurityFilterChain swiggySecurity(HttpSecurity http)throws Exception{
        http
                .authorizeHttpRequests(auth -> {
                        auth
                        .requestMatchers("/user/register").permitAll()
                                .requestMatchers("user/verify-OTP").hasRole("Admin")
                        .requestMatchers("/swagger-ui*/**", "/v3/api-docs/**").permitAll()
                        .anyRequest().authenticated();
            }).csrf(csrf -> csrf.disable())
            .addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
            .addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());

    return http.build();

    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
