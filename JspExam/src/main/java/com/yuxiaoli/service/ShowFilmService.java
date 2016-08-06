package com.yuxiaoli.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yuxiaoli.dao.FilmDao;
import com.yuxiaoli.daoImpl.FilmDaoImpl;
import com.yuxiaoli.domain.Film;
import com.yuxiaoli.jdbcUtils.ConnectionFactory;

public class ShowFilmService {
	FilmDao filmDao=new FilmDaoImpl();
	
	public List<Film> queryAll() throws SQLException{
		Connection conn=null;
		List<Film> list=new ArrayList<Film>();
//		System.out.println("=======");
		try {
//			System.out.println("=======");
			conn = ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			list=filmDao.queryAll(conn);
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
		return list;
	}
}
