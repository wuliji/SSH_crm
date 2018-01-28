package com.wuliji.service.impl;

import java.util.List;

import com.wuliji.dao.BaseDictDao;
import com.wuliji.domain.BaseDict;
import com.wuliji.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService{

	private BaseDictDao bdd;
	
	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}

	@Override
	public List<BaseDict> findListByTypeCode(String dict_type_code) {
		List<BaseDict> list = bdd.findListByTypeCode(dict_type_code);
		return list;
	}

}
