package cn.liuning.javabean;

/**
 * id�����ݿ��û�Ψһ��ʾ
 * hostNnumber�������ţ�100-150��
 * nickname���û��ǳƣ�����ʹ�õ��û���û���û�ʹ����Ϊno��
 * usercard���û����ţ�����ʹ�õ��û����ţ�û������Ϊno��
 * state��״̬��ʶλ
 * @author liuning
 *
 */
public class Computer {
	
	/**
	 * ���ݿ�Ψһ��ʾ
	 */
	private Integer id;
	/**
	 * hostNnumber�������ţ�100-150��
	 */
	private String hostnumber;
	/**
	 * �û�����
	 */
	private String nickname;
	/**
	 * �û�����
	 */
	private String usercard;
	/**
	 * �û�״̬
	 */
	private String state;
	
	
	public Computer() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}

	public Computer(Integer id, String hostnumber, String nickname,
			String usercard, String state) {
		super();
		this.id = id;
		this.hostnumber = hostnumber;
		this.nickname = nickname;
		this.usercard = usercard;
		this.state = state;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHostnumber() {
		return hostnumber;
	}
	public void setHostnumber(String hostnumber) {
		this.hostnumber = hostnumber;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUsercard() {
		return usercard;
	}
	public void setUsercard(String usercard) {
		this.usercard = usercard;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Computer [id=" + id + ", hostnumber=" + hostnumber
				+ ", nickname=" + nickname + ", usercard=" + usercard
				+ ", state=" + state + "]";
	}
	
	
}
