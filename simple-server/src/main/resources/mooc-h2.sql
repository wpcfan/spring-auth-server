DELETE FROM mooc_roles_permissions;
DELETE FROM mooc_users_roles;
DELETE FROM mooc_permissions;
DELETE FROM mooc_roles;
DELETE FROM mooc_users;
DELETE FROM oauth2_registered_client;
INSERT INTO mooc_permissions(id, permission_name, display_name) VALUES (1, 'USER_READ', '查询用户信息');
INSERT INTO mooc_permissions(id, permission_name, display_name) VALUES (2, 'USER_CREATE', '新建用户');
INSERT INTO mooc_permissions(id, permission_name, display_name) VALUES (3, 'USER_UPDATE', '编辑用户信息');
INSERT INTO mooc_permissions(id, permission_name, display_name) VALUES (4, 'USER_ADMIN', '用户管理');
INSERT INTO mooc_users(id, username, `name`, mobile, password_hash, enabled, account_non_expired, account_non_locked, credentials_non_expired, using_mfa, mfa_key, email)
VALUES (1, 'user', 'Zhang San', '13012341234', '{bcrypt}$2a$10$jhS817qUHgOR4uQSoEBRxO58.rZ1dBCmCTjG8PeuQAX4eISf.zowm', 1, 1, 1, 1, true, '8Uy+OZUaZur9WwcP0z+YxNy+QdsWbtfqA70GQMxMfLeisTd8Na6C7DkjhJWLrGyEyBsnEmmkza6iorytQRh7OQ==', 'zhangsan@local.dev');
INSERT INTO mooc_roles(id, role_name, display_name, built_in)
VALUES (1, 'ROLE_USER', '客户端用户', true);
INSERT INTO mooc_roles(id, role_name, display_name, built_in)
VALUES (2, 'ROLE_ADMIN', '超级管理员', true);
INSERT INTO mooc_roles(id, role_name, display_name, built_in)
VALUES (3, 'ROLE_STAFF', '管理后台用户', true);
INSERT INTO mooc_users_roles(user_id, role_id) values (1, 1), (1, 2), (1, 3);
INSERT INTO mooc_roles_permissions(role_id, permission_id) values (1, 1), (2, 1), (2, 2), (2, 3), (2, 4);

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
