package com.imooc.uaa.repository;

import com.imooc.uaa.domain.AuthorizationConsent;
import com.imooc.uaa.domain.oauth2.AuthorizationConsentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorizationConsentRepo extends JpaRepository<AuthorizationConsent, AuthorizationConsentId>  {
    Optional<AuthorizationConsent> findByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
    void deleteByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
}
