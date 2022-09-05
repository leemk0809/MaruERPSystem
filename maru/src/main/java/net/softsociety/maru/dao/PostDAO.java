package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.Post;

@Mapper
public interface PostDAO {
	
	int insert(Post post);
	
	int delete(int post_num);
	
	int update(Post post);
	
	Post selectOne(int post_num);
	
	ArrayList<Post> selectAll();
}
