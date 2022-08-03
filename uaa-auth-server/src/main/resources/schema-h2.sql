ALTER TABLE IF EXISTS mooc_permissions DROP CONSTRAINT uk_mooc_permissions_permission_name;
ALTER TABLE IF EXISTS mooc_roles DROP CONSTRAINT uk_mooc_roles_role_name;
ALTER TABLE IF EXISTS mooc_users DROP CONSTRAINT uk_mooc_users_username;
ALTER TABLE IF EXISTS mooc_users DROP CONSTRAINT uk_mooc_users_mobile;
ALTER TABLE IF EXISTS mooc_users DROP CONSTRAINT uk_mooc_users_email;
ALTER TABLE IF EXISTS mooc_roles_permissions DROP CONSTRAINT fk_roles_permissions_role_id_mooc_roles_id;
ALTER TABLE IF EXISTS mooc_roles_permissions DROP CONSTRAINT fk_roles_permissions_permission_id_mooc_permissions_id;
ALTER TABLE IF EXISTS mooc_users_roles DROP CONSTRAINT fk_users_roles_user_id_mooc_users_id;
ALTER TABLE IF EXISTS mooc_users_roles DROP CONSTRAINT fk_users_roles_role_id_mooc_roles_id;

DROP TABLE IF EXISTS mooc_permissions;
CREATE TABLE mooc_permissions
(
    id              BIGINT      NOT NULL AUTO_INCREMENT,
    permission_name VARCHAR(50) NOT NULL,
    display_name    VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_mooc_permissions_permission_name UNIQUE (permission_name)
);

DROP TABLE IF EXISTS mooc_roles;
CREATE TABLE mooc_roles
(
    id           BIGINT      NOT NULL AUTO_INCREMENT,
    role_name    VARCHAR(50) NOT NULL,
    display_name VARCHAR(50) NOT NULL,
    built_in     BIT         NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_mooc_roles_role_name UNIQUE (role_name)
);

DROP TABLE IF EXISTS mooc_users;
CREATE TABLE mooc_users
(
    id                      BIGINT       NOT NULL AUTO_INCREMENT,
    account_non_expired     BIT          NOT NULL,
    account_non_locked      BIT          NOT NULL,
    credentials_non_expired BIT          NOT NULL,
    email                   VARCHAR(254) NOT NULL,
    enabled                 BIT          NOT NULL,
    mfa_key                 VARCHAR(255) NOT NULL,
    mobile                  VARCHAR(11)  NOT NULL,
    name                    VARCHAR(50)  NOT NULL,
    password_hash           VARCHAR(80)  NOT NULL,
    username                VARCHAR(50)  NOT NULL,
    using_mfa               BIT          NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_mooc_users_username UNIQUE (username),
    CONSTRAINT uk_mooc_users_mobile UNIQUE (mobile),
    CONSTRAINT uk_mooc_users_email UNIQUE (email)
);

DROP TABLE IF EXISTS mooc_roles_permissions;
CREATE TABLE mooc_roles_permissions
(
    role_id       BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    PRIMARY KEY (role_id, permission_id),
    CONSTRAINT fk_roles_permissions_role_id_mooc_roles_id FOREIGN KEY (role_id) REFERENCES mooc_roles (id),
    CONSTRAINT fk_roles_permissions_permission_id_mooc_permissions_id FOREIGN KEY (permission_id) REFERENCES mooc_permissions (id)
);

DROP TABLE IF EXISTS mooc_users_roles;
CREATE TABLE mooc_users_roles
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_users_roles_user_id_mooc_users_id FOREIGN KEY (user_id) REFERENCES mooc_users (id),
    CONSTRAINT fk_users_roles_role_id_mooc_roles_id FOREIGN KEY (role_id) REFERENCES mooc_roles (id)
);

DROP TABLE IF EXISTS `mooc_oauth2_clients`;
CREATE TABLE `mooc_oauth2_clients`
(
    id varchar(255) NOT NULL,
    client_id varchar(255) NOT NULL,
    client_id_issued_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    client_secret varchar(255) DEFAULT NULL,
    client_secret_expires_at timestamp DEFAULT NULL,
    client_name varchar(255) NOT NULL,
    client_authentication_methods varchar(1000) NOT NULL,
    authorization_grant_types varchar(1000) NOT NULL,
    redirect_uris varchar(1000) DEFAULT NULL,
    scopes varchar(1000) NOT NULL,
    client_settings varchar(2000) NOT NULL,
    token_settings varchar(2000) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `mooc_oauth2_authorizations`;
CREATE TABLE `mooc_oauth2_authorizations` (
   id varchar(255) NOT NULL,
   registered_client_id varchar(255) NOT NULL,
   principal_name varchar(255) NOT NULL,
   authorization_grant_type varchar(255) NOT NULL,
   attributes varchar(4000) DEFAULT NULL,
   `state` varchar(500) DEFAULT NULL,
   authorization_code_value varchar(4000) DEFAULT NULL,
   authorization_code_issued_at timestamp DEFAULT NULL,
   authorization_code_expires_at timestamp DEFAULT NULL,
   authorization_code_metadata varchar(2000) DEFAULT NULL,
   access_token_value varchar(4000) DEFAULT NULL,
   access_token_issued_at timestamp DEFAULT NULL,
   access_token_expires_at timestamp DEFAULT NULL,
   access_token_metadata varchar(2000) DEFAULT NULL,
   access_token_type varchar(255) DEFAULT NULL,
   access_token_scopes varchar(1000) DEFAULT NULL,
   refresh_token_value varchar(4000) DEFAULT NULL,
   refresh_token_issued_at timestamp DEFAULT NULL,
   refresh_token_expires_at timestamp DEFAULT NULL,
   refresh_token_metadata varchar(2000) DEFAULT NULL,
   oidc_id_token_value varchar(4000) DEFAULT NULL,
   oidc_id_token_issued_at timestamp DEFAULT NULL,
   oidc_id_token_expires_at timestamp DEFAULT NULL,
   oidc_id_token_metadata varchar(2000) DEFAULT NULL,
   oidc_id_token_claims varchar(2000) DEFAULT NULL,
   PRIMARY KEY (id)
);

DROP TABLE IF EXISTS mooc_oauth2_authorization_consents;
CREATE TABLE mooc_oauth2_authorization_consents
(
    registered_client_id varchar(255) NOT NULL,
    principal_name varchar(255) NOT NULL,
    authorities varchar(1000) NOT NULL,
    PRIMARY KEY (registered_client_id, principal_name)
);
