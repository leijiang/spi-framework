package com.netease.haitao.demo.functionpoint.validate.impl;

import com.netease.haitao.demo.functionpoint.validate.ValidateSeller;
import com.netease.haitao.demo.functionpoint.validate.context.ValidateSellerContext;
import com.netease.haitao.demo.functionpoint.validate.context.ValidateSellerResult;
import com.netease.haitao.spi.annotation.BizSpi;
import com.netease.haitao.spi.core.SpiConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: leijiang
 * @Date: 2018/10/29 14:02
 * @Description:
 */
@BizSpi
public class YouPinValidateSeller implements ValidateSeller {

    private static final Logger logger = LoggerFactory.getLogger(YouPinValidateSeller.class);

    @Override
    public boolean condition(ValidateSellerContext context) {
        return true;
    }

    @Override
    public SpiConf conf(ValidateSellerContext context) {
        return new SpiConf(100, false, "YouPinValidateSeller");
    }

    @Override
    public List<ValidateSellerResult> invoke(ValidateSellerContext context) {
        logger.error("YouPinValidateSeller invoked.");
        return new ArrayList<>();
    }
}
