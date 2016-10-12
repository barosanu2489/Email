package com.barosanu.model;

import java.util.HashMap;
import java.util.Map;

import com.barosanu.model.table.AbstractTableItem;

import javafx.beans.property.SimpleStringProperty;

public class EmailMessageBean extends AbstractTableItem{
	
	public static Map<String, Integer> formattedValues = new HashMap<String, Integer>();
	
	private SimpleStringProperty sender;
	private SimpleStringProperty subject;
	private SimpleStringProperty size;
	private String content;
	
	public EmailMessageBean(String Subject, String Sender, int size, String Content, boolean isRead){
		super(isRead);
		this.subject = new SimpleStringProperty(Subject);
		this.sender = new SimpleStringProperty(Sender);
		this.size = new SimpleStringProperty(formatSize(size));
		this.content = Content;
	}
	
	@Override
	public String toString() {
		return "EmailMessageBean "
				+ "sender=" + sender.get() + 
				", subject=" + subject.get() +
				", size=" + size.get() + 
				", content=" + content;
	}

	public String getSender(){
		return sender.get();
	}
	public String getSubject(){
		return subject.get();
	}
	public String getSize(){
		return size.get();
	}
	public String getContent(){
		return content;
	}
	
	private String formatSize(int size){
		String returnValue;
		if(size<= 0){
			returnValue =  "0";}
		
		else if(size<1024){
			returnValue = size + " B";
		}
		else if(size < 1048576){
			returnValue = size/1024 + " kB";
		}else{
			returnValue = size/1048576 + " MB";
		}
		formattedValues.put(returnValue, size);
		return returnValue;
		
	}
	
}
