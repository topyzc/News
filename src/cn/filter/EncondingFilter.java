package cn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//乱码处理方法
@WebFilter("/*")
public class EncondingFilter implements Filter{

	@Override
	public void destroy() {
				
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;	
		HttpServletResponse resp=(HttpServletResponse) response;
	          
		req.setCharacterEncoding("UTF-8");  
		resp.setCharacterEncoding("UTF-8"); 
	          
	    chain.doFilter(request, response); 	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
				
	}

}
