package com.imooc.uaa.domain;

import com.imooc.uaa.domain.oauth2.AuthorizationConsentId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@IdClass(AuthorizationConsentId.class)
@Table(name = "`mooc_oauth2_authorization_consents`")
public class AuthorizationConsent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "registered_client_id", nullable = false)
    private String registeredClientId;
    @Id
    @Column(name = "principal_name", nullable = false)
    private String principalName;
    @Column(length = 1000, nullable = false)
    private String authorities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorizationConsent that = (AuthorizationConsent) o;

        if (registeredClientId != null ? !registeredClientId.equals(that.registeredClientId) : that.registeredClientId != null)
            return false;
        if (principalName != null ? !principalName.equals(that.principalName) : that.principalName != null)
            return false;
        return authorities != null ? authorities.equals(that.authorities) : that.authorities == null;
    }

    @Override
    public int hashCode() {
        int result = registeredClientId != null ? registeredClientId.hashCode() : 0;
        result = 31 * result + (principalName != null ? principalName.hashCode() : 0);
        result = 31 * result + (authorities != null ? authorities.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuthorizationConsent{" +
            "registeredClientId='" + registeredClientId + '\'' +
            ", principalName='" + principalName + '\'' +
            ", authorities='" + authorities + '\'' +
            '}';
    }
}
