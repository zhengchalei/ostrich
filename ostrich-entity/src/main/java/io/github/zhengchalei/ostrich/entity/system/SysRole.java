package io.github.zhengchalei.entity.system;

import io.github.zhengchalei.ostrich.common.entity.BaseEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 系统角色
 *
 * @author zhengchalei
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "sys_role")
public class SysRole extends BaseEntity<Long> {

    @NotBlank(message = "角色名称不能为空")
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank(message = "角色编码不能为空")
    @Column(nullable = false, unique = true)
    private String code;

    @BatchSize(size = 200)
    @Fetch(value = FetchMode.SELECT)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "sys_role_permission",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id")
    )
    @ToString.Exclude
    private Set<SysPermission> permissions = new HashSet<>();

    private String remark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SysRole sysRole = (SysRole) o;
        return id != null && Objects.equals(id, sysRole.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
