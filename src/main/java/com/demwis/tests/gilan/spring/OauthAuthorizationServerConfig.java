package com.demwis.tests.gilan.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Collections;

@Configuration
@EnableAuthorizationServer
public class OauthAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final TokenStore tokenStore;

    private final JwtAccessTokenConverter accessTokenConverter;

    private final AuthenticationManager authenticationManager;

    private final ConfigProperties configProperties;

    @Autowired
    public OauthAuthorizationServerConfig(TokenStore tokenStore, JwtAccessTokenConverter accessTokenConverter, AuthenticationManager authenticationManager, ConfigProperties configProperties) {
        this.tokenStore = tokenStore;
        this.accessTokenConverter = accessTokenConverter;
        this.authenticationManager = authenticationManager;
        this.configProperties = configProperties;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient(configProperties.getAuthClient())
                .secret(configProperties.getAuthSecret())
                .authorizedGrantTypes(configProperties.getAuthGrantType())
                .scopes("read", "write")
                .resourceIds(configProperties.getAuthResourceId());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        enhancerChain.setTokenEnhancers(Collections.singletonList(accessTokenConverter));
        endpoints.tokenStore(tokenStore)
                .accessTokenConverter(accessTokenConverter)
                .tokenEnhancer(enhancerChain)
                .authenticationManager(authenticationManager);
    }
}
