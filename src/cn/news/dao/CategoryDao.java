package cn.news.dao;

import java.util.List;



import cn.news.entities.Categories;






public interface CategoryDao {

	int add(Categories categorie);
	int delete(int id);
	int update(Categories categorie);
	List<Categories> queryAll();
	
	Categories getEntity(int id);
}
