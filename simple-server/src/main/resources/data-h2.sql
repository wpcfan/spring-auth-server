DELETE FROM oauth2_authorization_consent;
DELETE FROM oauth2_authorization;
DELETE FROM oauth2_registered_client;
DELETE FROM authorities;
DELETE FROM users;
INSERT INTO users
VALUES ('user', '{bcrypt}$2a$10$jhS817qUHgOR4uQSoEBRxO58.rZ1dBCmCTjG8PeuQAX4eISf.zowm', true);
INSERT INTO authorities(username, authority)
VALUES ('user', 'USER');
INSERT INTO authorities(username, authority)
VALUES ('user', 'ADMIN');
INSERT INTO oauth2_registered_client
VALUES ('b343900e-f1b7-4c46-adea-9945e6b4b57c', 'web-client', TIMESTAMP '2022-07-28 20:32:28.961889', '{noop}secret',
        NULL, 'web-client', 'client_secret_basic',
        'refresh_token,client_credentials,authorization_code',
        'http://127.0.0.1:8081/authorized,http://127.0.0.1:8081/login/oauth2/code/web-client-oidc',
        'todo.read,openid,todo.write',
        '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":true}',
        '{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",300.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.core.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",3600.000000000]}'),

       ('96acfc0b-d3cf-459a-a213-01d86f91756b', 'admin-client', TIMESTAMP '2022-07-28 20:32:29.007461', '{noop}secret',
        NULL, 'admin-client', 'client_secret_basic',
        'refresh_token,client_credentials,authorization_code', 'http://127.0.0.1:4001',
        'openid,client.admin,user.admin',
        '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":true}',
        '{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",300.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.core.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",3600.000000000]}'),

       ('55c5b355-6a19-4df1-bb18-0cd5f4970934', 'ios-client', TIMESTAMP '2022-07-28 20:32:29.008541', '{noop}secret',
        NULL, 'ios-client', 'client_secret_basic', 'refresh_token,client_credentials,authorization_code',
        'http://127.0.0.1:4001', 'todo.read,openid,todo.write',
        '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":true}',
        '{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",300.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.core.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",3600.000000000]}'),

       ('aab4d23d-9936-48c8-ba11-0e1a89af548a', 'android-client', TIMESTAMP '2022-07-28 20:32:29.008541',
        '{noop}secret', NULL, 'android-client', 'client_secret_basic',
        'refresh_token,client_credentials,authorization_code', 'http://127.0.0.1:4001', 'todo.read,openid,todo.write',
        '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":true}',
        '{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",300.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.core.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",3600.000000000]}');
