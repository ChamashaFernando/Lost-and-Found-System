//package lk.chamasha.lost.and.found.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfiguration {
//
//    private final JwtAuthenticationFilter jwtAuthFilter;
//    private final AuthenticationProvider authenticationProvider;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> {
//                    // Public endpoints for user registration & login
//                    auth.requestMatchers(antMatchers(HttpMethod.POST, "/api/users/register")).permitAll();
//                    auth.requestMatchers(antMatchers(HttpMethod.POST, "/api/users/login")).permitAll();
//                    auth.requestMatchers("/error/**").permitAll();
//
//                    // Allow public access to some lost & found related endpoints if needed
//                    auth.requestMatchers(antMatchers(HttpMethod.GET, "/api/items/**")).permitAll();
//                    auth.requestMatchers(antMatchers(HttpMethod.GET, "/api/lost/**")).permitAll();
//                    auth.requestMatchers(antMatchers(HttpMethod.GET, "/api/found/**")).permitAll();
//
//                    // Everything else requires authentication
//                    auth.anyRequest().authenticated();
//                })
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//    private RequestMatcher antMatchers(HttpMethod method, String path) {
//        return new AntPathRequestMatcher(path, method.name());
//    }
//}

package lk.chamasha.lost.and.found.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    // Public endpoints
                    auth.requestMatchers(HttpMethod.POST, "/api/users/register").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/api/users/login").permitAll();
                    auth.requestMatchers("/error/**").permitAll();

                    // Public GET endpoints for lost and found items
                    auth.requestMatchers(HttpMethod.GET, "/api/items/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/api/lost/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/api/found/**").permitAll();

                    // All other endpoints require authentication
                    auth.anyRequest().authenticated();
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
