package com.andrey.SpringSecurity.config;

import com.andrey.SpringSecurity.model.Usuario;
import com.andrey.SpringSecurity.security.CustomUserDetailsService;
import com.andrey.SpringSecurity.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(authorize->{
                    authorize.requestMatchers(HttpMethod.POST,"v1/usuarios/**").permitAll();
                    authorize.requestMatchers("/h2-console/**").permitAll();
                    authorize.anyRequest().authenticated();
                })
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }


    @Bean
    public UserDetailsService userDetailsService(UsuarioService service){
        /*
        UserDetails user1 = User.builder()
                .username("usuario")
                .password(passwordEncoder.encode("123"))
                .roles("USER")
                .build();

        UserDetails user2 = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("123"))
                .roles("ADMIN")
                .build();
        */
        return new CustomUserDetailsService(service);
    }
}
