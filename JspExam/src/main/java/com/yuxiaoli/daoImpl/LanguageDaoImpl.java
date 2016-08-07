package com.yuxiaoli.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yuxiaoli.dao.LanguageDao;
import com.yuxiaoli.domain.Film;
import com.yuxiaoli.domain.Language;

public class LanguageDaoImpl implements LanguageDao {

	public List<String> queryAllLanguageName(Connection conn)
			throws SQLException {
		PreparedStatement ps=conn.prepareStatement("select distinct name from language");
		ResultSet rs=ps.executeQuery();
		List<String> list=new ArrayList<String>();
		while(rs.next()){
			list.add(rs.getString(1));
		}
		return list;
	}

	public Language queryLanguageByName(Connection conn, String name)
			throws SQLException {
		PreparedStatement ps=conn.prepareStatement("select language_id from language where name= ?");
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		Language language=new Language();
		if(rs.next()){
			language.setLanguage_id(rs.getInt(1));
		}
		rs.close();
		ps.close();
		return language;
	}

}
