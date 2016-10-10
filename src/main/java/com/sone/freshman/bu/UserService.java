package com.sone.freshman.bu;

import java.util.List;

import com.sone.freshman.vo.UserVO;





public interface UserService {
	
	UserVO findById(long id);
	
	UserVO findByName(String name);
	
	void saveUser(UserVO user);
	
	void updateUser(UserVO user);
	
	void deleteUserById(long id);

	List<UserVO> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(UserVO user);
	
}
