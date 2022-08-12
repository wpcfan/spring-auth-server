package com.imooc.simpleserver.config;

import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.security.KeyStore;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

@Configuration
public class KeyPairConfig {

    private static final String KEYSTORE_TYPE = "PKCS12";
    private static final String ALIAS = "mooc-oauth-jwt";
    private static final String PASSWORD = "mooc-pass";
    private static final String KEY_FILE_NAME = "mooc-jwt.jks";

    @Bean
    public RSAKey rsaKey() {
        try {
            ClassPathResource ksFile = new ClassPathResource(KEY_FILE_NAME);
            KeyStore keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
            keyStore.load(ksFile.getInputStream(), PASSWORD.toCharArray());
            RSAPrivateKey privateKey = (RSAPrivateKey) keyStore.getKey(ALIAS, PASSWORD.toCharArray());
            RSAPublicKey publicKey = (RSAPublicKey) keyStore.getCertificate(ALIAS).getPublicKey();
            return new RSAKey.Builder(publicKey)
                    .privateKey(privateKey)
                    .keyID(UUID.randomUUID().toString())
                    .build();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }
}
