package com.imooc.uaa.repository;

import com.imooc.uaa.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, Long>, QuerydslPredicateExecutor<Permission> {

    Optional<Permission> findOptionalByAuthority(String authority);

    Set<Permission> findByIdIn(Set<Long> ids);

    @Query("select p from Permission p left join p.roles pr where pr.id <> ?1")
    Set<Permission> findAvailablePermissions(Long roleId);

    long countByAuthorityAndIdNot(String authority, Long Id);
}
