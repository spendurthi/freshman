package com.sone.freshman.utils;

import java.util.ArrayList;
import java.util.List;

import com.sone.freshman.dto.AddressDTO;
import com.sone.freshman.dto.UserDTO;

public class Database {
	private static List<AddressDTO> address=new ArrayList<AddressDTO>();
	private static List<UserDTO> users=new ArrayList<UserDTO>();
	static{
		UserDTO user1 = new UserDTO("admin","admin");
		UserDTO user2 = new UserDTO("super","super");
		users.add(user1);users.add(user2);		
	}
	public static void save(AddressDTO dto){
		address.add(dto);
	}
	public static void update(AddressDTO dto){
		AddressDTO finder = new AddressDTO(dto.getId());
		int idx = address.indexOf(finder);
		finder = null;
		if (idx>=0){
			AddressDTO toUpdate=address.get(idx);
			toUpdate.setStreet(dto.getStreet());
		}
	}
	public static AddressDTO getAddress(int id){
		AddressDTO finder = new AddressDTO(id);
		int idx = address.indexOf(finder);
		finder = null;
		if (idx>=0){
			finder = address.get(idx);
		}
		return finder;
	}
	public static List<AddressDTO> getAddressList(){
		return address;
	}
	
	public static void save(UserDTO dto){
		users.add(dto);
	}
	public static void update(UserDTO dto){
		UserDTO finder = new UserDTO(dto.getUserName());
		int idx = users.indexOf(finder);
		finder = null;
		if (idx>=0){
			users.add(dto);
		}
	}
	public static UserDTO getUser(String userName){
		UserDTO finder = new UserDTO(userName);
		int idx = users.indexOf(finder);
		finder = null;
		if (idx>=0){
			finder = users.get(idx);
		}
		return finder;
	}
	public static List<UserDTO> getUsersList(){
		return users;
	}
}
