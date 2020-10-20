package com.bjp.constant;

public class HouseholdConstant {
	/**
	 * 家庭入世系申请： 初始状态为0，说明家庭进行入世申请；1代表已入世标志(先进入族谱)
	 */
	public final static int HOUSEHOLDMEMBER_ASK_GENEALOGY_STARTED = 0;
	public final static int HOUSEHOLDMEMBER_ASK_GENEALOGY_ENTERED = 1;
	
	/**
	 * 逻辑删除标志：初始状态为0，说明未删除；1代表已删除
	 */
	public final static int HOUSEHOLDMEMBER_NOT_DELETE = 0;
	public final static int HOUSEHOLDMEMBER_DELETED = 1;
	/**
	 * 用户角色
	 */
	public final static String HOUSEHOLDMEMBER_ROLE_ME = "me";
//	public final static String HOUSEHOLDMEMBER_ROLE_FATHER = "father";
//	public final static String HOUSEHOLDMEMBER_ROLE_MOTHER = "mother";
//	public final static String HOUSEHOLDMEMBER_ROLE_SPOUSE = "spouse";
//	public final static String HOUSEHOLDMEMBER_ROLE_GRANDMOTHER = "grandmother";
//	public final static String HOUSEHOLDMEMBER_ROLE_GRANDFATHER = "grandfather";
//	public final static String HOUSEHOLDMEMBER_ROLE_SON = "son";
//	public final static String HOUSEHOLDMEMBER_ROLE_DAUGHTER = "daughter";
}
