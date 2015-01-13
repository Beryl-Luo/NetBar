package cn.liuning.javabean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ���ݱ�
 * 
 * @author liuning
 *
 */
public class BackupRecord {
	
	/**
	 * ���ݿ�Ψһ��ʾ
	 */
	private Integer id;
	/**
	 * �ϻ����
	 */
	private String year;
	/**
	 * �ϻ��·�
	 */
	private String month;
	/**
	 * ��
	 */
	private String day;
	/**
	 * �û�����
	 */
	private String usercard;
	/**
	 * ����
	 */
	private String nickname;
	/**
	 * ����
	 */
	private BigDecimal consume;
	/**
	 * ��ʼʱ��
	 */
	private Date startTime;
	/**
	 * ����ʱ��
	 */
	private String duraTime;
	/**
	 * ����ʱ��
	 */
	private Date overTime;
	/**
	 * ������
	 */
	private String hostnumber;
	
	
	public BackupRecord() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}

	public BackupRecord(Integer id, String year, String month, String day,
			String usercard, String nickname, BigDecimal consume,
			Date startTime, String duraTime, Date overTime, String hostnumber) {
		super();
		this.id = id;
		this.year = year;
		this.month = month;
		this.day = day;
		this.usercard = usercard;
		this.nickname = nickname;
		this.consume = consume;
		this.startTime = startTime;
		this.duraTime = duraTime;
		this.overTime = overTime;
		this.hostnumber = hostnumber;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getUsercard() {
		return usercard;
	}
	public void setUsercard(String usercard) {
		this.usercard = usercard;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public BigDecimal getConsume() {
		return consume;
	}
	public void setConsume(BigDecimal consume) {
		this.consume = consume;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getDuraTime() {
		return duraTime;
	}
	public void setDuraTime(String duraTime) {
		this.duraTime = duraTime;
	}
	public Date getOverTime() {
		return overTime;
	}
	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}
	public String getHostnumber() {
		return hostnumber;
	}
	public void setHostnumber(String hostnumber) {
		this.hostnumber = hostnumber;
	}
	@Override
	public String toString() {
		return "BackupRecord [id=" + id + ", year=" + year + ", month=" + month
				+ ", day=" + day + ", usercard=" + usercard + ", nickname="
				+ nickname + ", consume=" + consume + ", startTime="
				+ startTime + ", duraTime=" + duraTime + ", overTime="
				+ overTime + ", hostnumber=" + hostnumber + "]";
	}

	
}
