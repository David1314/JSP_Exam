package com.yuxiaoli.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuxiaoli.domain.Film;
import com.yuxiaoli.domain.Language;
import com.yuxiaoli.service.QueryLanguageByNameService;

public class QueryLanguageByNameServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8347588245123283774L;
	private QueryLanguageByNameService qfbns=new QueryLanguageByNameService();

	/**
	 * Constructor of the object.
	 */
	public QueryLanguageByNameServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String title=request.getParameter("title");
//		System.out.println(title);
		String description = request.getParameter("description");
		String name=request.getParameter("language");
		
		System.out.println(name);
		
		Language language=new Language();
		try {
			language=qfbns.queryLanguageByName(name);
			System.out.println(language.getLanguage_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(language!=null){
			request.setAttribute("title", title);
			request.setAttribute("description", description);
			request.setAttribute("language", language);
			request.getRequestDispatcher("/AddFilmServlet").forward(request, response);
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
