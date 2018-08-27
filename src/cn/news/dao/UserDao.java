package cn.news.dao;




import java.util.List;



import cn.news.entities.User;



public interface UserDao {
	User checkLogin(User user);
	
	int addUser(User user);
	
	int deleteUser(int id);
	
	int updateUser(User user);
	
	List<User>  queryAll();
		
}
