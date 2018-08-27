package cn.news.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.news.dao.NewsDao;
import cn.news.dao.NewsDaoImpl;
import cn.news.entities.CateNew;
import cn.news.entities.News;



public class MainServlet  extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private NewsDao catDao = new NewsDaoImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
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
	 * @throws IOException 
	 * @throws Exception 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			
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
		case "/":try {
	
				query(req, resp);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			  break;
	     
		default:
			break;
		}		
	}
	/**
	 * 使用中间表查询
	 * @param request
	 * @param responseo
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws Exception
	 */
	public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		List<CateNew> newFor = catDao.query();
		request.setAttribute("newFor", newFor);
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}
	
}
