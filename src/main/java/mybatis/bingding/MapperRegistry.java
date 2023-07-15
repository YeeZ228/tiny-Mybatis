package mybatis.bingding;

import mybatis.session.SqlSession;
import cn.hutool.core.lang.ClassScanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 提供包路径的扫描和映射器代理类注册机服务，完成接口对象的代理类注册处理
 */
public class MapperRegistry {
    // 将已添加的映射器代理加入 HashMap
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause:" + e, e);
        }
    }

    public <T> void addMapper(Class<T> type) {
        // mapper必须是接口才注册
        if (type.isInterface()) {
            if (knownMappers.containsKey(type)) {
                throw new RuntimeException("Type " + type + " is already know to the MapperRegistry.");
            }
        }
        knownMappers.put(type, new MapperProxyFactory(type));
    }

    public void addMappers(String packageName) {
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }
    }

}
