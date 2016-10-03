package com.barosanu.model;

import java.util.Date;

import javax.mail.Message;

import com.barosanu.model.table.AbstractTableItem;
import com.barosanu.model.table.FormatableInteger;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmailMessageBean extends AbstractTableItem{
	
	private SimpleStringProperty sender;
	private SimpleStringProperty subject;
	private SimpleStringProperty recipient;
	private SimpleObjectProperty<FormatableInteger> size;
	private SimpleObjectProperty<Date> date;
	private Message messageRefference;
	
	public EmailMessageBean(String Subject, String Sender, String Recipient, int size, boolean isRead, Date date, Message MessageRefference){
		super(isRead);
		this.subject = new SimpleStringProperty(Subject);
		this.sender = new SimpleStringProperty(Sender);
		this.recipient = new SimpleStringProperty(Recipient);
		this.size = new SimpleObjectProperty<FormatableInteger>(new FormatableInteger(size));
		this.date = new SimpleObjectProperty<Date>(date);
		this.messageRefference = MessageRefference;
	}
	
	public String getSender(){
		return sender.get();
	}
	public String getSubject(){
		return subject.get();
	}
	public String getRecipient(){
		return recipient.get();
	}
	public FormatableInteger getSize(){
		return size.get();
	}
	public Date getDate(){
		return date.get();
	}
	public Message getMessageRefference() {
		return messageRefference;
	}
	
}