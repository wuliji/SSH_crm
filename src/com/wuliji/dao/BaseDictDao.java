package com.wuliji.dao;

import java.util.List;

import com.wuliji.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict>{
	
	/**
	 * 根据类型获得数据字典列表
	 * @param dict_type_code
	 */
	List<BaseDict> findListByTypeCode(String dict_type_code);
	
	
	
}
