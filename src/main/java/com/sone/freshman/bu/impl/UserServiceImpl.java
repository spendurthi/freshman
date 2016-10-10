package com.sone.freshman.bu.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.sone.freshman.bu.UserService;
import com.sone.freshman.vo.UserVO;

public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<UserVO> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<UserVO> findAllUsers() {
		return users;
	}
	
	public UserVO findById(long id) {
		for(UserVO user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public UserVO findByName(String name) {
		for(UserVO user : users){
			if(user.getUserName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(UserVO user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(UserVO user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<UserVO> iterator = users.iterator(); iterator.hasNext(); ) {
			UserVO user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(UserVO user) {
		return findByName(user.getUserName())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private static List<UserVO> populateDummyUsers(){
		List<UserVO> users = new ArrayList<UserVO>();
		users.add(new UserVO(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com"));
		return users;
	}

}
