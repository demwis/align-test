package com.demwis.tests.gilan.spring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ConfigProperties {
    @Value("${auth.client}")
    private String authClient;

    @Value("${auth.secret}")
    private String authSecret;

    @Value("${auth.grantType}")
    private String authGrantType;

    @Value("${auth.resourceId}")
    private String authResourceId;

    @Value("${auth.realm}")
    private String authRealm;

    @Value("${auth.signing-key}")
    private String authSigningKey;

    @Value("${auth.passwordStrength:11}")
    private Integer authPasswordStrength;
}
