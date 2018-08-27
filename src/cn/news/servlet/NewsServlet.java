package cn.news.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.news.dao.CategoryDao;
import cn.news.dao.CategoryDaoImpl;
import cn.news.dao.NewsDao;
import cn.news.dao.NewsDaoImpl;
import cn.news.entities.CateNew;
import cn.news.entities.Categories;
import cn.news.entities.News;


@WebServlet("*.new")
public class NewsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private NewsDao newDao = new NewsDaoImpl(); 
	private CategoryDao catDao = new CategoryDaoImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			this.doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws ServletException 
	 * @throws Exception 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		String methhod = req.getMethod();
		/**
		 * 乱码处理
		 */
		// 设置请求的编码 一般用于post请求乱码的处理
		if ("POST".equals(methhod)) {
			try {
				req.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			resp.setCharacterEncoding("utf-8");
		}
		// 获得请求名 --获得action的值
		String url = req.getServletPath();
		switch (url) {
		case "/query.new":try {
	
				queryAll(req, resp);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			  break;
		case "/querynewsid.new":try {
			
			querynewsid(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  break;
       case "/querys.new":try {
			
			querysnew(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  break;
       case "/delete.new":try {
			
			deletenew(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  break;
       case "/addnew.new":try {
			
    	   addnew(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  break;
       case "/add.new":try {
			
    	   add(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  break;
       case "/update.new":try {
			
    	   update(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  break;
       case "/edit.new":try {
			
    	   edit(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  break;
		default:
			break;
		}		
	}
	
	private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String ids = req.getParameter("newsId");
		int id = Integer.valueOf(ids);
		String name = req.getParameter("newsName");
		String text = req.getParameter("newsText");
		String idss = req.getParameter("topicId");
		int topicId = Integer.valueOf(idss);
	    News news=new News(id, name, text, topicId,new Date());
		newDao.update(news);
		System.out.println(news);
		resp.sendRedirect("/News/query.cat");		
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ids = req.getParameter("id");
		int id = Integer.valueOf(ids);
		News news = newDao.getEntity(id);
		System.out.println(news);
		req.setAttribute("news", news);
		req.getRequestDispatcher("/mgr/updatenew.jsp").forward(req, resp);
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("newsName");
		String text=req.getParameter("newsText");
		String ids=req.getParameter("id");
		int id=Integer.getInteger(ids);
	     System.out.println(id);
		News news=new News(name, text, id,new Date());
		System.out.println(news);
		newDao.add(news);
		 
     req.getRequestDispatcher("/mgr/main.jsp").forward(req, resp);
		
	}

	private void addnew(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Categories> catForms = catDao.queryAll();
		req.setAttribute("catForms", catForms);
		
		req.getRequestDispatcher("/mgr/addnew.jsp").forward(req, resp);
	
	}

	/**
	 * 管理员删除
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void deletenew(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String ids=req.getParameter("id");
		int id=Integer.valueOf(ids);
		newDao.delete(id);
		req.getRequestDispatcher("/mgr/main.jsp").forward(req, resp);
	}

	/**
	 * 管理员查询
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void querysnew(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<News> stuForms = newDao.queryAll();
		req.setAttribute("stuForms", stuForms);
		req.getRequestDispatcher("/mgr/news.jsp").forward(req, resp);		
	}
    
	/**
	 * 通过 newsId 查询
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void querynewsid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int nid=Integer.valueOf(id);
		List<News> newF =newDao.querynewId(nid);
		req.setAttribute("newF", newF);
		req.getRequestDispatcher("/rop.jsp").forward(req, resp);		
	}
     
	/**
	 * 通过topicId 查询
	 * @param request
	 * @param responseo
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws Exception
	 */
	public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String id = request.getParameter("id");
		int cid=Integer.valueOf(id);
		List<News> newForms =newDao.queryAll(cid);
		request.setAttribute("newForms", newForms);
		request.getRequestDispatcher("/title.jsp").forward(request, response);
	}
	
}
