package com.yuxiaoli.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.yuxiaoli.dao.FilmDao;
import com.yuxiaoli.daoImpl.FilmDaoImpl;
import com.yuxiaoli.jdbcUtils.ConnectionFactory;

public class DeleteFilmService {
	FilmDao filmDao=new FilmDaoImpl();
	
	public int deleteFilm(int film_id) throws SQLException{
		Connection conn=null;
		int result=0;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			result = filmDao.deleteFilm(conn, film_id);
			
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
