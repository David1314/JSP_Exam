package com.yuxiaoli.servlet;

import java.io.IOException;
import java.sql.SQLException;
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
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			List<Film> filmList=sfs.queryAll();
			if(filmList!=null){
				req.setAttribute("list", filmList);
				req.getRequestDispatcher("list.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
