package com.netease.haitao.demo.functionpoint.promotion.impl;

import com.netease.haitao.demo.functionpoint.promotion.PromotionCalcu;
import com.netease.haitao.demo.functionpoint.promotion.context.PromotionCalcuContext;
import com.netease.haitao.demo.functionpoint.promotion.context.PromotionCalcuResult;
import com.netease.haitao.spi.annotation.BizSpi;
import com.netease.haitao.spi.core.SpiConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Auther: leijiang
 * @Date: 2018/10/29 13:51
 * @Description: 普通商品优惠计算
 */
@BizSpi
public class NormalPromotionCalcu implements PromotionCalcu {

    private static final Logger logger = LoggerFactory.getLogger(HaitaoPromotionCalcu.class);

    private static final String DEFAULT_CAL_TYPE = "NORMAL";

    public boolean condition(PromotionCalcuContext context) {
        return Objects.equals(DEFAULT_CAL_TYPE, context.getType());
    }

    public SpiConf conf(PromotionCalcuContext context) {
        return new SpiConf(2, true, "NormalPromotionCalcu");
    }

    public List<PromotionCalcuResult> invoke(PromotionCalcuContext context) {
        logger.error("NormalPromotionCalcu invoked.");
        return new ArrayList<>();
    }
}
