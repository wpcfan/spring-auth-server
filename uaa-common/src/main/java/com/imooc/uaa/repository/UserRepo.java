package com.imooc.uaa.repository;

import com.imooc.uaa.domain.QUser;
import com.imooc.uaa.domain.User;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {
    /**
     * 根据用户名查找用户
     *
     * @param username 用户
     * @return 可能为空的用户
     */
    Optional<User> findOptionalByUsername(String username);

    /**
     * 根据电子邮件查找用户
     *
     * @param email 电子邮件
     * @return 可能为空的用户
     */
    Optional<User> findOptionalByEmail(String email);

    /**
     * 查找用户名数量
     *
     * @param username 用户名
     * @return 数量
     */
    long countByUsername(String username);

    /**
     * 查找电子邮件数量
     *
     * @param email 电子邮件
     * @return 数量
     */
    long countByEmail(String email);

    long countByEmailAndUsernameIsNot(String email, String username);

    /**
     * 查找手机号数量
     *
     * @param mobile 手机号
     * @return 数量
     */
    long countByMobile(String mobile);

    long countByMobileAndUsernameIsNot(String mobile, String username);

    @Override
    default void customize(QuerydslBindings bindings, QUser root) {
        bindings.bind(root.username).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.name).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.mobile).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.email).first(StringExpression::containsIgnoreCase);
    }
}
