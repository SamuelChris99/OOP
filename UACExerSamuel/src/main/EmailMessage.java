package main;

public class EmailMessage extends Message {

	public EmailMessage(ILogin iLogin, String sender, String recipient, String content) {
		super(iLogin, sender, recipient, content);
	}

	@Override
	protected void send(String username, String password) {
		if(iLogin.authenticate(username, password)) {
			System.out.println("Email sent from " + sender + " to " + recipient + ": " + content);
		}else {
			System.out.println("Email authentication failed for user: " + username);
		}
	}
	
}
