package com.bjp.constant;

public class ClanConstant {
	/**
	 * 族谱原文的解析标识： 初始状态为0，说明未进行解析；1代表解析完成
	 */
	public final static int CLANMEMBERCONTENT_UNPARSING = 0;
	public final static int CLANMEMBERCONTENT_PARSING = 1;
	
//	/**
//	 * 族谱或家庭成员标识：默认为0，代表该数据来源族谱成员信息表，1代表该数据来源家庭成员信息表
//	 */
//	public final static int CLANMEMBER_CLAN = 0;
//	public final static int CLANMEMBER_HOUSEHOLD = 1;
	
	/**
	 * 扩展用：初始状态为0，
	 */
	public final static int CLANMEMBERSTATUS_UNSET = 0;
	public final static int CLANMEMBERSTATUS_SET = 1;

	/**
	 * 进入世系的标志：初始状态为0，说明未进入世系；1代表已进入世系
	 */
	public final static int CLANMEMBER_OUT_GENEALOGY = 0;
	public final static int CLANMEMBER_IN_GENEALOGY = 1;
	/**
	 * 用于解析三段式谱文中的关系字段
	 */
	public final static String SPOUSEKEYWORD = "赘夫,继配,再配,配,副室,继室,再继,继,再娶,娶";//以后
	public final static String CHILDKEYWORD = "之子,长子,次子,一子,二子,三子,四子,五子,六子,七子,八子,九子,之女,长女,次女,一女,二女,三女,四女,五女,六女,七女,八女,九女";
	public final static String OTHERKEYWORD = "公";
	public final static String COMMA = ",";
	public final static String SONKEYWORD = "之子,长子,次子,一子,二子,三子,四子,五子,六子,七子,八子,九子";
	public final static String DAUGHTERWORD = "之女,长女,次女,一女,二女,三女,四女,五女,六女,七女,八女,九女";
	public final static String HUSBANDWORD = "赘夫";
	public final static String WIFEKEYWORD = "继配,再配,配,副室,继室,再继,继,再娶,娶";//以后
	
	/**
	 * 表示男女；1为男  2为女
	 */
	public final static int CLANMEMBERCONTENT_MALE = 1;
	public final static int CLANMEMBERCONTENT_FEMALE = 2;
	
	/**
	 * 逻辑删除标志：初始状态为0，说明未删除；1代表已删除
	 */
	public final static int CLANMEMBER_NOT_DELETE = 0;
	public final static int CLANMEMBER_DELETED = 1;
	
	
	/**
	 * 关系标识：1：子女与父；2：配与主；
	 */
	public final static int CLANMEMBER_RELATIONSHIP_CHILDFATHER = 1;
	public final static int CLANMEMBER_RELATIONSHIP_SPOUSESUB = 2;
//	public final static String INTELNET = "@";
//	public final static String COLON = ":";
//	public final static String ASTERISK = "*";
//	public final static String FOREKEYWORD = "派,名,又名,字,号,生于,时年,时寿,殁于,葬";
//	public final static String BACKKEYWORD= "子,女";
}
