package cn.news.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.news.entities.Categories;
import cn.news.util.DBUtils;


public class CategoryDaoImpl implements CategoryDao {
	private DBUtils util = new DBUtils();
	private List<Categories> categories;
	private Categories categorie;

	/**
	 * 添加主题
	 */
	@Override
	public int add(Categories categorie) {
		System.out.println(categorie);
		String sql = "insert into categories(topicId,topicName) values(?,?)";
		Object objs[] = { categorie.getTopicId(), categorie.getTopicName()};
		return util.getCount(sql, objs);
		
	}
   /**
    * 删除主题
    */
	@Override
	public int delete(int id) {
		String sql = "delete from categories where topicId=?";
		Object objs[] = { id };
	
		return util.getCount(sql, objs);
	}
    
	/**
	 * 修改主题
	 */
	@Override
	public int update(Categories categorie) {
		String sql = "update categories set topicName=? where topicId=?";
		Object objs[] = { categorie.getTopicName(),categorie.getTopicId()
			};
		return util.getCount(sql, objs);
	}

	/**
	 * 查询主题
	 */
	@Override
	public List<Categories> queryAll() {
		String sql = "select * from categories ";
		Object objs[] = {};
		ResultSet rs = util.getResultSet(sql, objs);
		rsToList(rs);
		return categories;
	}

	private void rsToList(ResultSet rs) {
		categories = new ArrayList<>();
		categorie = null;
		try {
			while (rs.next()) {
				int id = rs.getInt("topicId");
				String name = rs.getString("topicName");
				categorie = new Categories(id, name);
				categories.add(categorie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Categories getEntity(int id) {
		String sql = "select * from categories where topicId=?";
		Object objects[] = { id };
		ResultSet resultSet = util.getResultSet(sql, objects);
		rsToList(resultSet);
		return categorie;
	}
}
