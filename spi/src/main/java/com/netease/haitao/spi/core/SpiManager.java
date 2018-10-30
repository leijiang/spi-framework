package com.netease.haitao.spi.core;

import com.netease.haitao.spi.annotation.BizSpi;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: leijiang
 * @Date: 2018/10/29 12:10
 * @Description:
 */
@Component
public class SpiManager implements ApplicationListener<ContextRefreshedEvent> {

    private static Map<Class, List<SpiBase>> spiProviderMap = new ConcurrentHashMap<>();

    private volatile boolean loaded = false;

    public void onApplicationEvent(ContextRefreshedEvent e) {
        if (loaded) {
            return;
        }

        Map<String, Object> bizSpiMap = e.getApplicationContext().getBeansWithAnnotation(BizSpi.class);
        if (bizSpiMap == null || bizSpiMap.isEmpty()) {
            return;
        }
        for (Object bizSpiInstance : bizSpiMap.values()) {
            Class<?>[] interfaces = AopUtils.getTargetClass(bizSpiInstance).getInterfaces();
            if (interfaces == null || interfaces.length <= 0) {
                continue;
            }
            Class<?> spiInterface = interfaces[0];
            if (spiProviderMap.containsKey(spiInterface) && spiProviderMap.get(spiInterface).size() > 0) {
                spiProviderMap.get(spiInterface).add((SpiBase) bizSpiInstance);
            } else {
                List<SpiBase> spiBaseList = new ArrayList<>();
                spiBaseList.add((SpiBase) bizSpiInstance);
                spiProviderMap.put(spiInterface, spiBaseList);
            }
        }
        // SPI 实现优先级排序
        for (List<SpiBase> spiProviderList : spiProviderMap.values()) {
            spiProviderList.sort(new SpiComparator());
        }

        // 设置已经加载配置过
        loaded = true;
    }

    public static List<SpiBase> getSpiByType(Class clazz) {
        return spiProviderMap.get(clazz);
    }
}
