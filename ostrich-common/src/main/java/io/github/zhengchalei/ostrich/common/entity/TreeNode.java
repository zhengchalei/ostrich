package entity;

import java.util.Collection;
import java.util.Set;

/**
 * 树节点
 *
 * @author zhengchalei
 */
public interface TreeNode<T, ID> {

    /**
     * 得到父id
     *
     * @return {@link ID}
     */
    ID getParentId();

    /**
     * 获取当前节点 id
     *
     * @return {@link ID}
     */
    ID getId();

    /**
     * 获取子节点
     *
     * @return {@link Collection}<{@link T}>
     */
    Collection<T> getChildren();

    /**
     * 组孩子
     *
     * @param sets 集
     */
    void setChildren(Set<T> sets);
}
