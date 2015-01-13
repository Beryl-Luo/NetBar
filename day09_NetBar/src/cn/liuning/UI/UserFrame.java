package cn.liuning.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.Timer;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import cn.liuning.dao.BackupRecordDao;
import cn.liuning.dao.ComputerDao;
import cn.liuning.dao.CurrentRecordDao;
import cn.liuning.dao.UserDao;
import cn.liuning.dao.impl.BackupRecordDaoImpl;
import cn.liuning.dao.impl.ComputerDaoImpl;
import cn.liuning.dao.impl.CurrentRecordDaoImpl;
import cn.liuning.dao.impl.UserDaoImpl;
import cn.liuning.javabean.BackupRecord;
import cn.liuning.javabean.CurrentRecord;
import cn.liuning.javabean.User;
import cn.liuning.utils.ScreenLocation;

public class UserFrame extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * �˵���
	 */
	JMenuBar menuBar = null;
	JMenu menuMenu=null;
	JMenuItem logInItem=null;
	JMenuItem logOutItem=null;
	JMenuItem exitSysItem=null;
	JMenu findMenu=null;
	JMenu helpMenu=null;
	JMenuItem contactUsMenu=null;
	
	/**
	 * ������
	 */
	JToolBar toolBar=null;
	JButton loginButton = null;
	JButton logoutButton = null;

	/**
	 * left��ʾ��
	 */
	JPanel leftPanel = null;
	JLabel sysLabel = null;
	JLabel sysLabel1 = null;
	JLabel timeLabel = null;
	JLabel dateLabel  = null;
	
	/**
	 * center ��ʾ��
	 */
	JPanel centerPanel =new JPanel();
	
	/**
	 * �ϻ�����
	 */
	JLabel pcNumberLabel = null;
	JComboBox pcNumber = null;
	JLabel userCardLabel = null;
	JTextField userCard = null;
	JLabel passLabel = null;
	JPasswordField password = null;
	JButton confirm =null;
	JButton cancel = null;
	
	/**
	 * �»�����
	 */
	JLabel userCardLabel_o = null;
	JTextField userCard_o = null;
	JLabel passLabel_o = null;
	JPasswordField password_o = null;
	JButton confirm_o = null;
	JButton cancel_o = null;
	
	/**
	 * �����ֶ�
	 */
	static int x=0;
	static int y=0;
	static int z=0;
	boolean logout = false;
	boolean leag = false;
	boolean loginTemp = false;
	Timer timer = null;
	String flageTime="";
	List<JButton> list = new ArrayList<JButton>();
	List<String> hostList = new ArrayList<String>();
	String host_Nu="";
	
	/**
	 * ������
	 */
	public static void main(String[] args) {
		UserFrame userFrame = new UserFrame();
		ScreenLocation.setLocationMid(userFrame,"�û�����");
	}
	
	/**
	 * ���캯����ʼ��
	 */
	public UserFrame(){
		initial();
		ImageIcon icon = new ImageIcon("image/user.png");
		this.setIconImage(icon.getImage());
		this.setLayout(new BorderLayout(3, 3));
		this.setJMenuBar(menuBar);
		this.add(toolBar,BorderLayout.NORTH);
		this.add(getLeftPanel(),BorderLayout.WEST);
		this.add(centerPanel,BorderLayout.CENTER);
		this.setTitle("�û��˵�");
        this.setSize(600,450);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
	}
	
	/**
	 * ��ʼ��������ʼ��
	 */
	private void initial(){
		initialMenu();
		loginInitial();
	}
	
	/**
	 * �õ�����ʾ���
	 * @return
	 */
	private JPanel getLeftPanel(){
		//ϵͳʱ���ǩ
		sysLabel = new JLabel("��������ʱ��:",JLabel.CENTER);
		sysLabel.setBounds(new Rectangle(8, 53, 100, 36));
		sysLabel.setFont(new Font("����", Font.BOLD, 14));
		sysLabel1 = new JLabel("",JLabel.CENTER);
		sysLabel1.setBounds(new Rectangle(8, 93, 100, 36));
		sysLabel1.setFont(new Font("����", Font.BOLD, 14));
		//���ڱ�ǩ
		dateLabel = new JLabel("",JLabel.CENTER);
		dateLabel.setFont(new Font("����", Font.BOLD, 14));
		dateLabel.setBounds(new Rectangle(8, 265, 90, 33));
		//ʱ���ǩ
		timeLabel = new JLabel("",JLabel.CENTER);
		timeLabel.setFont(new Font("����", Font.BOLD, 14));
		timeLabel.setBounds(new Rectangle(8, 295, 90, 33));
		Thread t = new Thread(this);
		t.start();
		//���������
		leftPanel = new JPanel();
		leftPanel.setLayout(null);
		leftPanel.add(sysLabel);
		leftPanel.add(sysLabel1);
		leftPanel.add(dateLabel);
		leftPanel.add(timeLabel);
		leftPanel.setBorder(new CompoundBorder(new EtchedBorder(),
				new LineBorder(null)));
		leftPanel.setPreferredSize(new Dimension(120,330));
		
		return leftPanel;
	}
	
	/**
	 * �˵�����������ʼ��
	 */
	private void initialMenu(){
		/*
		 * �˵�
		 */
		menuBar = new JMenuBar();
		//�˵�(M)
		menuMenu = new JMenu("�˵�(M)");
		menuMenu.setMnemonic('M');
		logInItem = new JMenuItem("�ϻ�");
		logInItem.addActionListener(listener);
		logOutItem = new JMenuItem("�»�");
		logOutItem.addActionListener(listener2);
		exitSysItem = new JMenuItem("�˳�ϵͳ");
		exitSysItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				UserFrame.this.dispose();
			}
		});
		menuMenu.add(logInItem);
		menuMenu.add(logOutItem);
		menuMenu.add(exitSysItem);
		
		//�鿴(F)
		findMenu = new JMenu("�鿴(F)");
		findMenu.setMnemonic('F');
		//����(H)
		helpMenu = new JMenu("����(H)");
		helpMenu.setMnemonic('H');
		contactUsMenu = new JMenuItem("��ϵ����(O)");
		contactUsMenu.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane jp = new JOptionPane();
				String str = "���ɹ���ϵͳ\n"+
							"Version: 1.0\n"+
							"Author: LiuNing/YanXiuhao";
				jp.showMessageDialog(jp, str);
			}
		});
		helpMenu.add(contactUsMenu);
		//���������˵��� ����
		menuBar.add(menuMenu);
		menuBar.add(findMenu);
		menuBar.add(helpMenu);
		
		/*
		 * ������
		 */
		toolBar = new JToolBar();
		loginButton = new JButton(new ImageIcon("image/login.jpg"));
		logoutButton = new JButton(new ImageIcon("image/logoff.jpg"));
		if(!loginTemp){
			logoutButton.setEnabled(false);
		}
		logoutButton.addActionListener(listener2);
		//���빤����
		toolBar.add(new JLabel("|   "));
		toolBar.add(loginButton);
		toolBar.add(new JLabel("   |   "));
		toolBar.add(logoutButton);
		toolBar.add(new JLabel("   |   "));
	}
	
	/**
	 * �м䴰���ʼ��
	 */
	private void loginInitial(){
		//����
		pcNumberLabel = new JLabel("���ţ�");
		pcNumberLabel.setFont(new Font("����", Font.BOLD, 14));
		pcNumberLabel.setBounds(89, 43, 45, 26);
		pcNumber = new JComboBox();
		ComputerDao conputerDao = new ComputerDaoImpl();
		List<String> list = conputerDao.findFreeHost("offline");
		for(int j=0;j<list.size();j++){
			pcNumber.addItem(list.get(j));
		}
		pcNumber.setBounds(141, 43, 124, 26);
		
		//����
		userCardLabel = new JLabel("����:");
		userCardLabel.setFont(new Font("����", Font.BOLD, 14));
		userCardLabel.setBounds(89, 103, 45, 26);
		userCard = new JTextField();
		userCard.setBounds(141, 103, 124, 26);
		userCard.setColumns(10);
		
		//����
		passLabel = new JLabel("����:");
		passLabel.setFont(new Font("����", Font.BOLD, 14));
		passLabel.setBounds(89, 164, 45, 26);
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(141, 165, 124, 26);
		
		//�ϻ���ť
		confirm = new JButton("�ϻ�");
		confirm.setBounds(83, 233, 82, 33);
		confirm.addActionListener(listener);
		//���ð�ť
		cancel = new JButton("����");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userCard.setText("");
				password.setText("");
			}
		});
		cancel.setBounds(200, 233, 88, 33);
		
		centerPanel.setLayout(null);
		centerPanel.add(pcNumberLabel);
		centerPanel.add(pcNumber);
		centerPanel.add(userCardLabel);
		centerPanel.add(userCard);
		centerPanel.add(passLabel);
		centerPanel.add(password);
		centerPanel.add(confirm);
		centerPanel.add(cancel);
		centerPanel.setPreferredSize(new Dimension(600,350));
	}
	
	/**
	 * �»�����
	 */
	ActionListener listener2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int i = JOptionPane.showConfirmDialog(null, "ȷ���»���","",JOptionPane.YES_NO_OPTION);
			
			UserDao userDao = new UserDaoImpl();
			ComputerDao computerDao = new ComputerDaoImpl();
			CurrentRecordDao currentDao = new CurrentRecordDaoImpl();
			BackupRecordDao backupDao = new BackupRecordDaoImpl();
			
			if(i == 0){
				//�����û���״̬
				userDao.updateState_Offline(userCard.getText());
				
				CurrentRecord record = currentDao.findRecordOfUserCard(userCard.getText());
				User user = userDao.findUserOfUserCard(userCard.getText());
				user.setBanlace(record.getExpectBanlance());
				System.out.println(user.getBanlace());
				//�����û����
				userDao.updateUser(user, userCard.getText());
				//����������״̬
				computerDao.deleteHostState(record.getHostnumber(), "offline");
				@SuppressWarnings("deprecation")
				String str = record.getStarttime().toLocaleString();
				String year = str.split(" ")[0].split("-")[0];
				String month = str.split(" ")[0].split("-")[1];
				String day = str.split(" ")[0].split("-")[2];
				
				//���뱸�ݱ�
				BackupRecord backup = new BackupRecord();
				backup.setConsume(record.getCurrentCost());
				backup.setDay(day);
				backup.setDuraTime(sysLabel1.getText());
				backup.setHostnumber(host_Nu);
				backup.setId(0);
				backup.setMonth(month);
				backup.setNickname(record.getNickname());
				backup.setOverTime(new Date());
				backup.setStartTime(record.getStarttime());
				backup.setUsercard(record.getUsercard());
				backup.setYear(year);
				backupDao.insertIntoBaRecord(backup);
				
				//ɾ��ʵʱ��¼��״̬
				currentDao.deleteRecord(record.getUsercard());
				
				logout = true;
				
				//�л� �»�������ʾ����
				ShowLogoutInfo.frame=UserFrame.this;
				ShowLogoutInfo.record = record;
				ShowLogoutInfo showLogout = new ShowLogoutInfo();
				ScreenLocation.setLocationMid(showLogout, "��Ϣ��ʾ");
				
			}else{
				
			}
		}
	};
	
	/**
	 * �ϻ�������
	 */
	ActionListener listener = new ActionListener() {
		
		@SuppressWarnings({ "static-access", "deprecation" })
		@Override
		public void actionPerformed(ActionEvent e) {
			UserDao userDao = new UserDaoImpl();
			ComputerDao computerDao = new ComputerDaoImpl();
			CurrentRecordDao currentDao = new CurrentRecordDaoImpl();

			JOptionPane jp = new JOptionPane();
			if(userCard.getText().equals("") 
					|| userCard.getText()==null
					 ||	password.getText().equals("") 
					  || password.getText()==null ){
				jp.showMessageDialog(UserFrame.this, "�û���������Ϊ��");
			}else {
				User user = userDao.findUserOfUserCard(userCard.getText());
				if(user == null){
					jp.showMessageDialog(UserFrame.this, "ϵͳ�����ڴ��û���");
				}
				else if(user.getUserState().equals("online")){
					jp.showMessageDialog(UserFrame.this, "�û������������»���");
				}
				else{
					//�����û�״̬
					userDao.updateState_Online(userCard.getText());
					//��������״̬
					host_Nu = pcNumber.getSelectedItem().toString();
					computerDao.updateHostState(userCard.getText(),
							user.getNickname(), host_Nu, "online");
					//����ʵʱ��¼��
					CurrentRecord record = new CurrentRecord();
					record.setCurrentCost(new BigDecimal(0));
					record.setDuratime("00:00:00");
					record.setExpectBanlance(user.getBanlace());
					record.setHostnumber(pcNumber.getSelectedItem().toString());
					record.setId(0);
					record.setNickname(user.getNickname());
					record.setStarttime(new Date());
					record.setUsercard(user.getUsercard());
					//����ʵʱ��¼��
					currentDao.addRecord(record);
					
					//���������
					timer = new Timer(6000,listener3);
				    timer.start();
				    
					jp.showMessageDialog(UserFrame.this, "�ϻ��ɹ���");
					sysLabel1.setText("00:00:00");
					confirm.setEnabled(false);
					cancel.setEnabled(false);
					logoutButton.setEnabled(true);
					
				}
			}
		}
	};

	
	/**
	 * �����Զ��»�
	 */
	ActionListener listener3 = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			CurrentRecordDao currentDao = new CurrentRecordDaoImpl();
			CurrentRecord record = currentDao.findRecordOfUserCard(userCard.getText());
			
			if(record!=null && record.getExpectBanlance().compareTo(new BigDecimal(1.0)) < 0){
				UserDao userDao = new UserDaoImpl();
				ComputerDao computerDao = new ComputerDaoImpl();
				BackupRecordDao backupDao = new BackupRecordDaoImpl();
				
				//�����û����
				User user =  userDao.findUserOfUserCard(userCard.getText());
				user.setBanlace(record.getExpectBanlance());
				userDao.updateUser(user, userCard.getText());
				//�����û���״̬
				userDao.updateState_Offline(userCard.getText());

				//����������״̬
				computerDao.deleteHostState(record.getHostnumber(), "offline");
				@SuppressWarnings("deprecation")
				String str = record.getStarttime().toLocaleString();
				String year = str.split(" ")[0].split("-")[0];
				String month = str.split(" ")[0].split("-")[1];
				String day = str.split(" ")[0].split("-")[2];
				
				//���뱸�ݱ�
				BackupRecord backup = new BackupRecord();
				backup.setConsume(record.getCurrentCost());
				backup.setDay(day);
				backup.setDuraTime(sysLabel1.getText());
				backup.setHostnumber(host_Nu);
				backup.setId(0);
				backup.setMonth(month);
				backup.setNickname(record.getNickname());
				backup.setOverTime(new Date());
				backup.setStartTime(record.getStarttime());
				backup.setUsercard(record.getUsercard());
				backup.setYear(year);
				backupDao.insertIntoBaRecord(backup);
				
				//ɾ��ʵʱ��¼��״̬
				currentDao.deleteRecord(record.getUsercard());
				
				logout = true;
				
				//�л� �»�������ʾ����
				ShowLogoutInfo.frame=UserFrame.this;
				ShowLogoutInfo.record = record;
				ShowLogoutInfo showLogout = new ShowLogoutInfo();
				ScreenLocation.setLocationMid(showLogout, "����");
			}else{
				System.out.println("������");
			}
			
		}
	
	};
	/**
	 * ϵͳʱ����ʾ
	 */
	@SuppressWarnings("deprecation")
	public void run() {
		 while(true){
		    Date date = new Date();
			String dateAndtime = date.toLocaleString();
			String day = dateAndtime.split(" ")[0];
			String time = dateAndtime.split(" ")[1];
			dateLabel.setText(day);
			timeLabel.setText(time);
			String time2 = sysLabel1.getText();
			if(!(time2.equals("") || time2==null)){
				z = Integer.parseInt(time2.split(":")[0]);
				y = Integer.parseInt(time2.split(":")[1]);
				x = Integer.parseInt(time2.split(":")[2]);
				if(logout){
					
				}else{
					x=x+1;
				}
				
				sysLabel1.setText(getContinueTime());
			}
		    try {
		    	Thread.sleep(1000);
		    	x++;
		    	String str = getContinueTime();
		    	if(leag){
		    		if(loginTemp){
		    			flageTime=str;
		    		}
		    		sysLabel1.setText(flageTime);
		    	}
		    } catch (InterruptedException e) {
		     e.printStackTrace();  
		    }
		 }
	}
	
	/**
	 * ��װ����ʱ��ķ���
	 */
	private String getContinueTime(){
		
		if(x>=60){
    		y=y+1;
    		x=x%60;
    	}
    	if(y>=60){
    		z=z+1;
    		y=y%60;
    	}
    	String str = "";
    	if(z<10){
    		str=str+"0"+String.valueOf(z);
    	}else{
    		str += String.valueOf(z);
    	}
    	str+=":";
    	if(y<10){
    		str=str+"0"+String.valueOf(y);
    	}else{
    		str += String.valueOf(y);
    	}
    	str+=":";
    	if(x<10){
    		str=str+"0"+String.valueOf(x);
    	}else{
    		str += String.valueOf(x);
    	}
    	return str;
	}

}











