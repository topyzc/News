package cn.news.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.news.dao.CategoryDao;
import cn.news.dao.CategoryDaoImpl;
import cn.news.entities.Categories;

@WebServlet("*.cat")
public class CategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CategoryDao catDao = new CategoryDaoImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
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
		case "/query.cat":try {
				queryAll(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			  break;
		case "/add.cat":
			try {
				addcat(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/update.cat":
			try {
				updatecat(req, resp);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			break;
		case "/delete.cat":
			try {
				deletecat(req, resp);
			} catch (Exception e) {
								
				e.printStackTrace();
			}
			break;
		case "/edit.cat":
			try {
				edit(req, resp);
			} catch (Exception e) {
								
				e.printStackTrace();
			}
			break;
		default:
			break;
		}		
	}
	public void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String ids = req.getParameter("id");
		int id = Integer.valueOf(ids);
		String name = req.getParameter("topicName");
		Categories categories = new Categories(id,name);
		catDao.update(categories);
		System.out.println(categories);
		resp.sendRedirect("/News/query.cat");		
	}

	/**
	 * 删除主题
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void deletecat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ids=req.getParameter("id");
		int id=Integer.valueOf(ids);
		catDao.delete(id);
		resp.sendRedirect("/News/query.cat");
		
	}

	/**
	 * 修改主题
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void updatecat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ids = req.getParameter("id");
		int id = Integer.valueOf(ids);
		Categories categories = catDao.getEntity(id);
		System.out.println(categories);
		req.setAttribute("cis", categories);
		req.getRequestDispatcher("/mgr/updatezhuti.jsp").forward(req, resp);
	}

	/**
	 * 添加主题
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void addcat(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String name = req.getParameter("topicName");
		String ids=req.getParameter("topicId");
		int id=Integer.valueOf(ids);
	    System.out.println(name+id);
		Categories couForm =new Categories(id,name);
		catDao.add(couForm);
		System.out.println(couForm);
		//req.setAttribute("catForms", couForm);
		resp.sendRedirect("/News/query.cat");	
	}
	
	/**
	 * 查询主题
	 * @param request
	 * @param responseo
	 * @throws Exception
	 */
	public void queryAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Categories> catForms = catDao.queryAll();
		request.setAttribute("catForms", catForms);
		request.getRequestDispatcher("/mgr/main.jsp").forward(request, response);
	}  
}
