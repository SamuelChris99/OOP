package main;

public class BasicLogin implements ILogin {
	private String name, password;
	
	public BasicLogin(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean authenticate(String username, String password) {
		return this.name.equals(username) && this.password.equals(password);
	}
	
}
