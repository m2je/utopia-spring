package com.utopia.common.model;

public enum SystemParameterType {

	Type_Integer,Type_long,Type_String;
	
//*****************************************************************************************************************************************************
		public  static Object getValueOf(String value,SystemParameterType type){
			if(value!=null&&value.trim().length()>0){
				switch (type) {
				case Type_Integer:
					return Integer.parseInt(value);
				case Type_long:
					return Long.parseLong(value);
				case Type_String:
					return value;	
				}
			}
			return null;
			}
			
}
