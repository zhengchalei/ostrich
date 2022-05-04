package io.github.zhengchalei.ostrich.entity.system;

import io.github.zhengchalei.ostrich.common.entity.BaseEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "sys_role_permission",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id")
    )
    @ToString.Exclude
    private Set<SysPermission> permissions = new HashSet<>();

    private String remark;

}
