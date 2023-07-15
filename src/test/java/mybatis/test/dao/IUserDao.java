package mybatis.test.dao;

public interface IUserDao {
    String queryUsername(String uId);
    Integer queryUserAge(String uId);
}
