package com.june.dto.back.login;

import java.io.Serializable;
import java.util.List;

import com.june.common.AbstractDTO;

public class MenuDto extends AbstractDTO implements Serializable{

	/**
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = 1797576506000676225L;
	// 用户id
	private String userId;
	// 菜单id
	private String menuId;
	// 菜单的图标地址
	private String icon;
	// 父菜单id
	private String pid;
	// 菜单url
	private String url;
	// 菜单名称
	private String menuName;
	// 菜单顺序
	private Integer orderNum;// 排序数
	// 角色id
	private String roleId;
	// 角色名
	private String roleName;
	
	private Integer infoNum;// 信息数目
	
	private List<MenuDto> menus;
	
	private String clazz;// 设置tab属性是否是选中状态

	private String state;// treegrid展开状态

	public Integer getInfoNum() {
		return infoNum;
	}

	public void setInfoNum(Integer infoNum) {
		this.infoNum = infoNum;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the menuId
	 */
	public String getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId
	 *            the menuId to set
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * @param pid
	 *            the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName
	 *            the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * @return the ord
	 */
	public Integer getOrderNum() {
		return orderNum;
	}

	/**
	 * @param ord
	 *            the ord to set
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return the menus
	 */
	public List<MenuDto> getMenus() {
		return menus;
	}

	/**
	 * @param menus
	 *            the menus to set
	 */
	public void setMenus(List<MenuDto> menus) {
		this.menus = menus;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	@Override
	protected String getDtoName() {
		return "菜单";
	}

}
