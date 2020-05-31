package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Kaoshianpai;

public interface KaoshianpaiServer {

  public int add(Kaoshianpai po);

  public int update(Kaoshianpai po);
  
  
  
  public int delete(int id);

  public List<Kaoshianpai> getAll(Map<String,Object> map);
  public List<Kaoshianpai> getsykaoshianpai1(Map<String,Object> map);
  public List<Kaoshianpai> getsykaoshianpai2(Map<String,Object> map);
  public List<Kaoshianpai> getsykaoshianpai3(Map<String,Object> map);
  public Kaoshianpai quchongKaoshianpai(Map<String, Object> acount);

  public Kaoshianpai getById( int id);

  public List<Kaoshianpai> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Kaoshianpai> select(Map<String, Object> map);
}
//	所有List
