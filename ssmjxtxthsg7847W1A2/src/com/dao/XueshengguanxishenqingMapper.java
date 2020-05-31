package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xueshengguanxishenqing;

public interface XueshengguanxishenqingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xueshengguanxishenqing record);

    int insertSelective(Xueshengguanxishenqing record);

    Xueshengguanxishenqing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xueshengguanxishenqing record);
	
    int updateByPrimaryKey(Xueshengguanxishenqing record);
	public Xueshengguanxishenqing quchongXueshengguanxishenqing(Map<String, Object> yonghuming);
	public List<Xueshengguanxishenqing> getAll(Map<String, Object> map);
	public List<Xueshengguanxishenqing> getsyxueshengguanxishenqing1(Map<String, Object> map);
	public List<Xueshengguanxishenqing> getsyxueshengguanxishenqing3(Map<String, Object> map);
	public List<Xueshengguanxishenqing> getsyxueshengguanxishenqing2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xueshengguanxishenqing> getByPage(Map<String, Object> map);
	public List<Xueshengguanxishenqing> select(Map<String, Object> map);
//	所有List
}

