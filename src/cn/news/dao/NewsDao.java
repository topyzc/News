package cn.news.dao;

import java.util.List;
import cn.news.entities.CateNew;
import cn.news.entities.News;



public interface NewsDao {
  
	int add(News news);
	void delete(int id);
	int update(News news);
	List<CateNew> query();
	List<News> queryAll(int cid);
	List<News> querynewId(int nid);
	List<News> queryAll();
	News getEntity(int id);
}
