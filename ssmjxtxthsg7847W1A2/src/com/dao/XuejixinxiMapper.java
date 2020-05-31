package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xuejixinxi;

public interface XuejixinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xuejixinxi record);

    int insertSelective(Xuejixinxi record);

    Xuejixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xuejixinxi record);
	
    int updateByPrimaryKey(Xuejixinxi record);
	public Xuejixinxi quchongXuejixinxi(Map<String, Object> gonghao);
	public List<Xuejixinxi> getAll(Map<String, Object> map);
	public List<Xuejixinxi> getsyxuejixinxi1(Map<String, Object> map);
	public List<Xuejixinxi> getsyxuejixinxi3(Map<String, Object> map);
	public List<Xuejixinxi> getsyxuejixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xuejixinxi> getByPage(Map<String, Object> map);
	public List<Xuejixinxi> select(Map<String, Object> map);
//	所有List
}

