package net.softsociety.maru.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.Position;

@Mapper
public interface PositionDAO {
	int insert(Position p);
	int delete(int position_num);
	int update(Position p);
	List<Position> selectAll();
	Position selectOne(int position_num);
}
