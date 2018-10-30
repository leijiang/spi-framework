package com.netease.haitao.demo;

import com.netease.haitao.demo.functionpoint.promotion.PromotionCalcu;
import com.netease.haitao.demo.functionpoint.promotion.context.PromotionCalcuContext;
import com.netease.haitao.demo.functionpoint.promotion.context.PromotionCalcuResult;
import com.netease.haitao.demo.functionpoint.validate.ValidateSeller;
import com.netease.haitao.demo.functionpoint.validate.context.ValidateSellerContext;
import com.netease.haitao.demo.functionpoint.validate.context.ValidateSellerResult;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Auther: leijiang
 * @Date: 2018/10/29 14:07
 * @Description: 启动类
 */

public class BootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-spi.xml");
        context.refresh();

        ValidateSeller validateSeller = (ValidateSeller) context.getBean("spiValidateSeller");
        List<ValidateSellerResult> validateSellerResultList = validateSeller.invoke(new ValidateSellerContext());

        PromotionCalcu promotionCalcu = (PromotionCalcu) context.getBean("spiPromotionCalcu");
        List<PromotionCalcuResult> promotionCalcuResultList = promotionCalcu.invoke(new PromotionCalcuContext());

        context.close();
    }
}
