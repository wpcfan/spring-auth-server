package com.imooc.uaa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateClientDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String clientId;
    private String clientSecret;
    private String clientName;
    private List<String> scopes;
    private List<String> grantTypes;
    private List<String> autoApproves;
    private Set<String> redirectUris;
    private int accessTokenValidity;
    private int refreshTokenValidity;
    private List<String> clientAuthenticationMethods;
}
