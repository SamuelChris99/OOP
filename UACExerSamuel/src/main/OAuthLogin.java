package main;

public class OAuthLogin implements ILogin {
	private String token;

	public OAuthLogin(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public boolean authenticate(String username, String token) {
		return this.token.equals(token);
	}
	
}
