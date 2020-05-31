package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Quxiaoguanxi;

public interface QuxiaoguanxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Quxiaoguanxi record);

    int insertSelective(Quxiaoguanxi record);

    Quxiaoguanxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Quxiaoguanxi record);
	
    int updateByPrimaryKey(Quxiaoguanxi record);
	public Quxiaoguanxi quchongQuxiaoguanxi(Map<String, Object> yonghuming);
	public List<Quxiaoguanxi> getAll(Map<String, Object> map);
	public List<Quxiaoguanxi> getsyquxiaoguanxi1(Map<String, Object> map);
	public List<Quxiaoguanxi> getsyquxiaoguanxi3(Map<String, Object> map);
	public List<Quxiaoguanxi> getsyquxiaoguanxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Quxiaoguanxi> getByPage(Map<String, Object> map);
	public List<Quxiaoguanxi> select(Map<String, Object> map);
//	所有List
}

