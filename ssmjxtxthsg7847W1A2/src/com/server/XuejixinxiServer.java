package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xuejixinxi;

public interface XuejixinxiServer {

  public int add(Xuejixinxi po);

  public int update(Xuejixinxi po);
  
  
  
  public int delete(int id);

  public List<Xuejixinxi> getAll(Map<String,Object> map);
  public List<Xuejixinxi> getsyxuejixinxi1(Map<String,Object> map);
  public List<Xuejixinxi> getsyxuejixinxi2(Map<String,Object> map);
  public List<Xuejixinxi> getsyxuejixinxi3(Map<String,Object> map);
  public Xuejixinxi quchongXuejixinxi(Map<String, Object> acount);

  public Xuejixinxi getById( int id);

  public List<Xuejixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xuejixinxi> select(Map<String, Object> map);
}
//	所有List
