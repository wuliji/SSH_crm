	//使用ajax加载数据字典，生成select
	//参数一：数据字典类型(dict_type_code)
	//参数二：将下拉选放入的标签id
	//参数三：生成下拉选时，select标签的name属性值
	//参数四：需要回显时，选中哪个option
	function loadSelect(typeCode, positionId, selectName, selectedId){
		//1.创建select对象,将name属性指定
		var $select = $("<select name="+selectName+"></select>");
		//2.添加提示选项
		$select.append($("<option value=''>---请选择---</option>"));
		//3.使用jqeury的ajax方法，访问后台action
		$.post("${pageContext.request.contextPath}/BaseDictAction", { dict_type_code: typeCode},
		   function(data){
		     //遍历对象数组
		     $.each(data, function(i, json){
		    	 var $option = $("<option value='"+json['dict_id']+"'>"+json["dict_item_name"]+"</option>")
		    	 
		    	 if(json["dict_id"] == selectedId){
		    		 //判断是否需要回显，如果是则选中
		    		 $option.attr("selected","selected");
		    	 }
		    	 //添加到select对象
		    	 $select.append($option);
		    	});
		   },"json");
		//4.返回json数组对象，进行遍历并创建option对象，判断是否需要回显，并添加到select对象
		
		//5.将组装好的select对象放入页面指定位置
		$("#"+positionId).append($select);
	}
