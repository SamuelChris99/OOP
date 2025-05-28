package main;

public abstract class Message {
	protected ILogin iLogin;
	protected String sender;
	protected String recipient;
	protected String content;
	
	public Message(ILogin iLogin, String sender, String recipient, String content) {
		this.iLogin = iLogin;
		this.sender = sender;
		this.recipient = recipient;
		this.content = content;
	}

	public ILogin getiLogin() {
		return iLogin;
	}

	public void setiLogin(ILogin iLogin) {
		this.iLogin = iLogin;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	protected abstract void send(String username, String password);
}
