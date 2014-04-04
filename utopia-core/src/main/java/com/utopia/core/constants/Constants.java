package com.utopia.core.constants;

public class Constants {

	
	public enum BooleanType{
		False,True
	}
	
	
	public enum LogStatusType{
		success,fail
	}
	
	public enum IncludedFormDisplayType{
		add,edit,report,all
	}
	/**
	 * @author salarkia
	 * person sex male or female 
	 */
	public enum Gender {
	male,female;
	}
	/**
	 * @author Arsalani
	 * Marital Status Single , Married , Widowed or Divorced
	 */
	public enum MaritalStatus {
		single,married,widowed,divorced;
	}
	
	/**
	 * @author Makiabadi
	 * Cm_Bpartner Type
	 * 
	 */
	public enum personType {
		employee,govermentLegalParty,privateLegalParty,realParty,stores,subcontractor,students,others;
	}
	
	public enum predefindedActions{
		noAction,save,delete,update,report,search,importData,process,view,clean,changePassword,download,config,confirm,changeOrganization,exportData,lock,unlock,updateFromDashboard;
		public static predefindedActions getAction(String actionName){
			predefindedActions a;
			try {
				a = Enum.valueOf(predefindedActions.class, actionName);
			} catch (Exception e) {
				return noAction;
			}
			return a == null ? noAction : a;
		}
		
		public static boolean isModifierAction(int actionId){
			return !((actionId==noAction.ordinal())||(actionId==report.ordinal())||
					(actionId==search.ordinal())||(actionId==importData.ordinal())||
					(actionId==view.ordinal())||(actionId==download.ordinal())||
					(actionId==exportData.ordinal()));
			
		}
	}
	public enum ImportFormat{
		excel/*,txt*/,sql;
		public static ImportFormat convert(int format){
			switch (format) {
			case 0:return excel;
			default:
				return sql;
			}
		}
		
	}
	public enum ReportType{
		pdf,excel,html,text 
	}
	public enum DisplayTypes{
		String,Integer,Date,LargeString,lookup,LOV,checkBox,RadioButton,list,
		upload,currencyField,IncludedGrid,password,Hidden;

		public static boolean isValueType(DisplayTypes displayType) {
			return !displayType.equals(lookup) && !displayType.equals(LOV);
		}
		public  boolean isLookup(){
			return this.equals(list)||this.equals(LOV)||this.equals(lookup);
		}
	}
	public enum MenuLinkTarget{
		top, frame, blank;
	}
	/**
	 * jsp file name and struts action delemeters
	 */
	public static final String JSP_SEPERATOR="_";
	
	public static final String REMOTE_CLASS_POSTFIX="FacadeRemote";
	
	public static final String USECASE_SEPERATOR="_";
	
	public static final String STRUTS_EXTENSION_NAME=".htm";
	
	public static final String STRUTS_AXAJ_EXTENSION=".json";
	
	public static final String REDIREDT_TO_PAGE_PREFIX="go";
	
	public static final String RIDIRECT_TO_PAGE_SEPERATOR="-";
	
	public static final int SYSTEM_PREFIX_LENGTH=2;
	
	public static final int SUBSYSTEM_PREFIX_LENGTH=2;
	
	public static final String PAGE_CONFIG_FORM_NAME="pageConfig";
	
	public static final String REQUESTED_PAGE_PARAMETER_NAME="requestedPage";
	/**
	 * maximum comma seperated ids in query supported
	 */
	public static final int MAXIMUM_COMMA_SEPERQTED_ID_IN_QUERY=1000; 
	
 
}
