package com.netease.haitao.spi.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @Auther: leijiang
 * @Date: 2018/10/29 10:39
 * @Description: SPI 业务实现注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface BizSpi {
}
