package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Wenjuandiaocha;

public interface WenjuandiaochaServer {

  public int add(Wenjuandiaocha po);

  public int update(Wenjuandiaocha po);
  
  
  
  public int delete(int id);

  public List<Wenjuandiaocha> getAll(Map<String,Object> map);
  public List<Wenjuandiaocha> getsywenjuandiaocha1(Map<String,Object> map);
  public List<Wenjuandiaocha> getsywenjuandiaocha2(Map<String,Object> map);
  public List<Wenjuandiaocha> getsywenjuandiaocha3(Map<String,Object> map);
  public Wenjuandiaocha quchongWenjuandiaocha(Map<String, Object> acount);

  public Wenjuandiaocha getById( int id);

  public List<Wenjuandiaocha> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Wenjuandiaocha> select(Map<String, Object> map);
}
//	所有List
