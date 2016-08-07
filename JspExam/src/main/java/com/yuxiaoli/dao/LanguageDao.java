package com.yuxiaoli.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.yuxiaoli.domain.Language;

public interface LanguageDao {
	public List<String> queryAllLanguageName(Connection conn) throws SQLException;
	
	public Language queryLanguageByName(Connection conn,String name) throws SQLException;
}
