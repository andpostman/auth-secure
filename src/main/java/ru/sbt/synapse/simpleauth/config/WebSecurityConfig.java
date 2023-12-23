package ru.sbt.synapse.simpleauth.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.sbt.synapse.simpleauth.service.EmployeeDetailsService;
import java.util.Collection;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig{

    private final EmployeeDetailsService employeeDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(employeeDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers("/purchasing-department/**").hasRole("PURCHASING_DEPARTMENT")
                        .requestMatchers("/accountant/**").hasRole("ACCOUNTANT")
                        .requestMatchers("/warehouse/**").hasRole("WAREHOUSE")
                        .requestMatchers("/","/css/**","/js/**").permitAll()
//                        .requestMatchers("/**").permitAll()
                        .anyRequest().authenticated()
        ).formLogin(
                el -> el.successHandler(((request, response, authentication) -> {
                    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                    for (GrantedAuthority authority : authorities) {
                        log.info("auth: {}",authority.getAuthority());
                        if (authority.getAuthority().equals("ROLE_PURCHASING_DEPARTMENT")) {
                            response.sendRedirect("/purchasing-department");
                            return;
                        }
                        else if (authority.getAuthority().equals("ROLE_ACCOUNTANT")){
                            response.sendRedirect("/accountant");
                            return;
                        }
                        else if (authority.getAuthority().equals("ROLE_WAREHOUSE")){
                            response.sendRedirect("/warehouse");
                            return;
                        }
                    }
                    response.sendRedirect("/home");
                }))
        ).logout(el -> el
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll());
        return http.build();
    }
}
