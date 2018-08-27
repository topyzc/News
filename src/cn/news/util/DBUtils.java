package cn.news.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Package:
 * @ClassName:DBUtils.java
 * @Description:TODO
 * @author Alan
 * @date 2018年7月27日下午4:12:36
 */
public class DBUtils {
	// 四个常量
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/news";
	private final static String USER = "root";
	private final static String PASSWORD = "ye123123";
	// 三个变量
	private static Connection connection;// 连接数据
	private PreparedStatement pstm;// 操作数据
	private ResultSet rs;// 获得结果集

	static {
		try {
			Class.forName(DRIVER); // 加载MYSQL JDBC驱动程序
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doSql(String sql, Object... objs) {
		try {
			// 发送sql语句
			this.pstm = connection.prepareStatement(sql);
			// 解析参数
			for (int i = 0; i < objs.length; i++) {
				this.pstm.setObject(i + 1, objs[i]);
			}
			// 执行sql语句
			this.pstm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getCount(String sql, Object... objs) {
		try {
			doSql(sql, objs);
			return this.pstm.getUpdateCount();// 获得数据受影响的条数
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}
	public ResultSet getResultSet(String sql, Object... objs) {
		
		try {
			doSql(sql, objs);
			return this.pstm.getResultSet();//返回查询数据
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
	}
}
