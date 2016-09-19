package com.barosanu;

public class Singleton {
	
	private Singleton(){}
	private static Singleton instance = new Singleton();	
	public static Singleton getIntance(){
		return instance;
	}	
	
	
	private EmailMessageBean message;
	public EmailMessageBean getMessage() {
		return message;
	}

	public void setMessage(EmailMessageBean message) {
		this.message = message;
	}


}
