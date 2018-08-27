package cn.news.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cn.news.entities.User;
import cn.news.util.DBUtils;

public class UserDaoImpl implements UserDao{
	private DBUtils util = new DBUtils();
	private List<User> users;
	private User user;
	/**
	 * 检查登录
	 */
	@Override
	public User checkLogin(User usr) {
		String sql="select * from user where username=? and password=?";
		Object objs[] = {usr.getUsername(),usr.getPassword()};
		ResultSet rs = util.getResultSet(sql, objs);
	    System.out.println(rs);
	    rsToList(rs);
		if(users!=null) {
			return user;
		}
		return null; 	
	}
    /**
     * 添加用户
     */
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
    
	/**
	 * 删除用户
	 */
	@Override
	public int deleteUser(int id) {
		String sql = "delete from user where id=?";
		Object objs[] = { id };
		return util.getCount(sql, objs);
		
	}

	/**
	 * 修改用户
	 */
	@Override
	public int updateUser(User user) {
		String sql = "update user set username=?,password=? where id=?";
		Object objs[] = { user.getUsername(),user.getPassword(),user.getId()
			};
		return util.getCount(sql, objs);
	}

	/**
	 * 查询所有用户
	 */
	@Override
	public List<User> queryAll() {
		String sql = "select * from user ";
		Object objs[] = {};
		ResultSet rs = util.getResultSet(sql, objs);
		rsToList(rs);
		return users;
	}

	private void rsToList(ResultSet rs) {
		users = new ArrayList<>();
		user = null;
		try {
			while (rs.next()) {
				int nid = rs.getInt("id");
				String name = rs.getString("username");
				String text=rs.getString("password");
				user = new User(nid, name,text);
				System.out.println(user);
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    	
}
