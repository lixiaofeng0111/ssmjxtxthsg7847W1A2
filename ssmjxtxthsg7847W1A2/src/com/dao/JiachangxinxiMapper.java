package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jiachangxinxi;

public interface JiachangxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jiachangxinxi record);

    int insertSelective(Jiachangxinxi record);

    Jiachangxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jiachangxinxi record);
	
    int updateByPrimaryKey(Jiachangxinxi record);
	public Jiachangxinxi quchongJiachangxinxi(Map<String, Object> yonghuming);
	public List<Jiachangxinxi> getAll(Map<String, Object> map);
	public List<Jiachangxinxi> getsyjiachangxinxi1(Map<String, Object> map);
	public List<Jiachangxinxi> getsyjiachangxinxi3(Map<String, Object> map);
	public List<Jiachangxinxi> getsyjiachangxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jiachangxinxi> getByPage(Map<String, Object> map);
	public List<Jiachangxinxi> select(Map<String, Object> map);
//	所有List
}

