package com.yuxiaoli.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yuxiaoli.dao.LanguageDao;
import com.yuxiaoli.daoImpl.LanguageDaoImpl;
import com.yuxiaoli.domain.Film;
import com.yuxiaoli.jdbcUtils.ConnectionFactory;

public class ShowLanguageNameService {
	LanguageDao languageDao=new LanguageDaoImpl();
	
	public List<String> queryAllLanuageName() throws SQLException{
		Connection conn=null;
		List<String> list=new ArrayList<String>();
//		System.out.println("=======");
		try {
//			System.out.println("=======");
			conn = ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			list=languageDao.queryAllLanguageName(conn);
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
