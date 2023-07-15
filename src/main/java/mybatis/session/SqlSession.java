package mybatis.session;

/**
 * 定义数据库处理接口
 * 获取Mapper对象，并将其交给映射器代理类进行使用
 * 定义执行 SQL 标准、获取映射器以及将来管理事务等方面的操作
 *
 * 在 SqlSession 中定义用来执行 SQL、获取映射器对象以及后续管理事务操作的标准接口。
 * 目前这个接口中对于数据库的操作仅仅只提供了 selectOne，后续还会有相应其他方法的定义。
 */
public interface SqlSession {
    <T> T selectOne(String statement);
    <T> T selectOne(String statement, Object parameter);
    <T> T getMapper(Class<T> type);
}
