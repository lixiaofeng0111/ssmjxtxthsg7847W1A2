package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HuidaMapper;
import com.entity.Huida;
import com.server.HuidaServer;
@Service
public class HuidaServerImpi implements HuidaServer {
   @Resource
   private HuidaMapper gdao;
	@Override
	public int add(Huida po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Huida po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Huida> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Huida> getsyhuida1(Map<String, Object> map) {
		return gdao.getsyhuida1(map);
	}
	public List<Huida> getsyhuida2(Map<String, Object> map) {
		return gdao.getsyhuida2(map);
	}
	public List<Huida> getsyhuida3(Map<String, Object> map) {
		return gdao.getsyhuida3(map);
	}
	
	@Override
	public Huida quchongHuida(Map<String, Object> account) {
		return gdao.quchongHuida(account);
	}

	@Override
	public List<Huida> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Huida> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Huida getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

