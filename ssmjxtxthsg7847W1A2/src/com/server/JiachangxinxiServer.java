package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jiachangxinxi;

public interface JiachangxinxiServer {

  public int add(Jiachangxinxi po);

  public int update(Jiachangxinxi po);
  
  
  
  public int delete(int id);

  public List<Jiachangxinxi> getAll(Map<String,Object> map);
  public List<Jiachangxinxi> getsyjiachangxinxi1(Map<String,Object> map);
  public List<Jiachangxinxi> getsyjiachangxinxi2(Map<String,Object> map);
  public List<Jiachangxinxi> getsyjiachangxinxi3(Map<String,Object> map);
  public Jiachangxinxi quchongJiachangxinxi(Map<String, Object> acount);

  public Jiachangxinxi getById( int id);

  public List<Jiachangxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jiachangxinxi> select(Map<String, Object> map);
}
//	所有List
