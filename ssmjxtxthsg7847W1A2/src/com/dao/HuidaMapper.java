package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Huida;

public interface HuidaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Huida record);

    int insertSelective(Huida record);

    Huida selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huida record);
	
    int updateByPrimaryKey(Huida record);
	public Huida quchongHuida(Map<String, Object> yonghuming);
	public List<Huida> getAll(Map<String, Object> map);
	public List<Huida> getsyhuida1(Map<String, Object> map);
	public List<Huida> getsyhuida3(Map<String, Object> map);
	public List<Huida> getsyhuida2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Huida> getByPage(Map<String, Object> map);
	public List<Huida> select(Map<String, Object> map);
//	所有List
}

