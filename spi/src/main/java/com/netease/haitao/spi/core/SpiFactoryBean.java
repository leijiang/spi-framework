package com.netease.haitao.spi.core;

import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: leijiang
 * @Date: 2018/10/29 12:30
 * @Description:
 */

public class SpiFactoryBean<T> implements FactoryBean<T> {

    private static final Logger logger = LoggerFactory.getLogger(SpiFactoryBean.class);

    @Setter
    private Class<T> targetClass;

    @Override
    public T getObject() throws Exception {
        return newProxy();
    }

    @Override
    public Class<?> getObjectType() {
        return targetClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @SuppressWarnings("unchecked")
    private T newProxy() {

        InvocationHandler invocationHandler = (proxy, method, args) -> {

            List<SpiBase> spiList = SpiManager.getSpiByType(targetClass);

            List finalResult = new ArrayList();
            Object context = null;
            if (args != null && args.length > 0) {
                context = args[0];
            }
            for (SpiBase spi : spiList) {
                if (spi != null && spi.condition(context)) {
                    List singleResult = spi.invoke(context);
                    finalResult.addAll(singleResult);
                    SpiConf spiConf = spi.conf(context);
                    if (spiConf.isMutex()) {
                        break;
                    }
                }
            }
            return finalResult;
        };

        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader()
                , new Class[]{targetClass}, invocationHandler);
    }
}
