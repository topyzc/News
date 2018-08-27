package cn.news.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cn.news.entities.CateNew;
import cn.news.entities.News;
import cn.news.util.DBUtils;

public class NewsDaoImpl implements NewsDao{
	private DBUtils util = new DBUtils();
	private List<News> nws;
	private List<CateNew> cns;
	private News nw;
	private CateNew cn;
	
	/**
	 * 添加新闻
	 */
	@Override
	public int add(News news) {
		String sql = "insert into newstit(newsName,newsText,newsTime) value(?,?,?)";
		Object objs[] = {news.getNewsName(),news.getNewsText(),news.getNewsTime()};
		
		return util.getCount(sql, objs);
	}
    /**
     * 删除新闻
     */
	@Override
	public void delete(int id) {
		System.out.println(id);
		String sql = "delete from newstit where newsId=?";
		Object objs[] = { id };
		util.doSql(sql, objs);
	}
    /**
     * 通过newsId=？ 更新的新闻
     */
	@Override
	public int update(News news) {
		String sql = "update newstit set newsName=?,newsText=?,topicId=?,newsTime=? where newsId=?";
		Object objs[] = { news.getNewsName(),news.getNewsText(),news.getTopicId(),news.getNewsTime(),news.getNewsId()
			};
		return util.getCount(sql, objs);
	}
    /**
     * 通过topicid=? 查询的新闻
     */
	@Override
	public List<News> queryAll(int cid) {
		String sql = "select * from newstit where topicId=? ";
		Object objs[] = {cid};
		ResultSet rs = util.getResultSet(sql, objs);
		rsToList(rs);
		return nws;
	}

	private void rsToList(ResultSet rs) {
		nws = new ArrayList<>();
		nw = null;
		try {
			while (rs.next()) {
				int nid = rs.getInt("newsId");
				String name = rs.getString("newsName");
				String text=rs.getString("newsText");
				int tid=rs.getInt("topicId");
				
				Date time=rs.getDate("newsTime");
				nw = new News(nid,name,text,tid,time);
				nws.add(nw);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void rsToList1(ResultSet rs) {
		cns = new ArrayList<>();
		cn = null;
		try {
			while (rs.next()) {
				int nid = rs.getInt("newsId");
				String name = rs.getString("newsName");
				String text=rs.getString("newsText");
				int topid=rs.getInt("topicId") ;
				String topicName=rs.getString("topicName");
				Date time=rs.getDate("newsTime");
				cn = new CateNew(nid,name,text,topid,topicName,time);
				cns.add(cn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关联两表查询所有
	 */
	@Override
	public List<CateNew> query() {
		String sql = "select * from newstit n,categories c where n.topicId=c.topicId order by newsTime desc";
		Object objs[] = {};
		ResultSet rs = util.getResultSet(sql, objs);
		rsToList1(rs);
		return cns;
	}
	/**
	 * 通过newsId=？ 查询新闻
	 */
	@Override
	public List<News> querynewId(int nid) {
		String sql = "select * from newstit where newsId=? ";
		Object objs[] = {nid};
		ResultSet rs = util.getResultSet(sql, objs);
		rsToList(rs);
		return nws;
	}
    
	/**
	 * 查询所有新闻
	 */
	@Override
	public List<News> queryAll() {
		String sql = "select * from newstit  ";
		Object objs[] = {};
		ResultSet rs = util.getResultSet(sql, objs);
		rsToList(rs);
		return nws;
	}
	@Override
	public News getEntity(int id) {
		String sql = "select * from newstit where newsId=?";
		Object objects[] = { id };
		ResultSet resultSet = util.getResultSet(sql, objects);
		rsToList(resultSet);
		return nw;
	}
}
