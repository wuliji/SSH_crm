package com.wuliji.service;

import java.util.List;

import com.wuliji.domain.BaseDict;

public interface BaseDictService {
	
	/**
	 * ���������ֵ������ֶλ�������ֵ����
	 * @param dict_type_code
	 * @return
	 */
	List<BaseDict> findListByTypeCode(String dict_type_code);
	
}
