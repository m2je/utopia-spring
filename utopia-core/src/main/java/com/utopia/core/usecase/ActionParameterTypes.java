package com.utopia.core.usecase;

public  enum ActionParameterTypes {
		PropertyArray,//used in search as input property array
		PropertyValueArray,//used in search as input property value array
		PagingArray,//used in search for paging array
		PesistentObject,//used in save update and delete
		Nondefined,//unknown dataType
		processParameter,
		Context
}
