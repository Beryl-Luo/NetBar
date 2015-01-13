package cn.liuning.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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


public class LogoutFrame_ extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel pcNumberLabel;
	private JLabel userCardLabel;
	private JTextField userCard;
	private JButton confirm;
	private JButton cancel;
	private JPanel centerPanel;
	String host_Nu = "";
	
//
//	public static void main(String[] args) {
//		LogoutFrame_ aaa = new LogoutFrame_();
//		aaa.setVisible(true);
//	}
	LogoutFrame_(){
		loginInitial();
		ImageIcon icon = new ImageIcon("image/login.jpg");
		this.setIconImage(icon.getImage());
		this.add(centerPanel,BorderLayout.CENTER);
        this.setSize(363,314);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * �м䴰���ʼ��
	 */
	private void loginInitial(){
		
		pcNumberLabel = new JLabel("ǿ���»�");
		pcNumberLabel.setFont(new Font("����", Font.BOLD, 18));
		pcNumberLabel.setBounds(135, 35, 100, 50);
		
		//����
		userCardLabel = new JLabel("����:");
		userCardLabel.setFont(new Font("����", Font.BOLD, 14));
		userCardLabel.setBounds(89, 103, 45, 26);
		userCard = new JTextField();
		userCard.setBounds(141, 103, 124, 26);
		userCard.setColumns(10);
//		
//		//����
//		passLabel = new JLabel("����:");
//		passLabel.setFont(new Font("����", Font.BOLD, 14));
//		passLabel.setBounds(89, 164, 45, 26);
//		password = new JPasswordField();
//		password.setColumns(10);
//		password.setBounds(141, 165, 124, 26);
		
		//�»���ť
		confirm = new JButton("�»�");
		confirm.addActionListener(new ActionListener() {
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
					backup.setDuraTime(record.getDuratime());
					backup.setHostnumber(record.getHostnumber());
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
					
					JOptionPane.showMessageDialog(LogoutFrame_.this, "�»��ɹ�!");
					LogoutFrame_.this.dispose();
				
				}else{
					
				}
			}
		});
		confirm.setBounds(83, 233, 82, 33);
		
		//���ð�ť
		cancel = new JButton("����");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userCard.setText("");
			}
		});
		cancel.setBounds(200, 233, 88, 33);
		centerPanel = new JPanel();
		centerPanel.setLayout(null);
		centerPanel.add(userCardLabel);
		centerPanel.add(pcNumberLabel);
		centerPanel.add(userCard);
//		centerPanel.add(passLabel);
//		centerPanel.add(password);
		centerPanel.add(confirm);
		centerPanel.add(cancel);
		centerPanel.setPreferredSize(new Dimension(600,350));
	}
}
