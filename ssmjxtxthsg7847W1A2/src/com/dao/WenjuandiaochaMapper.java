package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Wenjuandiaocha;

public interface WenjuandiaochaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wenjuandiaocha record);

    int insertSelective(Wenjuandiaocha record);

    Wenjuandiaocha selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wenjuandiaocha record);
	
    int updateByPrimaryKey(Wenjuandiaocha record);
	public Wenjuandiaocha quchongWenjuandiaocha(Map<String, Object> faburen);
	public List<Wenjuandiaocha> getAll(Map<String, Object> map);
	public List<Wenjuandiaocha> getsywenjuandiaocha1(Map<String, Object> map);
	public List<Wenjuandiaocha> getsywenjuandiaocha3(Map<String, Object> map);
	public List<Wenjuandiaocha> getsywenjuandiaocha2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Wenjuandiaocha> getByPage(Map<String, Object> map);
	public List<Wenjuandiaocha> select(Map<String, Object> map);
//	所有List
}

