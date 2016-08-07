package com.yuxiaoli.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuxiaoli.domain.Customer;
import com.yuxiaoli.service.CheckUserService;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 5557555243445488514L;
	private CheckUserService cus=new CheckUserService();
	
	
	public LoginServlet() {
	}

	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String name=req.getParameter("username");
		//System.out.println(name);
		if(name==null){
			req.setAttribute("msg",	"请先登录！");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else{
			
			Customer user=new Customer();
			user.setFirst_name(name);
			System.out.println(user.getFirst_name());
			
			boolean bool=cus.check(user);
			
			System.out.println("bool="+bool);
			
			if(bool){
				req.getSession().setAttribute("username", name);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}else{
				req.setAttribute("msg", "用户名或密码错误！");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	
	
	
}
