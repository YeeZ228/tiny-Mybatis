package mybatis.test;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import mybatis.bingding.MapperProxyFactory;
import mybatis.bingding.MapperRegistry;
import mybatis.session.SqlSession;
import mybatis.session.SqlSessionFactory;
import mybatis.session.defaults.DefaultSqlSessionFactory;
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
//        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<IUserDao>(IUserDao.class);
//        Map<String, String> sqlSession = new HashMap<String, String>();
//        sqlSession.put("mybatis.test.dao.IUserDao.queryUsername", "模拟执行SQL语句");
//
//        IUserDao userDao = factory.newInstance(sqlSession);
//        String s = userDao.queryUsername("1");
//        System.out.println(s);
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

    /**
     * 构建一个简单的 Mapper映射器注册机，用于扫描包路径自动地创建映射器的代理，并提供相应的对DefaultSqlSession包装和使用
     */
    @Test
    public void test_MapperProxyFactory_02() {
        // MapperRegistry扫描一个包路径，将路径下符合的接口，全部注册成MapperProxy，并将这些代理类写入到缓存中
        // 注册mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("mybatis.test.dao");

        // 后续需要某个接口对应的映射器时，直接从缓存中拿出来使用
        // 从SqlSession工厂获取Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取映射对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        String s = userDao.queryUsername("101");
        System.out.println(s);

    }
}
