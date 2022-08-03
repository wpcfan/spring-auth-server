package com.imooc.uaa.domain.dto;

import com.imooc.uaa.domain.Permission;
import com.imooc.uaa.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;
import java.util.function.Function;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String roleName;

    private String displayName;

    private boolean builtIn;

    private Set<Permission> permissions;

    public static Function<Role, RoleDto> fromRole = (role) -> RoleDto.builder()
        .id(role.getId())
        .roleName(role.getRoleName())
        .displayName(role.getDisplayName())
        .builtIn(role.isBuiltIn())
        .permissions(role.getPermissions())
        .build();
}
