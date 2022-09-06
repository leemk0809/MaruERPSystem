package net.softsociety.maru.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.CommitWorker;
import net.softsociety.maru.domain.FundsType;

@Mapper
public interface FundsTypeDAO {
	int insert(FundsType ft);
	int delete(int funds_type_num);
	int update(FundsType cw);
	List<FundsType> selectAll();
	FundsType selectOne(int funds_type_num);
}
