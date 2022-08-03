package com.imooc.uaa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imooc.uaa.common.Constants;
import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 角色实体类，实现 GrantedAuthority 接口
 */
@With
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@QueryEntity
@Entity
@Table(name = "mooc_roles")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增长 ID，唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色名称，有唯一约束，不能重复
     */
    @NotNull
    @Pattern(regexp = Constants.PATTERN_ROLE_NAME)
    @Column(name = "role_name", unique = true, nullable = false, length = 50)
    private String roleName;

    @NotNull
    @Size(max = 50)
    @Column(name = "display_name", nullable = false, length = 50)
    private String displayName;

    @NotNull
    @Column(name = "built_in", nullable = false)
    private boolean builtIn;

    @Builder.Default
    @JsonIgnore
    @Fetch(FetchMode.JOIN)
    @ManyToMany
    @JoinTable(
        name = "mooc_roles_permissions",
        joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @BatchSize(size = 20)
    @ToString.Exclude
    private Set<Permission> permissions = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private Set<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) {
            return false;
        }
        Role role = (Role) o;
        return id != null && id.equals(role.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(roleName);
    }
}
