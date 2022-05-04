package io.github.zhengchalei.ostrich.entity.system;

import io.github.zhengchalei.ostrich.common.entity.TreeEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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

}
