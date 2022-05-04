package entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 基础实体
 *
 * @author zhengchalei
 */
@Data
@MappedSuperclass
public class TreeEntity<T extends TreeNode<T, ID>, ID extends Serializable> extends BaseEntity<ID> implements TreeNode<T, ID> {

    @Min(message = "上级节点 不正确", value = 0)
    @Column(nullable = false)
    @NotNull(message = "上级节点不能为空")
    protected ID parentId;

    /**
     * 子节点, 不会被持久化
     */
    @Transient
    protected Set<T> children = new HashSet<>();

    /**
     * 父节点, 不会被持久化
     */
    @Transient
    protected T parent;
}
