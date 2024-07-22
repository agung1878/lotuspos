package com.cashier.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

//    private static final String SQL_LOGIN
//            = "select u.username as username,p.user_password as password, active "
//            + "from c_security_user u "
//            + "inner join c_security_user_password p on p.id_user = u.id "
//            + "inner join c_security_role r on u.id_role = r.id "
//            + "where username = ?";

    private static final String SQL_LOGIN = "select u.username, up.user_password as password, active " +
            "from c_security_user u inner join c_security_user_password up on u.id = up.id_user " +
            "where u.username = ?";

    private static final String SQL_PERMISSION = "select u.username, p.permission_value "
            + "from c_security_user u inner join c_security_role r on r.id = u.id_role "
            + "inner join c_security_role_permission rp on rp.id_role = r.id "
            + "inner join c_security_permission p on rp.id_permission = p.id "
            + "where u.username = ?";

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());
        return provider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcDaoImpl userDetails = new JdbcDaoImpl();
        userDetails.setDataSource(dataSource);
        userDetails.setUsersByUsernameQuery(SQL_LOGIN);
        userDetails.setAuthoritiesByUsernameQuery(SQL_PERMISSION);
        return userDetails;
    }

//    @Bean @Order(1)
//    SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.securityMatcher("/api/**")
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/api/mandiri/va").permitAll()
//                        .requestMatchers("/api/bni/va/**").permitAll()
//                        .requestMatchers("/api/orbit/**").permitAll()
//                        .requestMatchers("/api/bca/**").permitAll()
//                        .anyRequest().permitAll()
//                ).csrf().disable();
//        return http.build();
//    }

    @Bean @Order(1)
    public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/assets/**", "/css/**").permitAll()
                        .requestMatchers("/register/**", "/forgot/**","/terms", "/registrasi/**","/api/**" ,"/").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login").permitAll()
                        .defaultSuccessUrl("/dashboard", true)
                ).logout(logout -> logout.deleteCookies("JSESSIONID")
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                        .permitAll()).logout(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}
