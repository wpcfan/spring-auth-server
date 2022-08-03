package com.imooc.uaa.repository;

import com.imooc.uaa.domain.QRole;
import com.imooc.uaa.domain.Role;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>, QuerydslPredicateExecutor<Role>, QuerydslBinderCustomizer<QRole> {

    Optional<Role> findOptionalByRoleName(String roleName);

    Set<Role> findByIdIn(Set<Long> ids);

    @Query("select count(r) from Role r inner join r.users ru where r.id = ?1")
    long countByAssigned(Long id);

    long countByRoleNameIgnoreCase(String roleName);

    long countByRoleNameIgnoreCaseAndIdNot(String roleName, Long Id);

    @Override
    default void customize(QuerydslBindings bindings, QRole root) {
        bindings.bind(root.roleName).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.displayName).first(StringExpression::containsIgnoreCase);
    }
}
