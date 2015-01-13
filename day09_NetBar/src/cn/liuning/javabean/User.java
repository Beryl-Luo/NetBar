package cn.liuning.javabean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * �û�ʵ����
 * @author liuning
 *
 */
public class User {
	/**
	 * ���ݿ�Ψһ��ʶ
	 */
	private Integer id;
	/**
	 * �û�����
	 */
	private String usercard;
	/**
	 * �û�����
	 */
	private String password;
	/**
	 * �û����
	 */
	private BigDecimal banlace;
	/**
	 * ���֤��
	 */
	private String licenceNumber;
	/**
	 * �Ա�
	 */
	private String sex;
	/**
	 * ����
	 */
	private String nickname;
	/**
	 * �ֻ�����
	 */
	private String phoneNumber;
	/**
	 * �û�״̬
	 */
	private String userState;
	/**
	 * ע��ʱ��
	 */
	private Date registerTime;
	
	
	public User(Integer id, String usercard, String password,
			BigDecimal banlace, String licenceNumber, String sex,
			String nickname, String phoneNumber, String userState,
			Date registerTime) {
		super();
		this.id = id;
		this.usercard = usercard;
		this.password = password;
		this.banlace = banlace;
		this.licenceNumber = licenceNumber;
		this.sex = sex;
		this.nickname = nickname;
		this.phoneNumber = phoneNumber;
		this.userState = userState;
		this.registerTime = registerTime;
	}
	public User() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsercard() {
		return usercard;
	}
	public void setUsercard(String usercard) {
		this.usercard = usercard;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BigDecimal getBanlace() {
		return banlace;
	}
	public void setBanlace(BigDecimal banlace) {
		this.banlace = banlace;
	}
	public String getLicenceNumber() {
		return licenceNumber;
	}
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", usercard=" + usercard + ", password="
				+ password + ", banlace=" + banlace + ", licenceNumber="
				+ licenceNumber + ", sex=" + sex + ", nickname=" + nickname
				+ ", phoneNumber=" + phoneNumber + ", userState=" + userState
				+ ", registerTime=" + registerTime + "]";
	}
	
}
