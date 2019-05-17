package com.pop.mebatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Pop
 * @date 2019/5/17 23:36
 */
public class MapperProxy implements InvocationHandler {

    //这个里面，因为需要执行真正的sql语句，而真正的执行的sql方法是在session中的
    //我们通过构造方法传进
    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //Blog blog = (Blog) session.selectOne("com.gupaoedu.mapper.BlogMapper.selectBlogById", 1);

        String statementId = method.getDeclaringClass().getName()+"."+method.getName();

        return sqlSession.selectOne(statementId,args[0]);
    }
}
