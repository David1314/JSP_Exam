package com.yuxiaoli.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuxiaoli.daoImpl.FilmDaoImpl;
import com.yuxiaoli.domain.Film;
import com.yuxiaoli.service.ShowFilmService;

public class ShowFilmServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1576892507472907746L;
	private ShowFilmService sfs=new ShowFilmService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		
			List<Film> filmList=new ArrayList<Film>();
			try {
				filmList=sfs.queryAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(filmList!=null){
				req.setAttribute("filmList", filmList);
//				System.out.println("======");
				req.getRequestDispatcher("list.jsp").forward(req, resp);
			}
		
	}

}
