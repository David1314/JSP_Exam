package com.yuxiaoli.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.yuxiaoli.dao.FilmDao;
import com.yuxiaoli.dao.LanguageDao;
import com.yuxiaoli.daoImpl.FilmDaoImpl;
import com.yuxiaoli.daoImpl.LanguageDaoImpl;
import com.yuxiaoli.domain.Film;
import com.yuxiaoli.domain.Language;
import com.yuxiaoli.jdbcUtils.ConnectionFactory;

public class QueryLanguageByNameService {
	LanguageDao languageDao=new LanguageDaoImpl();
	
	public Language queryLanguageByName(String name) throws SQLException{
		Connection conn=null;
		Language language=new Language();
//		System.out.println("=======");
		try {
//			System.out.println("=======");
			conn = ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			language=languageDao.queryLanguageByName(conn, name);
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
		return language;
	}
}
