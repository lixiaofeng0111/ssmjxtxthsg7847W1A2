package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.WenjuandiaochaMapper;
import com.entity.Wenjuandiaocha;
import com.server.WenjuandiaochaServer;
@Service
public class WenjuandiaochaServerImpi implements WenjuandiaochaServer {
   @Resource
   private WenjuandiaochaMapper gdao;
	@Override
	public int add(Wenjuandiaocha po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Wenjuandiaocha po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Wenjuandiaocha> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Wenjuandiaocha> getsywenjuandiaocha1(Map<String, Object> map) {
		return gdao.getsywenjuandiaocha1(map);
	}
	public List<Wenjuandiaocha> getsywenjuandiaocha2(Map<String, Object> map) {
		return gdao.getsywenjuandiaocha2(map);
	}
	public List<Wenjuandiaocha> getsywenjuandiaocha3(Map<String, Object> map) {
		return gdao.getsywenjuandiaocha3(map);
	}
	
	@Override
	public Wenjuandiaocha quchongWenjuandiaocha(Map<String, Object> account) {
		return gdao.quchongWenjuandiaocha(account);
	}

	@Override
	public List<Wenjuandiaocha> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Wenjuandiaocha> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Wenjuandiaocha getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

