package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.Worker;

@Mapper
public interface WorkerDao {
	
	public int insert(Worker worker);
	
	public int delete(int worker_num);
	
	public int update(Worker worker);
	
	public Worker selectOne(int worker_num);
	
	public ArrayList<Worker> selectAll();	
}
