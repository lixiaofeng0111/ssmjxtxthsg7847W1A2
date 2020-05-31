package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.KaoshianpaiMapper;
import com.entity.Kaoshianpai;
import com.server.KaoshianpaiServer;
@Service
public class KaoshianpaiServerImpi implements KaoshianpaiServer {
   @Resource
   private KaoshianpaiMapper gdao;
	@Override
	public int add(Kaoshianpai po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Kaoshianpai po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Kaoshianpai> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Kaoshianpai> getsykaoshianpai1(Map<String, Object> map) {
		return gdao.getsykaoshianpai1(map);
	}
	public List<Kaoshianpai> getsykaoshianpai2(Map<String, Object> map) {
		return gdao.getsykaoshianpai2(map);
	}
	public List<Kaoshianpai> getsykaoshianpai3(Map<String, Object> map) {
		return gdao.getsykaoshianpai3(map);
	}
	
	@Override
	public Kaoshianpai quchongKaoshianpai(Map<String, Object> account) {
		return gdao.quchongKaoshianpai(account);
	}

	@Override
	public List<Kaoshianpai> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Kaoshianpai> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Kaoshianpai getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

