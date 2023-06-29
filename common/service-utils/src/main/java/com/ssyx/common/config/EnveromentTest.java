package com.ssyx.common.config;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.origin.OriginTrackedValue;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.*;

/**
 * @description:
 * @author: oywl
 * @time: 2023-6-28 16:04
 */

public class EnveromentTest implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();

        List<PropertySource> list = new ArrayList<>();
        for(PropertySource ps : propertySources){
            Map<String,Object> map = new HashMap<>();
            sout(propertySources);
            boolean applicationConfig = ps.getName().contains("application");
            if (!applicationConfig) {
                continue;
            }
            // 获取上文的application集合中获取数据库连接
            Map<String, OriginTrackedValue> dataBaseSource =
                    (Map<String, OriginTrackedValue>)ps.getSource();
//			String driverClass = String.valueOf(dataBaseSource.get("spring.datasource.driver-class-name").getValue());
            dataBaseSource.forEach((k,v)->{
                System.out.println("------>"+v.getValue());
            });
//            String applicationName = String.valueOf(dataBaseSource.get("spring.application.name").getValue());
//            String newName =applicationName+"666";

            if(ps instanceof OriginTrackedMapPropertySource){
                OriginTrackedMapPropertySource propertySource = new OriginTrackedMapPropertySource(ps.getName(),map);
                Map<String,Object> src = (Map<String,Object>)ps.getSource();
                src.forEach((k,v)->{
                    String strValue = String.valueOf(v);
                    if(strValue.startsWith("PASSWORD[") && strValue.endsWith("]")) {
                        // 此处进行截取出对应的密文 BR23C92223KKDNUIQMPLS0009 ,然后调用对应的解密算法进行解密操作
                        v = "6666";
                    }
                    map.put(k,v);
                });
                list.add(propertySource);

            }
        }
        environment.getPropertySources().addFirst(new MapPropertySource("customProperties", Collections.singletonMap("spring.application.name", "newName")));
        /**
         此处是删除原来的 OriginTrackedMapPropertySource 对象，
         把解密后新生成的放入到 Environment,为什么不直接修改原来的
         OriginTrackedMapPropertySource 对象，此处不做过多解释
         不懂的可以去看看它对应的源码，也算是留一个悬念，也是希望大家
         能够没事多看一看源码。
         */
        list.forEach(ps->{
            propertySources.remove(ps.getName());
            propertySources.addLast(ps);
        });

    }

    private void sout(MutablePropertySources propertySources) {
        // 配置放在了application-pro或者是application-dev 中 赋值复制需要在其中赋值
        for (PropertySource<?> propertySource : propertySources) {
            boolean applicationConfig = propertySource.getName().contains("application");
            if (!applicationConfig) {
                continue;
            }
            // 获取上文的application集合中获取数据库连接
            Map<String, OriginTrackedValue> dataBaseSource =
                    (Map<String, OriginTrackedValue>)propertySource.getSource();
//			String driverClass = String.valueOf(dataBaseSource.get("spring.datasource.driver-class-name").getValue());
            dataBaseSource.forEach((k,v)->{
                System.out.println("------>"+v.getValue());
            });
//            String url = String.valueOf(dataBaseSource.get("spring.application.name").getValue());
//            String user = String.valueOf(dataBaseSource.get("spring.datasource.username").getValue());
//            String password = String.valueOf(dataBaseSource.get("spring.datasource.password").getValue());
            // 因为在spring初始化之前 所有不能使用注解 所以需要jdbc直接连接数据库 首先建立驱动
        }
    }
}
