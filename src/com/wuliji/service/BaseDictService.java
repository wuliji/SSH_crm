package com.wuliji.service;

import java.util.List;

import com.wuliji.domain.BaseDict;

public interface BaseDictService {
	
	/**
	 * 根据数据字典类型字段获得数据字典对象
	 * @param dict_type_code
	 * @return
	 */
	List<BaseDict> findListByTypeCode(String dict_type_code);
	
}
