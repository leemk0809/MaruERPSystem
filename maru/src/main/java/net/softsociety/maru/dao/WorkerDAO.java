package net.softsociety.maru.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.Division;
import net.softsociety.maru.domain.Worker;

@Mapper
public interface WorkerDAO {
	
	public int insertWorker(Worker worker);
	
	public int deleteWorker(int worker_num);
	
	public int updateWorker(Worker worker);
	
	public Worker selectOneWorker(int worker_num);
	
	public ArrayList<Worker> selectAllWorker(int division_num);

	public List<Worker> selectAll();	
	
	
}
