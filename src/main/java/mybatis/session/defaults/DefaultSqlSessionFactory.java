package mybatis.session.defaults;

import mybatis.bingding.MapperRegistry;
import mybatis.session.SqlSession;
import mybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
