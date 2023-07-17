package mybatis.session.defaults;

import mybatis.bingding.MapperRegistry;
import mybatis.session.Configuration;
import mybatis.session.SqlSession;
import mybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}
