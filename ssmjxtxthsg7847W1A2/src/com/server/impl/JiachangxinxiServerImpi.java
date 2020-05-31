package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JiachangxinxiMapper;
import com.entity.Jiachangxinxi;
import com.server.JiachangxinxiServer;
@Service
public class JiachangxinxiServerImpi implements JiachangxinxiServer {
   @Resource
   private JiachangxinxiMapper gdao;
	@Override
	public int add(Jiachangxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jiachangxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jiachangxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jiachangxinxi> getsyjiachangxinxi1(Map<String, Object> map) {
		return gdao.getsyjiachangxinxi1(map);
	}
	public List<Jiachangxinxi> getsyjiachangxinxi2(Map<String, Object> map) {
		return gdao.getsyjiachangxinxi2(map);
	}
	public List<Jiachangxinxi> getsyjiachangxinxi3(Map<String, Object> map) {
		return gdao.getsyjiachangxinxi3(map);
	}
	
	@Override
	public Jiachangxinxi quchongJiachangxinxi(Map<String, Object> account) {
		return gdao.quchongJiachangxinxi(account);
	}

	@Override
	public List<Jiachangxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jiachangxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jiachangxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

