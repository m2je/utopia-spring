package com.utopia.core.constants;

public enum QueryComparsionType{
		eqaul,greater,greaterOrEqual,lessThan,lessThanOrEqual,like,opposite,in;
		
		
	public  String getComparisonSign(){
			if(QueryComparsionType.eqaul.equals(this)){
				return " = ";
			}else if(QueryComparsionType.greater.equals(this)){
				return " > ";
			}else if(QueryComparsionType.lessThan.equals(this)){
				return " < ";
			}else if(QueryComparsionType.like.equals(this)){
				return " like ";
			}else if(QueryComparsionType.greaterOrEqual.equals(this)){
				return " >= ";
			}else if(QueryComparsionType.lessThanOrEqual.equals(this)){
				return " <= ";
			}else if(QueryComparsionType.in.equals(this)){
				return " in ";
			}
			else {
				return " <> ";
			}
	}
}