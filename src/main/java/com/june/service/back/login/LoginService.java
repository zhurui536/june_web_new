/*   
 * Copyright (c) 2010-2020 JUNE. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * JUNE. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with JUNE.   
 *   
 */
package com.june.service.back.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.june.common.BaseService;
import com.june.dao.back.login.LoginDao;
import com.june.dto.back.login.ButtonDto;
import com.june.dto.back.login.MenuDto;
import com.june.dto.back.system.base.UserInfoDto;

/**
 * 登录用service LoginService <br>
 * 
 * @author 王俊伟 wjw.happy.love@163.com
 * @blog https://www.github.com/junehappylove
 * @date 2016年12月20日 下午8:16:12
 * @version 1.0.0
 */
@Service
public class LoginService extends BaseService<LoginDao, UserInfoDto> {
	/**
	 * 登录用dao注入
	 */
	@Autowired
	protected LoginDao loginDao;

	/**
	 * 人员service
	 */
	// @Autowired
	// protected PersonInfoService personInfoService;

	/**
	 * 围栏service
	 */
	// @Autowired
	// protected FenceSetService fenceSetService;

	/**
	 * 登录用户check
	 * 
	 * @param userInfoDto
	 * @return
	 * @date 2016年12月20日 下午8:15:49
	 * @writer junehappylove
	 */
	public UserInfoDto loginCheck(UserInfoDto userInfoDto) {
		userInfoDto = loginDao.loginCheck(userInfoDto);
		return userInfoDto;
	}

	/**
	 * 获取一级菜单
	 * 
	 * @param userInfoDto
	 * @return
	 * @date 2016年12月20日 下午8:15:42
	 * @writer junehappylove
	 */
	public List<MenuDto> getFristMenu(UserInfoDto userInfoDto) {
		List<MenuDto> list = loginDao.getFristMenu(userInfoDto);
		return list;
	}

	/**
	 * 获取二级以及三级菜单
	 * 
	 * @param menuDto
	 * @return
	 * @date 2016年12月20日 下午8:15:35
	 * @writer junehappylove
	 */
	// @Cacheable(value = "CustomerCache")
	public List<MenuDto> GetSecondMenu(MenuDto menuDto) {
		return loginDao.getSecondMenu(menuDto);
	}

	/**
	 * 根据menuId获取菜单信息
	 * 
	 * @param menuDto
	 * @return
	 * @date 2016年12月20日 下午8:15:28
	 * @writer junehappylove
	 */
	public MenuDto getMenuById(MenuDto menuDto) {
		menuDto = loginDao.getMenuById(menuDto);
		return menuDto;
	}

	/**
	 * 根据userId获取用户信息
	 * 
	 * @param userId
	 * @return
	 * @date 2016年12月20日 下午8:14:39
	 * @writer junehappylove
	 */
	public UserInfoDto getUserInfoById(String userId) {
		return loginDao.getUserInfoById(userId);
	}

	/**
	 * 根据用户id到，用户对应的schema下获取对应的角色信息
	 * 
	 * @param userInfoDto
	 * @return
	 * @date 2016年12月20日 下午8:14:50
	 * @writer junehappylove
	 */
	public List<UserInfoDto> getRoleInfoByUserId(UserInfoDto userInfoDto) {
		return loginDao.getRoleInfoByUserId(userInfoDto);
	}

	/**
	 * 获取角色对应的有权限的按钮
	 * 
	 * @param userInfoDto
	 * @return
	 * @date 2016年12月20日 下午8:14:59
	 * @writer junehappylove
	 */
	public List<ButtonDto> getRoleButton(UserInfoDto userInfoDto) {
		return loginDao.getRoleButton(userInfoDto);
	}

	/**
	 * 登录失败时更新登录尝试次数
	 * 
	 * @param userInfoDto
	 * @date 2016年12月20日 下午8:15:07
	 * @writer junehappylove
	 */
	public void updateFailLoginAttempt(UserInfoDto userInfoDto) {
		loginDao.updateFailLoginAttempt(userInfoDto);
	}

	/**
	 * 登录成功时更新登录尝试次数
	 * 
	 * @param userInfoDto
	 * @date 2016年12月20日 下午8:15:16
	 * @writer junehappylove
	 */
	public void updateSuccessLoginAttempt(UserInfoDto userInfoDto) {
		loginDao.updateSuccessLoginAttempt(userInfoDto);
	}
}
