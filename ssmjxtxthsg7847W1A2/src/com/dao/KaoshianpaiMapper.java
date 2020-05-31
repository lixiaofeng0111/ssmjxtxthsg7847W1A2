package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Kaoshianpai;

public interface KaoshianpaiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kaoshianpai record);

    int insertSelective(Kaoshianpai record);

    Kaoshianpai selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kaoshianpai record);
	
    int updateByPrimaryKey(Kaoshianpai record);
	public Kaoshianpai quchongKaoshianpai(Map<String, Object> faburen);
	public List<Kaoshianpai> getAll(Map<String, Object> map);
	public List<Kaoshianpai> getsykaoshianpai1(Map<String, Object> map);
	public List<Kaoshianpai> getsykaoshianpai3(Map<String, Object> map);
	public List<Kaoshianpai> getsykaoshianpai2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Kaoshianpai> getByPage(Map<String, Object> map);
	public List<Kaoshianpai> select(Map<String, Object> map);
//	所有List
}

