/*   
 * Copyright (c) 2010-2020 JUNE. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * JUNE. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with JUNE.   
 *   
 */

package com.june.dto.back.system.base;

import com.june.common.PageDTO;

/**
 * 权限设计分配菜单使用
 * MenuInfoDto <br>
 * 
 * @author 王俊伟 wjw.happy.love@163.com
 * @blog https://www.github.com/junehappylove
 * @date 2017年2月16日 下午7:40:20
 * @version 1.0.0
 */
public class MenuInfoDto extends PageDTO<MenuInfoDto> {

	private static final long serialVersionUID = 1000L;
	private String id;// 菜单id
	private String text;// 菜单名
	private String roleId;// 角色id
	private String authorityMenusId;// 页面上传过来的需要赋权限的id
	private String roleName;// 角色名
	private String buttonId;// 按钮id
	/** 一级菜单id. */
	private String firstMenuId;
	/** 二级菜单id. */
	private String secondMenuId;
	/** 三级菜单id. */
	private String thirdMenuId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getAuthorityMenusId() {
		return authorityMenusId;
	}

	public void setAuthorityMenusId(String authorityMenusId) {
		this.authorityMenusId = authorityMenusId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getButtonId() {
		return buttonId;
	}

	public void setButtonId(String buttonId) {
		this.buttonId = buttonId;
	}

	public String getFirstMenuId() {
		return firstMenuId;
	}
	public void setFirstMenuId(String firstMenuId) {
		this.firstMenuId = firstMenuId;
	}
	public String getSecondMenuId() {
		return secondMenuId;
	}
	public void setSecondMenuId(String secondMenuId) {
		this.secondMenuId = secondMenuId;
	}
	public String getThirdMenuId() {
		return thirdMenuId;
	}
	public void setThirdMenuId(String thirdMenuId) {
		this.thirdMenuId = thirdMenuId;
	}

	@Override
	protected String getDtoName() {
		return "菜单";
	}

}
