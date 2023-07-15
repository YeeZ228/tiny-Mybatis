package mybatis.test;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import mybatis.bingding.MapperProxyFactory;
import mybatis.test.dao.IUserDao;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<IUserDao>(IUserDao.class);
        Map<String, String> sqlSession = new HashMap<String, String>();
        sqlSession.put("mybatis.test.dao.IUserDao.queryUsername", "模拟执行SQL语句");

        IUserDao userDao = factory.newInstance(sqlSession);
        String s = userDao.queryUsername("1");
        System.out.println(s);
    }

    @Test
    public void test_proxy_class() {
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserDao.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return "代理";
                    }
                }
        );
        String result = userDao.queryUsername("1");
        System.out.println(result);
    }
}
