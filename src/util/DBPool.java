package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DBPool {
    public static void main(String []args) throws Exception {
        // 加载配置文件
        Properties pro=new Properties();
        InputStream is=DBPool.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        // 获取连接池对象
        DataSource ds=DruidDataSourceFactory.createDataSource(pro);
        // 获取连接
        Connection conn=ds.getConnection();
        System.out.println(conn);
    }
}
