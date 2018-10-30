package com.netease.haitao.spi.core;

import java.util.Comparator;

/**
 * @Auther: leijiang
 * @Date: 2018/10/29 12:26
 * @Description: spi 实现按照优先级排序（容器排序）
 */
public class SpiComparator implements Comparator<SpiBase> {

    @SuppressWarnings("unchecked")
    @Override
    public int compare(SpiBase spiImp1, SpiBase spiImp2) {
        return Integer.compare(spiImp1.conf(null).getPriority(), spiImp2.conf(null).getPriority());
    }
}
