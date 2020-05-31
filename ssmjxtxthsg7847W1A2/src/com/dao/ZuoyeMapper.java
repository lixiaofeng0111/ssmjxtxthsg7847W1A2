package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zuoye;

public interface ZuoyeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zuoye record);

    int insertSelective(Zuoye record);

    Zuoye selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zuoye record);
	
    int updateByPrimaryKey(Zuoye record);
	public Zuoye quchongZuoye(Map<String, Object> faburen);
	public List<Zuoye> getAll(Map<String, Object> map);
	public List<Zuoye> getsyzuoye1(Map<String, Object> map);
	public List<Zuoye> getsyzuoye3(Map<String, Object> map);
	public List<Zuoye> getsyzuoye2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zuoye> getByPage(Map<String, Object> map);
	public List<Zuoye> select(Map<String, Object> map);
//	所有List
}

