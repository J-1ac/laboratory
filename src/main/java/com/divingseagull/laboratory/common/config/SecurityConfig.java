package com.divingseagull.laboratory.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // HTTP → HTTPS 리다이렉트
                .requiresChannel(channel ->
                        channel.anyRequest().requiresSecure()
                )
                // 인증 없이 모든 요청 허용(필요에 따라 수정)
                .authorizeHttpRequests(authorize ->
                        authorize.anyRequest().permitAll()
                )
                // 불필요 옵션 비활성화
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable();
        return http.build();
    }
}