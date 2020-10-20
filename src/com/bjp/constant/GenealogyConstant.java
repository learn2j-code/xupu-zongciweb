package com.bjp.constant;

public class GenealogyConstant {
	
	/**
	 * 世系关系标志： 初始状态为0，说明未添加关系；1代表关系添加完成
	 */
	public final static int GENEALOGYMEMBER_UNRELATED = 0;
	public final static int GENEALOGYMEMBER_RELATED = 1;
	
	/**
	 * 世系排序标志： 初始状态为0，说明未进行排序；1代表排序完成
	 */
	public final static int GENEALOGYMEMBER_UNORDER = 0;
	public final static int GENEALOGYMEMBER_INORDER = 1;
	
	/**
	 * 多版本标识  
	 * 0：代表只有一个版本(一个族谱或一个家庭) 大于0都表示多版本；
	 * 1：代表有多个家庭版本，无族谱版本；
	 * 2：代表有多个族谱版本，无家庭版本；
	 * 3：代表只有一个族谱版本，有家庭版本；
	 * 4：代表有多个族谱版本，有家庭版本；
	 */
	public final static int GENEALOGYMEMBER_VERSION_SINGLE = 0;
	public final static int GENEALOGYMEMBER_VERSION_MULTI_HOUSEHOLD_NON_CLAN = 1;
	public final static int GENEALOGYMEMBER_VERSION_MULTI_CLAN_NON_HOUSEHOLD = 2;
	public final static int GENEALOGYMEMBER_VERSION_SINGLE_CLAN_HAVE_HOUSEHOLD = 3;
	public final static int GENEALOGYMEMBER_VERSION_MULTI_CLAN_HAVE_HOUSEHOLD = 4;
	
	
	/**
	 * 世系成员的初始来源：为0，说明初始来源于族谱或世系；1代表初始来源于家庭
	 */
	public final static int GENEALOGYMEMBER_SOURCE_CLAN = 0;
	public final static int GENEALOGYMEMBER_SOURCE_HOUSEHOLD = 1;
	
	/**
	 * 关系标识：1：子女与父；2：配与主；
	 */
	public final static int GENEALOGYMEMBER_RELATIONSHIP_CHILDFATHER = 1;
	public final static int GENEALOGYMEMBER_RELATIONSHIP_SPOUSESUB = 2;
	
	/**
	 * 始迁祖代数
	 */
	public final static int GENEALOGYMEMBER_GENERATION_NUM_FIRST = 1;
	
	
	/**
	 * 逻辑删除标志：初始状态为0，说明未删除；1代表已删除
	 */
	public final static int GENEALOGYMEMBER_NOT_DELETE = 0;
	public final static int GENEALOGYMEMBER_DELETED = 1;
	
}
