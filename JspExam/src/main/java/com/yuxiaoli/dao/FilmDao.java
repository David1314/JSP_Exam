package com.yuxiaoli.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.yuxiaoli.domain.Film;

public interface FilmDao {
	public List<Film> queryAll(Connection conn) throws SQLException;
}
