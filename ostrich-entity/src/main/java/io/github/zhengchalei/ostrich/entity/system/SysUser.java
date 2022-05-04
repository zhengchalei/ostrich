package io.github.zhengchalei.ostrich.entity.system;

import io.github.zhengchalei.ostrich.common.entity.BaseEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 系统用户
 *
 * @author zhengchalei
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "sys_user")
public class SysUser extends BaseEntity<Long> {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "sys_user_department", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"))
    @ToString.Exclude
    private Set<SysDepartment> departments = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "sys_user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @ToString.Exclude
    private Set<SysRole> roles = new HashSet<>();

}
