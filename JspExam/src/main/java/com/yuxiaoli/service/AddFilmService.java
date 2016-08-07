package com.yuxiaoli.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.yuxiaoli.dao.FilmDao;
import com.yuxiaoli.daoImpl.FilmDaoImpl;
import com.yuxiaoli.domain.Film;
import com.yuxiaoli.jdbcUtils.ConnectionFactory;

public class AddFilmService {
	FilmDao filmDao=new FilmDaoImpl();
	
	public int addFilm(Film film) throws SQLException{
		Connection conn=null;
		int result=0;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			result = filmDao.addFilm(conn, film);
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally{
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
}
