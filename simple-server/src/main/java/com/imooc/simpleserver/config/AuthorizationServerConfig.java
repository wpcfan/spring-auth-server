package com.imooc.simpleserver.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.ProviderSettings;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration(proxyBeanMethods = false)
public class AuthorizationServerConfig {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
        OAuth2AuthorizationServerConfigurer<HttpSecurity>
            authorizationServerConfigurer =
            new OAuth2AuthorizationServerConfigurer<>();

        RequestMatcher endpointsMatcher = authorizationServerConfigurer
            .getEndpointsMatcher();
        http
            .requestMatcher(endpointsMatcher)
            .exceptionHandling(exceptions ->
                exceptions.authenticationEntryPoint(new
                    LoginUrlAuthenticationEntryPoint("/login"))
            )
            .authorizeRequests(authorizeRequests ->
                authorizeRequests.anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.ignoringRequestMatchers(endpointsMatcher))
            .apply(authorizationServerConfigurer);
        return http.build();
    }

    @Bean
    public RegisteredClientRepository registeredClientRepository(JdbcTemplate jdbcTemplate) {
//        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
//            .clientId("web-client")
//            .clientSecret("{noop}secret")
//            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//            .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//            .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//            .redirectUri("http://127.0.0.1:8081/login/oauth2/code/web-client-oidc")
//            .redirectUri("http://127.0.0.1:8081/authorized")
//            .scope(OidcScopes.OPENID)
//            .scope("todo.read")
//            .scope("todo.write")
//            .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//            .build();
//
//        RegisteredClient adminClient = RegisteredClient.withId(UUID.randomUUID().toString())
//            .clientId("admin-client")
//            .clientName("后台管理客户端")
//            .clientSecret("{noop}secret")
//            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//            .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//            .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//            .redirectUri("http://127.0.0.1:4001")
//            .scope(OidcScopes.OPENID)
//            .scope("user.admin")
//            .scope("client.admin")
//            .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//            .build();
//
//        RegisteredClient iOSClient = RegisteredClient.withId(UUID.randomUUID().toString())
//            .clientId("ios-client")
//            .clientName("iOS 客户端")
//            .clientSecret("{noop}secret")
//            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//            .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//            .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//            .redirectUri("http://127.0.0.1:4001")
//            .scope(OidcScopes.OPENID)
//            .scope("todo.read")
//            .scope("todo.write")
//            .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//            .build();
//
//        RegisteredClient androidClient = RegisteredClient.withId(UUID.randomUUID().toString())
//            .clientId("android-client")
//            .clientName("Android 客户端")
//            .clientSecret("{noop}secret")
//            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//            .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//            .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//            .redirectUri("http://127.0.0.1:4001")
//            .scope(OidcScopes.OPENID)
//            .scope("todo.read")
//            .scope("todo.write")
//            .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//            .build();
        // Save registered client in db
        JdbcRegisteredClientRepository registeredClientRepository = new JdbcRegisteredClientRepository(jdbcTemplate);
//        registeredClientRepository.save(registeredClient);
//        registeredClientRepository.save(adminClient);
//        registeredClientRepository.save(iOSClient);
//        registeredClientRepository.save(androidClient);
        return registeredClientRepository;
    }

    @Bean
    public OAuth2AuthorizationService authorizationService(JdbcTemplate jdbcTemplate, RegisteredClientRepository registeredClientRepository) {
        JdbcOAuth2AuthorizationService jdbcOAuth2AuthorizationService = new JdbcOAuth2AuthorizationService(jdbcTemplate, registeredClientRepository);
//        jdbcOAuth2AuthorizationService.setAuthorizationRowMapper(new RowMapper(registeredClientRepository));
        return jdbcOAuth2AuthorizationService;
    }

//    static class RowMapper extends JdbcOAuth2AuthorizationService.OAuth2AuthorizationRowMapper {
//        RowMapper(RegisteredClientRepository registeredClientRepository) {
//            super(registeredClientRepository);
//            getObjectMapper().addMixIn(User.class, UserMixin.class);
//            getObjectMapper().addMixIn(Permission.class, PermissionMixin.class);
//        }
//    }

//    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
//    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
//        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    static class UserMixin {
//
//        @JsonCreator
//        public UserMixin(@JsonProperty("id") Long id, @JsonProperty("username") String username, @JsonProperty("password") String password) {
//        }
//
//    }
//
//    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
//    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
//        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    static class PermissionMixin {
//
//        @JsonCreator
//        public PermissionMixin(@JsonProperty("id") Long id, @JsonProperty("authority") String authority, @JsonProperty("displayName") String displayName) {
//        }
//
//    }

    @Bean
    public OAuth2AuthorizationConsentService authorizationConsentService(JdbcTemplate jdbcTemplate, RegisteredClientRepository registeredClientRepository) {
        return new JdbcOAuth2AuthorizationConsentService(jdbcTemplate, registeredClientRepository);
    }

    @Bean
    public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {
        JWKSet jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }

    @Bean
    public ProviderSettings providerSettings() {
        return ProviderSettings.builder()
            .issuer("http://localhost:9000").build();
    }

}
