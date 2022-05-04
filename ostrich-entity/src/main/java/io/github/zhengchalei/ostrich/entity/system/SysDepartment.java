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
 * 系统部门
 *
 * @author zhengchalei
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "sys_department")
public class SysDepartment extends TreeEntity<SysDepartment, Long> {

    @Column(nullable = false)
    @NotBlank(message = "部门名称不能为空")
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "部门编码不能为空")
    private String code;

    private String remark;

}
