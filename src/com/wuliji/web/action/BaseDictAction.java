package com.wuliji.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wuliji.domain.BaseDict;
import com.wuliji.service.BaseDictService;

import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport{
	
	private String dict_type_code;
	
	private BaseDictService bds;
	
	@Override
	public String execute() throws Exception {
		//1.调用Service根据typecode获得数据字典对象list
		List<BaseDict> list = bds.findListByTypeCode(dict_type_code);
		//2.将list转换为json数据
		String json = JSONArray.fromObject(list).toString();
		//3.将json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;//告诉struts2 不需要进行结果处理
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public String getDict_type_code() {
		return dict_type_code;
	}

	public void setBds(BaseDictService bds) {
		this.bds = bds;
	}

	
}
