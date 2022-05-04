package io.github.zhengchalei.entity.system;

import io.github.zhengchalei.ostrich.common.entity.TreeEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

/**
 * 系统权限
 *
 * @author zhengchalei
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "sys_permission")
public class SysPermission extends TreeEntity<SysPermission, Long> {

    @NotBlank(message = "权限名称不能为空")
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank(message = "权限编码不能为空")
    @Column(nullable = false, unique = true)
    private String code;

    private String remark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SysPermission that = (SysPermission) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
