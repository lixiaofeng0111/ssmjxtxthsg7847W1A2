package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Huida;

public interface HuidaServer {

  public int add(Huida po);

  public int update(Huida po);
  
  
  
  public int delete(int id);

  public List<Huida> getAll(Map<String,Object> map);
  public List<Huida> getsyhuida1(Map<String,Object> map);
  public List<Huida> getsyhuida2(Map<String,Object> map);
  public List<Huida> getsyhuida3(Map<String,Object> map);
  public Huida quchongHuida(Map<String, Object> acount);

  public Huida getById( int id);

  public List<Huida> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Huida> select(Map<String, Object> map);
}
//	所有List
