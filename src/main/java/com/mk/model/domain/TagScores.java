package com.mk.model.domain;

import lombok.Data;

/**
 * 标签分数表
 */
@Data
public class TagScores {
    private Integer id;
    private String tagName;
    // 标签对应的二进制位值
    private Integer indexValue;

}
