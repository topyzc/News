package cn.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import cn.news.dao.UserDao;
import cn.news.dao.UserDaoImpl;
import cn.news.entities.User;







/**
 * Servlet implementation class Userservlet
 */
@WebServlet("*.action")
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDaoImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userservlet() {
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
		case "/login.action":
			try {
				checkLogin(req, resp);
			} catch (Exception e1) {
								
				e1.printStackTrace();
			}
			break;
		  case "/quit.action":
			try {
				quit(req, resp);
			} catch (Exception e1) {
								
				e1.printStackTrace();
			}
			break;
		
		default:
			break;
		}		
	}
	
    private void quit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	req.getSession().invalidate();
    	System.out.println(1);
    	
	}

	/**
     * 检查登录
     * @param req
     * @param resp
     * @throws Exception
     */
	private void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		User user=new User(username,password);
		user=userDao.checkLogin(user);
		System.out.println(user);
		if(user==null) {
			resp.getWriter().println("用户名，密码错误！");
		    resp.setHeader("refresh", "3;url=/News/mgr/login.jsp");
		}else {
			req.getSession().setAttribute("userForm", user);
			req.getRequestDispatcher("/mgr/main.jsp").forward(req, resp);
		}		
	}
	
	
}
