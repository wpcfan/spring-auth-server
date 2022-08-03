package com.imooc.uaa.security.rolehierarchy;

import com.imooc.uaa.repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static com.imooc.uaa.common.Constants.ROLE_ADMIN;
import static com.imooc.uaa.common.Constants.ROLE_STAFF;

@RequiredArgsConstructor
@Service
public class RoleHierarchyService {

    private final RoleRepo roleRepo;

    public String getRoleHierarchyExpr() {
        val roles = roleRepo.findAll();
        return roles.stream()
            .flatMap(role -> role.getPermissions().stream()
                .map(permission -> role.getRoleName() + " > " + permission.getAuthority() + " "))
            .collect(Collectors.joining(" ", ROLE_ADMIN + " > " + ROLE_STAFF + " ", ""));
    }
}
