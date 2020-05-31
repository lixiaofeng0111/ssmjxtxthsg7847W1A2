package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Zuoye;

public interface ZuoyeServer {

  public int add(Zuoye po);

  public int update(Zuoye po);
  
  
  
  public int delete(int id);

  public List<Zuoye> getAll(Map<String,Object> map);
  public List<Zuoye> getsyzuoye1(Map<String,Object> map);
  public List<Zuoye> getsyzuoye2(Map<String,Object> map);
  public List<Zuoye> getsyzuoye3(Map<String,Object> map);
  public Zuoye quchongZuoye(Map<String, Object> acount);

  public Zuoye getById( int id);

  public List<Zuoye> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Zuoye> select(Map<String, Object> map);
}
//	所有List
