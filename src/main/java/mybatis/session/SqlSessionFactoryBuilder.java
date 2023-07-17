package mybatis.session;

import mybatis.builder.xml.XMLConfigBuilder;
import mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * 作为整个 Mybatis 的入口类，包装XML解析处理，并返回对应 SqlSessionFactory 处理类
 * 通过解析将XML信息注册到 Configuration 配置类中，再传递 Configuration 配置类到各个逻辑处理类中
  */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
