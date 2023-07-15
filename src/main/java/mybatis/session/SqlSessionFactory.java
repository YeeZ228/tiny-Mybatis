package mybatis.session;

/**
 * 提供 SqlSession 服务，屏蔽创建细节，延迟创建过程
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
