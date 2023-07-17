package mybatis.session.defaults;

import mybatis.bingding.MapperRegistry;
import mybatis.mapping.MappedStatement;
import mybatis.session.Configuration;
import mybatis.session.SqlSession;

/**
 * 对 SqlSession 接口进行实现
 * getMapper 通过 MapperRegistry 类获取映射器对象
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
