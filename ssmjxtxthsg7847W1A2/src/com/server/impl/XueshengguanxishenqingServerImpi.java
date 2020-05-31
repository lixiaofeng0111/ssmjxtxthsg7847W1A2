package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.XueshengguanxishenqingMapper;
import com.entity.Xueshengguanxishenqing;
import com.server.XueshengguanxishenqingServer;
@Service
public class XueshengguanxishenqingServerImpi implements XueshengguanxishenqingServer {
   @Resource
   private XueshengguanxishenqingMapper gdao;
	@Override
	public int add(Xueshengguanxishenqing po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xueshengguanxishenqing po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xueshengguanxishenqing> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xueshengguanxishenqing> getsyxueshengguanxishenqing1(Map<String, Object> map) {
		return gdao.getsyxueshengguanxishenqing1(map);
	}
	public List<Xueshengguanxishenqing> getsyxueshengguanxishenqing2(Map<String, Object> map) {
		return gdao.getsyxueshengguanxishenqing2(map);
	}
	public List<Xueshengguanxishenqing> getsyxueshengguanxishenqing3(Map<String, Object> map) {
		return gdao.getsyxueshengguanxishenqing3(map);
	}
	
	@Override
	public Xueshengguanxishenqing quchongXueshengguanxishenqing(Map<String, Object> account) {
		return gdao.quchongXueshengguanxishenqing(account);
	}

	@Override
	public List<Xueshengguanxishenqing> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xueshengguanxishenqing> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xueshengguanxishenqing getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

