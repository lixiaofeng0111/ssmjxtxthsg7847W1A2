package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Quxiaoguanxi;

public interface QuxiaoguanxiServer {

  public int add(Quxiaoguanxi po);

  public int update(Quxiaoguanxi po);
  
  
  
  public int delete(int id);

  public List<Quxiaoguanxi> getAll(Map<String,Object> map);
  public List<Quxiaoguanxi> getsyquxiaoguanxi1(Map<String,Object> map);
  public List<Quxiaoguanxi> getsyquxiaoguanxi2(Map<String,Object> map);
  public List<Quxiaoguanxi> getsyquxiaoguanxi3(Map<String,Object> map);
  public Quxiaoguanxi quchongQuxiaoguanxi(Map<String, Object> acount);

  public Quxiaoguanxi getById( int id);

  public List<Quxiaoguanxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Quxiaoguanxi> select(Map<String, Object> map);
}
//	所有List
