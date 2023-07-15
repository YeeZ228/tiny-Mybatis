package mybatis.session.defaults;

import mybatis.bingding.MapperProxyFactory;
import mybatis.bingding.MapperRegistry;
import mybatis.session.SqlSession;

/**
 * 对 SqlSession 接口进行实现
 * getMapper 通过 MapperRegistry 类获取映射器对象
 */
public class DefaultSqlSession implements SqlSession {
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参： " + parameter);
    }

    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}
