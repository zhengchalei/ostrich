package io.github.zhengchalei.ostrich.common.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 基础实体
 *
 * @author zhengchalei
 * @since 1.0.0
 */
@Data
@MappedSuperclass
public class BaseEntity<ID extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    protected ID id;

}
