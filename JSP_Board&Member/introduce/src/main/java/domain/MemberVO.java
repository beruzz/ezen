package domain;

public class MemberVO {
	private String id;
	private String password;
	private String email;
	private int age;
	
	//로그인
	public MemberVO(String id, String password) {
		this.id = id;
		this.password = password;
	}
	//회원가입
	public MemberVO(String id, String password, String email, int age) {
		this(id,password);
		this.email = email;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
