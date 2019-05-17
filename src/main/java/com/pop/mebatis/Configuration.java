package com.pop.mebatis;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * @author Pop
 * @date 2019/5/17 23:26
 */
public class Configuration {


    public final  static ResourceBundle sqlMapping;

    static {
        sqlMapping = ResourceBundle.getBundle("mesql");
    }

    /**
     * 返回代理类的对象
     * 关联id和sql语句
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class clazz,SqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader()
        ,clazz.getInterfaces(),
                new MapperProxy(sqlSession));
    }
}
