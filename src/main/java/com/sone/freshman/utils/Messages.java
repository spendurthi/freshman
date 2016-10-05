package com.sone.freshman.utils;

import java.util.ArrayList;

public class Messages extends ArrayList<String> {
	private String messageType;
	public Messages(){
		
	}
	public Messages(String messageType){
		this.messageType = messageType;
	}
	public Messages(String messageType, String defaulMsg){
		this.messageType = messageType;
		add(defaulMsg);
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessageType() {
		return messageType;
	}
}
