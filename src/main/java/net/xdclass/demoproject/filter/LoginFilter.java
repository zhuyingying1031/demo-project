package net.xdclass.demoproject.filter;

import net.xdclass.demoproject.domain.User;
import net.xdclass.demoproject.service.impl.UserServiceImpl;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/api/v1/pri/*",filterName = "loginFilter")
public class LoginFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		System.out.println("int Loginfilter++++++++++");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("doFilter Loginfilter++++++++++");
		HttpServletRequest req =(HttpServletRequest) servletRequest;
		HttpServletResponse resp =(HttpServletResponse) servletResponse;
		String token =req.getHeader("token");
		if (StringUtils.isEmpty(token)){
			token=req.getParameter("token");
		}
		if (StringUtils.isEmpty(token)){
			return;
		}else {
			User user=UserServiceImpl.sessionMap.get(token);
			if (user!=null){

				filterChain.doFilter(servletRequest,servletResponse);
			}

		}

	}

	@Override
	public void destroy() {
		System.out.println("destroy Loginfilter++++++++++");
	}
}
