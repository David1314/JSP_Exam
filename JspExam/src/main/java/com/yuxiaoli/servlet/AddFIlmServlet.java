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
import com.yuxiaoli.service.AddFilmService;

public class AddFIlmServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4650807821042368351L;
	private AddFilmService afs=new AddFilmService();

	/**
	 * Constructor of the object.
	 */
	public AddFIlmServlet() {
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
		
		String title=(String) request.getAttribute("title");
		String description = (String) request.getAttribute("description");
		
		Language language=new Language();
		language=(Language) request.getAttribute("language");
		int language_id=language.getLanguage_id();
		
		Film film=new Film();
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguage_id(language_id);
		int result=0;
		try {
			 result=afs.addFilm(film);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result!=0){
			request.setAttribute("msg", "添加Film成功！");
			request.getRequestDispatcher("add_Film.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "添加Film失败！");
			request.getRequestDispatcher("add_Film.jsp").forward(request, response);
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
