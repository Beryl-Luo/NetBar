package cn.liuning.javabean;

/**
 * 
 * ����Աʵ�壺
 * @author liuning
 *
 */
public class Admin {
	/**
	 * ���ݿ�Ψһ��ʾ
	 */
	private Integer id;
	
	/**
	 * ����Ա����
	 */
	private String admincard;
	/**
	 * ����Ա����
	 */
	private String adminpass;
	
	/**
	 * ����Ա״̬ lock����  unlockδ��ס
	 */
	private String state;
	
	/**
	 * ����
	 */
	private String rate;
	
	public Admin() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	public Admin(Integer id, String admincard, String adminpass, String state,
			String rate) {
		super();
		this.id = id;
		this.admincard = admincard;
		this.adminpass = adminpass;
		this.state = state;
		this.rate = rate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdmincard() {
		return admincard;
	}
	public void setAdmincard(String admincard) {
		this.admincard = admincard;
	}
	public String getAdminpass() {
		return adminpass;
	}
	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", admincard=" + admincard + ", adminpass="
				+ adminpass + ", state=" + state + ", rate=" + rate + "]";
	}
	
	
	
	
}
