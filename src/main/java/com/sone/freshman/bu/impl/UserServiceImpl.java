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
	@Override
	public List<UserVO> search(String srch) {
		List<UserVO> srchUsers =  new ArrayList<UserVO>();
		for (Iterator<UserVO> iterator = users.iterator(); iterator.hasNext(); ) {
			UserVO user = iterator.next();			
		    if (user.getUserName().toLowerCase().indexOf(srch.toLowerCase())>=0) {
		    	srchUsers.add(user);
		    }
		}
		return srchUsers;
	}
	private static List<UserVO> populateDummyUsers(){
		List<UserVO> users = new ArrayList<UserVO>();
		users.add(new UserVO(counter.incrementAndGet(),"Surya", "NY", "surya@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Prabakar", "MD", "Prabakar@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Aneesha", "VA", "Aneesha@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Rajeev", "MD", "Rajeev@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Scott", "AZ", "Scott@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Anderson", "AK", "Anderson@abc.com"));
		
		users.add(new UserVO(counter.incrementAndGet(),"Beckett", "CA", "Beckett@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Campbell", "DC", "Campbell@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Dawson", "FL", "Dawson@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Grady", "GA", "Grady@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Harrison", "IL", "Harrison@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Jackson", "AK", "Jackson@abc.com"));
		
		users.add(new UserVO(counter.incrementAndGet(),"Jefferson", "NY", "Jefferson@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Jones", "MD", "Jones@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Kennedy", "VA", "Kennedy@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Kramer", "MD", "Kramer@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"McKenzie", "AZ", "McKenzie@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Miller", "AK", "Miller@abc.com"));
		
		users.add(new UserVO(counter.incrementAndGet(),"Parker", "CA", "Parker@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Presley", "DC", "Presley@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Sawyer", "FL", "Sawyer@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Smith", "GA", "Smith@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Taylor", "IL", "Taylor@abc.com"));
		users.add(new UserVO(counter.incrementAndGet(),"Tucker", "AK", "Tucker@abc.com"));
		return users;
	}

}
