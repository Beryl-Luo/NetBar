package cn.liuning.UI;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;

import cn.liuning.dao.AdminDao;
import cn.liuning.dao.UserDao;
import cn.liuning.dao.impl.AdminDaoImpl;
import cn.liuning.dao.impl.UserDaoImpl;
import cn.liuning.javabean.Admin;
import cn.liuning.javabean.User;

@SuppressWarnings("serial")
public class SetUpFrame extends JFrame {

	/**
	 * �������
	 */
	private JPanel jContentPane = null;
	private JTabbedPane tabbedPane = null;
	private JPanel panel1 = null;
	private JPanel panel2 = null;
	private JPanel panel3 = null;
	private JLabel admName = null;
	private JLabel admPassword = null;
	private JLabel admIslock = null;
	private JTextField adminName = null;
	private JPasswordField adminPassword = null;
	private JCheckBox isLock = null;
	private JButton reset = null;
	private JScrollPane adminJScrollPane = null;
	private JTable adminJTable = null;
	private JButton deladmin = null;
	private JButton add;
	private JButton cancel;
	private JLabel usercardLabel;
	private JLabel userNameLabel;
	private JLabel userPassLabel;
	private JLabel banlanceLabel;
	private JTextField userCard;
	private JTextField userName;
	private JTextField phoneNumber;
	private JTextField banlance;
	private JButton add2;
	private JButton cancel2;
	private JScrollPane adminJScrollPane2;
	private JTable adminJTable2;
	private JButton reset2;
	private JButton deladmin2;
	private JLabel leabl;
	private JComboBox rate;
	private JButton button;
	
	/**
	 * ��������
	 */
	String deleteAdmin=null;
	String selectUser=null;
	static JFrame frame;
	
	/**
	 * ���캯����ʼ��
	 */
	public SetUpFrame() {
		super();
		this.setSize(450, 350);
		this.setContentPane(getJContentPane());
		this.setTitle("ϵͳ����");
	}

	/**
	 * �������ʼ��
	 * @return JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
		
			jContentPane = new JPanel();
			jContentPane.add(getTabbedPane(), BorderLayout.CENTER);
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}

	/**
	 * �õ� JTabbedPane
	 * 
	 * @author liuning
	 * @return JTabbedPane
	 */
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane();
			tabbedPane = new JTabbedPane();
			tabbedPane.setTabPlacement(JTabbedPane.TOP);
			tabbedPane.addTab("����Ա����", getPanel1());
			tabbedPane.addTab("��Ա����", getPanel2());
			tabbedPane.addTab("�Ʒ�����", getPanel3());
			tabbedPane.setSize(450, 350);
		}
		return tabbedPane;
	}
	
	/**
	 * �õ� ����Ա�������
	 * 
	 * @author liuning
	 * @return JPanel
	 */
	private JPanel getPanel1() {
		if (panel1 == null) {
			admIslock = new JLabel();

			admIslock.setBounds(new Rectangle(13, 115, 73, 24));
			admIslock.setText("�Ƿ�������");

			admPassword = new JLabel();
			admPassword.setBounds(new Rectangle(7, 66, 78, 26));
			admPassword.setText("����Ա���룺");
			admName = new JLabel();
			admName.setBounds(new Rectangle(5, 20, 78, 26));
			admName.setText("����Ա���ƣ�");
			panel1 = new JPanel();
			panel1.setLayout(null);

			panel1.add(admName, null);
			panel1.add(admPassword, null);
			panel1.add(admIslock, null);
			
			panel1.add(getAdminName(), null);
			panel1.add(getAdminPassword(), null);
			panel1.add(getIsLock(), null);
			
			//���Ӱ�ť
			panel1.add(getAddButton(),null);
			//ȡ����ť
			panel1.add(getCancelButton(), null);
			//������ʾ��
			panel1.add(getAdminJScrollPane(), null);
			//���ð�ť
			panel1.add(getResetButton(),null);
			//ɾ��ѡ�а�ť
			panel1.add(getDeleteAdminButton(), null);
		}
		return panel1;
	}
	
	/**
	 * ����Ա���� - ɾ��ѡ�а�ť
	 * 
	 * @author liuning
	 * @return JButton
	 */
	private JButton getDeleteAdminButton() {
		if (deladmin == null) {
			deladmin = new JButton();
			deladmin.setText("ɾ��ѡ��");
			deladmin.setBounds(new Rectangle(325, 226, 90, 25));
			deladmin.addMouseListener(new MouseAdapter() {
				@SuppressWarnings("static-access")
				public void mouseClicked(MouseEvent e) {
					AdminDao adminDao = new AdminDaoImpl();
					adminDao.delete(deleteAdmin);
					JOptionPane jp = new JOptionPane();
					jp.showMessageDialog(jp, "ɾ���ɹ�!");
					adminJScrollPane.setViewportView(getAdminJTable());
					adminName.setText("");
					adminPassword.setText("");
				}
			});
		}
		return deladmin;
	}
	
	/**
	 * ����Ա���� - ���Ӱ�ť
	 * 
	 * @author liuning
	 * @return
	 */
	private JButton getAddButton() {
		if (add == null) {
			add = new JButton("����");
			add.setLocation(new Point(15, 198));
			add.setSize(60, 27);
			add.addMouseListener(new MouseAdapter() {
				@SuppressWarnings({ "deprecation", "static-access" })
				public void mouseClicked(MouseEvent e) {
					AdminDao adminDao = new AdminDaoImpl();
					Admin admin = new Admin();
					admin.setAdmincard(adminName.getText());
					admin.setAdminpass(adminPassword.getText());
					if(isLock.isSelected()){
						admin.setState("lock");
					}else{
						admin.setState("unlock");
					}
					
					JOptionPane jp = new JOptionPane();
					if(adminName.getText().equals("") ||
							adminPassword.equals("") ||
							adminName == null||
							adminPassword == null){
						jp.showMessageDialog(jp, "�˺Ż�����Ϊ��!");
					}
					if(deleteAdmin == null){
						adminDao.addAdmin(admin);
						jp.showMessageDialog(jp, "���ӳɹ�!");
						adminName.setText("");
						adminPassword.setText("");
						adminJScrollPane.setViewportView(getAdminJTable());
						
					}else{
						if(deleteAdmin.equals("admin")){
							jp.showMessageDialog(jp, "�벻Ҫ�޸�admin����Ա!");
						}else{
							
							adminDao.delete(deleteAdmin);
							adminDao.addAdmin(admin);
							jp.showMessageDialog(jp, "�޸ĳɹ�!");
							adminJScrollPane.setViewportView(getAdminJTable());
							add.setText("����");
							adminName.setText("");
							adminPassword.setText("");
						}
					}
				}
			});
		}
		return add;
	}
	
	/**
	 * ����Ա���� - ȡ����ť
	 * 
	 * @author liuning
	 * @return JButton
	 */
	private JButton getCancelButton() {
		if (cancel == null) {
			cancel = new JButton("ȡ��");
			cancel.setBounds(new Rectangle(107, 198, 60, 27));
			cancel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					frame=AdminToolsBar.frame;
					AdminToolsBar.enableButton(null);
					frame.setEnabled(true);
					SetUpFrame.this.dispose();
				}
			});
		}
		return cancel;
	}
	
	/**
	 * ����Ա���� - ���ð�ť
	 * @return JButton
	 */
	private JButton getResetButton() {
		if (reset == null) {
			reset = new JButton("����");
			reset.setBounds(new Rectangle(240, 226, 60, 25));
			reset.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					adminJScrollPane.setViewportView(getAdminJTable());
					deleteAdmin = null;
					adminName.setText("");
					adminPassword.setText("");
					isLock.setSelected(false);
					add.setText("����");
				}
			});
		}
		return reset;
	}

	/**
	 * ����Ա���� - JScrollPane
	 * 
	 * @author liuning
	 * @return JScrollPane
	 */
	private JScrollPane getAdminJScrollPane() {
		if (adminJScrollPane == null) {
			adminJScrollPane = new JScrollPane();
			adminJScrollPane.setBounds(new Rectangle(260, 20, 150, 180));
			adminJScrollPane.setViewportView(getAdminJTable());
		}
		return adminJScrollPane;
	}

	/**
	 * ����Ա���� - �õ�Table
	 * 
	 * @author liuning
	 * @return JTable
	 */
	private JTable getAdminJTable() {
		String[] colnames = { "�˺�", "�Ƿ�����" };
		AdminDao adminDao = new AdminDaoImpl();
		List<Admin> list = adminDao.findAllAdmin();
		Object[][] cells = new Object[list.size()][2];
		for(int j=0;j<list.size();j++){
			Admin admin = list.get(j);
			cells[j][0] = admin.getAdmincard();
			cells[j][1] = admin.getState();
		}
		adminJTable = new JTable(cells, colnames);
		
		adminJTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				add.setText("�޸�");
				
				AdminDao adminDao = new AdminDaoImpl();
				int index = adminJTable.getSelectedRow();
				String adminCard = (String) adminJTable.getValueAt(index, 0);
				Admin admin2 = adminDao.findAdmin(adminCard);
				adminName.setText(admin2.getAdmincard());
				adminPassword.setText(admin2.getAdminpass());
				if(admin2.getState().equals("lock")){
					isLock.setSelected(true);
				}else{
					isLock.setSelected(false);
				}
				deleteAdmin = admin2.getAdmincard();
			}
		});

		return adminJTable;
	}

	/**
	 * ����Ա���� - �õ�������ѡ��
	 * 
	 * @author liuning
	 * @return JCheckBox
	 */
	private JCheckBox getIsLock() {
		if (isLock == null) {
			isLock = new JCheckBox();
			isLock.setText("����");
			isLock.setBounds(new Rectangle(105, 115, 52, 21));
		}
		return isLock;
	}
	
	/**
	 * ����Ա���� - �õ�����Ա�˺�
	 * 
	 * @author liuning
	 * @return JTextField
	 */
	private JTextField getAdminName() {
		if (adminName == null) {
			adminName = new JTextField();
			adminName.setBounds(new Rectangle(102, 19, 112, 26));
		}
		return adminName;
	}
	
	/**
	 * ����Ա���� - �õ�����Ա����
	 * 
	 * @author liuning
	 * @return JPasswordField
	 */
	private JPasswordField getAdminPassword() {
		if (adminPassword == null) {
			adminPassword = new JPasswordField();
			adminPassword.setBounds(new Rectangle(102, 68, 111, 26));
		}
		return adminPassword;
	}	

	/**
	 * �õ���Ա���� ���
	 * 
	 * @author liuning
	 * @return JPanel
	 */
	private JPanel getPanel2() {
		if (panel2 == null) {
			
			//��ʼ����ǩ����
			usercardLabel = new JLabel();
			usercardLabel.setBounds(new Rectangle(7, 20, 78, 26));
			usercardLabel.setText("�˺�:");
			userNameLabel = new JLabel();
			userNameLabel.setBounds(new Rectangle(7, 66, 78, 26));
			userNameLabel.setText("������");
			userPassLabel = new JLabel();
			userPassLabel.setBounds(new Rectangle(4, 120, 78, 26));
			userPassLabel.setText("�ֻ��ţ�");
			banlanceLabel =  new JLabel();
			banlanceLabel.setBounds(new Rectangle(7, 169, 78, 26));
			banlanceLabel.setText("��");
			
			//��������������
			panel2 = new JPanel();
			panel2.setLayout(null);
			panel2.add(usercardLabel, null);
			panel2.add(userNameLabel, null);
			panel2.add(userPassLabel, null);
			panel2.add(banlanceLabel, null);
			
			panel2.add(getUserCard(), null);
			panel2.add(getUserName(), null);
			panel2.add(getPhoneNumber(), null);
			panel2.add(getUserBanlance(), null);
			
			//���Ӱ�ť
			panel2.add(getAddButton2(),null);
			//ȡ����ť
			panel2.add(getCancelButton2(), null);
			//��ʾ��
			panel2.add(getUserJScrollPane2(), null);
			//���ð�ť
			panel2.add(getResetButton2(),null);
			//ɾ��ѡ�а�ť
			panel2.add(getDeleteAdminButton2(), null);
		}
		return panel2;
	}
	
	/**
	 * ��Ա����-ɾ��ѡ�а�ť
	 * @return JButton
	 * @author liuning
	 */
	private JButton getDeleteAdminButton2() {
		if (deladmin2 == null) {
			deladmin2 = new JButton();
			deladmin2.setText("ɾ��ѡ��");
			deladmin2.setBounds(new Rectangle(325, 226, 90, 25));
			deladmin2.addMouseListener(new MouseAdapter() {
				@SuppressWarnings("static-access")
				public void mouseClicked(MouseEvent e) {
					UserDao userDao = new UserDaoImpl();
					User user = userDao.findUserOfUserCard(selectUser);
					JOptionPane jp = new JOptionPane();
					if(user.getUserState().equals("online")){
						jp.showMessageDialog(jp, "�û������ϻ�����ɾ��!");
					}else{
						userDao.delete(selectUser);
						jp.showMessageDialog(jp, "ɾ���ɹ�!");
						adminJScrollPane2.setViewportView(getUserJTable2());
						userCard.setText("");
						userName.setText("");
						phoneNumber.setText("");
						banlance.setText("");
					}
				}
			});
		}
		return deladmin2;
	}
	
	/**
	 * ��Ա����-���ð�ť
	 * @return JButton
	 */
	private JButton getResetButton2() {
		if (reset2 == null) {
			reset2 = new JButton("����");
			reset2.setBounds(new Rectangle(240, 226, 60, 25));
			reset2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					userCard.setText("");
					userName.setText("");
					phoneNumber.setText("");
					banlance.setText("");
					add2.setText("��ѡ��");
				}
			});
		}
		return reset2;
	}
	
	/**
	 * ��Ա����-JScrollPane
	 * @return JScrollPane
	 */
	private JScrollPane getUserJScrollPane2() {
		if (adminJScrollPane2 == null) {
			adminJScrollPane2 = new JScrollPane();
			adminJScrollPane2.setBounds(new Rectangle(170, 20, 255, 206));
			adminJScrollPane2.setViewportView(getUserJTable2());
		}
		return adminJScrollPane2;
	}
	
	/**
	 * ��Ա����-�õ����
	 * @return
	 */
	private JTable getUserJTable2() {
		String[] colnames = { "�˺�", "����" ,"���","�ֻ���"};
		UserDao userDao = new UserDaoImpl();
		List<User> list = userDao.findAllUser();
		Object[][] cells = new Object[list.size()][4];
		for(int j=0;j<list.size();j++){
			User user = list.get(j);
			cells[j][0] = user.getUsercard();
			cells[j][1] = user.getNickname();
			cells[j][2] = user.getBanlace();
			cells[j][3] = user.getPhoneNumber();
			
		}
		adminJTable2 = new JTable(cells, colnames);
		
		adminJTable2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				add2.setText("�޸�");
				
				UserDao userDao = new UserDaoImpl();
				int index = adminJTable2.getSelectedRow();
				selectUser = (String) adminJTable2.getValueAt(index, 0);
				User user2 = userDao.findUserOfUserCard(selectUser);
				userCard.setText(user2.getUsercard());
				userName.setText(user2.getNickname());
				phoneNumber.setText(user2.getPhoneNumber());
				banlance.setText(user2.getBanlace().toString());
			
			}
		});
		return adminJTable2;
	}
	
	/**
	 * ��Ա����-ȡ����ť
	 * @return
	 */
	private JButton getCancelButton2(){
		if (cancel2 == null) {
			cancel2 = new JButton("ȡ��");
			cancel2.setBounds(new Rectangle(107, 220, 60, 27));
			cancel2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					frame=AdminToolsBar.frame;
					AdminToolsBar.enableButton(null);
					frame.setEnabled(true);
					SetUpFrame.this.dispose();
				}
			});
		}
		return cancel2;
	}
	
	/**
	 * ��Ա���� - �õ����Ӱ�ť
	 * @return JButton
	 */
	private JButton getAddButton2(){
		if (add2 == null) {
			add2 = new JButton("��ѡ��");
			add2.setBounds(15, 220, 75, 27);
			add2.addMouseListener(new MouseAdapter() {
				@SuppressWarnings("static-access")
				public void mouseClicked(MouseEvent e) {
					UserDao userDao = new UserDaoImpl();
					User user = userDao.findUserOfUserCard(selectUser);
					user.setUsercard(userCard.getText());
					user.setNickname(userName.getText());
					user.setPhoneNumber(phoneNumber.getText());
					user.setBanlace(new BigDecimal(banlance.getText()));
					JOptionPane jp = new JOptionPane();
					if(userCard.getText().equals("") ||
							userName.equals("") ||
							phoneNumber.equals("")||
									banlance.equals("")){
						jp.showMessageDialog(jp, "�˺Ż�����Ϊ��!");
					}
					else if(selectUser == null){
						
						
					}else{
						userDao.updateUser(user, user.getUsercard());
						jp.showMessageDialog(jp, "�޸ĳɹ�!");
						adminJScrollPane2.setViewportView(getUserJTable2());
						add2.setText("��ѡ��");
						userCard.setText("");
						userName.setText("");
						phoneNumber.setText("");
						banlance.setText("");
					}
				}
			});
		}
		return add2;
	}
	
	/**
	 * ��Ա���� - �õ��û�����
	 * @return JTextField
	 */
	private JTextField getUserCard(){
		if (userCard == null) {
			userCard = new JTextField();
			userCard.setEditable(false);
			userCard.setBounds(new Rectangle(55, 19, 112, 26));
		}
		return userCard;
	}
	
	/**
	 * ��Ա���� - �õ��û�����
	 * @return JTextField
	 */
	private JTextField getUserName(){
		if (userName == null) {
			userName = new JTextField();
			userName.setBounds(new Rectangle(55, 69, 112, 26));
		}
		return userName;
	}
	
	/**
	 * ��Ա���� - �õ��û��ֻ���
	 * @return JTextField
	 */
	private JTextField getPhoneNumber(){
		if (phoneNumber == null) {
			phoneNumber = new JTextField();
			phoneNumber.setBounds(new Rectangle(55, 119, 112, 26));
		}
		return phoneNumber;
	}
	
	/**
	 * ��Ա���� - �õ��û�
	 * @return JTextField
	 */
	private JTextField getUserBanlance(){
		if (banlance == null) {
			banlance = new JTextField();
			banlance.setBounds(new Rectangle(55, 169, 112, 26));
		}
		return banlance;
	}
	
	/**
	 * �õ��Ʒ��������
	 * @return JPanel
	 */
	private JPanel getPanel3() {
		if (panel3 == null) {
			
			leabl = new JLabel();
			leabl.setBounds(new Rectangle(190, 50, 100, 30));
			leabl.setText("��ǰ���ۣ�");

			AdminDao  adminDao =new AdminDaoImpl();
			Admin admin = adminDao.findRate();

			rate = new JComboBox();
			rate.addItem("1.2/h");
			rate.addItem("1.8/h");
			rate.addItem("2.4/h");
			rate.addItem("3.0/h");
			rate.addItem("3.6/h");
			rate.setSelectedItem(admin.getRate()+"/h");
			rate.setBounds(new Rectangle(180, 85, 80, 26));
			panel3 = new JPanel();
			panel3.setLayout(null);
			panel3.add(leabl, null);
			panel3.add(rate, null);
			panel3.add(getButton(), null);
			
		}
		return panel3;
	}
	
	/**
	 * �Ʒ�����  - ȷ����ť
	 * @return JButton
	 */
	private JButton getButton(){
		if(button == null){
			button = new JButton("ȷ��");
			button.setBounds(new Rectangle(185, 150, 73, 26));
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					AdminDao  adminDao =new AdminDaoImpl();
					adminDao.updateRate(rate.getSelectedItem().toString().split("/")[0]);
					JOptionPane.showMessageDialog(SetUpFrame.this, "���³ɹ�");
				}
			});
		}
		return button;
	}

}

