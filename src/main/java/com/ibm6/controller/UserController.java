package com.ibm6.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.bean.User;
import com.ibm6.model.UserAndAccount;
import com.ibm6.service.UserService;



@RestController
@RequestMapping()
public class UserController {
	
//	@Autowired
//	private UserMapper userMapper;
	
	@Autowired
	private UserService userService;

	//功能: 根据Id查询用户信息
	//输入参数: userId
	//输出参数: 用户信息 User
	/*
	int userId;
	String name;
	String gender;
	String age; 
	String email;
	Date birthday;
	String phone;
	String address;
	String description ;
	 */
	@RequestMapping("/showUser")
	public User showUser(@RequestBody User user) {
		user=userService.showUser(user.getUserId());
		return user;
	}
	
	//功能：更新用户信息
	//输入参数: User的那些信息（下面供参考）
	/*
	int userId;
	String name;
	String gender;
	String age; 
	String email;
	Date birthday;
	String phone;
	String address;
	String description ;
	 */
	//输出参数: 我不知道
	@RequestMapping("/updateMyInfo")
	public User updateMyInfo(@RequestBody User user) {
		if(userService.updateById(user)==1) {
			return userService.showUser(user.getUserId());
		}else {
			return user;
		}
	}
	
	@RequestMapping("/testUserUpdate")
	public User testUserUpdate(@RequestBody User user) {
		return userService.showUser(user.getUserId());
	}
	
	//功能：管理员获取 所有用户数（用于分页）
	//输入参数: 无
	//输出参数： int  总用户数
	//请求类型: Post
	@PostMapping("/UserListCount")
	public int getUserListCount()
	{
		int re = userService.totalUserCount();
		return re;
	}
	
	//功能：分页显示所有用户
	//输入参数：index  页号
	//输出参数  List<User>
	/*
	int userId;
	String name;
	String gender;
	String age; 
	String email;
	Date birthday;
	String phone;
	String address;
	String description ;
	 */
//	@RequestMapping("/showUserList/{index}")
//	public List<User> showUserList(@PathVariable("index") Integer index){
//		return userService.findUserByPage(index * 5);
//	}
	
	//功能：分页显示所有用户
		//输入参数：index  页号
		//输出参数  List<User>
		/*
		int userId;
		String account
		String name;
		String gender;
		String age; 
		String email;
		Date birthday;
		String phone;
		String address;
		String description ;
		 */
	@RequestMapping("/showUserList/{index}")
	public List<User> showUserList(@PathVariable("index") Integer index){
		return userService.findUserByPage(index * 5);
	}
	
	//功能： 返回模糊查询用户结果的总数
	//输入参数: name 用户名
	//输出参数：List<User>
	@PostMapping("/findUserByExampleCount")
	public int findUserByExample(@RequestBody User user){
		return userService.userByExampleCount(user);
	}
	
	//功能：分页显示 模糊查询用户结果
	//输入参数: index 页号  
	//输出参数：List<User>
	@RequestMapping("/findUserByExample/{index}")
	public List<UserAndAccount> findUserByExample(@RequestBody User user,@PathVariable("index") Integer index){
		return userService.findUserByExample(user,index*5);
	}
}
