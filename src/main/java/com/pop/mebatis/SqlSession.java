package com.pop.mebatis;

/**
 * @author Pop
 * @date 2019/5/17 23:25
 */
public class SqlSession {
    /**
     * 配置器，
     * 配置类的诞生
     * 将namesapce中的对象方法
     * 和xml中的sql语句信息存储起来，
     * 方便后面代理对象产生他们
     */
    private Configuration configuration;
    /**
     * 执行器
     * 主要用于执行sql语句的对象
     * 原有mybatis拥有比较常用的三种
     * simpleExcutor
     * reuseExcutor
     * batchExcutor
     *
     * 设计成接口会比较好
     */
    private Executor executor;


    /**
     * 常见的方法，传入具体的Id后，获得结果
     * @param statementId
     * @param params
     * @param
     * @return
     */
    public <T>  T selectOne(String statementId,Object params){
        //从statmentId->获得sql语句
        String sql=configuration.sqlMapping.getString("statementId");
        return executor.query(sql,params);
    }

    /**
     * 获得代理对象
     * @param clazz
     * @param <T>
     * @return
     */
    public <T>  T getMapper(Class clazz){
        return configuration.getMapper(clazz,this);
    }
}
