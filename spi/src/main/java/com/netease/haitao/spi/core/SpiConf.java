package com.netease.haitao.spi.core;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Auther: leijiang
 * @Date: 2018/10/29 11:32
 * @Description:
 */
@Data
@AllArgsConstructor
public class SpiConf {

    /**
     * 优先级
     */
    private int priority;

    /**
     * 是否互斥
     */
    private boolean mutex;

    /**
     * 标识
     */
    private String name;
}
