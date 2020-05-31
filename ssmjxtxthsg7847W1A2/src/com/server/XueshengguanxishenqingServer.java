package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xueshengguanxishenqing;

public interface XueshengguanxishenqingServer {

  public int add(Xueshengguanxishenqing po);

  public int update(Xueshengguanxishenqing po);
  
  
  
  public int delete(int id);

  public List<Xueshengguanxishenqing> getAll(Map<String,Object> map);
  public List<Xueshengguanxishenqing> getsyxueshengguanxishenqing1(Map<String,Object> map);
  public List<Xueshengguanxishenqing> getsyxueshengguanxishenqing2(Map<String,Object> map);
  public List<Xueshengguanxishenqing> getsyxueshengguanxishenqing3(Map<String,Object> map);
  public Xueshengguanxishenqing quchongXueshengguanxishenqing(Map<String, Object> acount);

  public Xueshengguanxishenqing getById( int id);

  public List<Xueshengguanxishenqing> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xueshengguanxishenqing> select(Map<String, Object> map);
}
//	所有List
