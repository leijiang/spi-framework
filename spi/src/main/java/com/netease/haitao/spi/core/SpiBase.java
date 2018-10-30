package com.netease.haitao.spi.core;

import java.util.List;

/**
 * @Auther: leijiang
 * @Date: 2018/10/29 11:30
 * @Description:spi 基类
 */
public interface SpiBase<I, O> {

    /**
     * 满足条件执行
     *
     * @param context
     * @return
     */
    boolean condition(I context);

    /**
     * 配置
     *
     * @param context
     * @return
     */
    SpiConf conf(I context);

    /**
     * 执行
     *
     * @param context
     * @return
     */
    List<O> invoke(I context);
}
