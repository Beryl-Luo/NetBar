package cn.liuning.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.liuning.dao.ComputerDao;
import cn.liuning.dao.CurrentRecordDao;
import cn.liuning.dao.UserDao;
import cn.liuning.dao.impl.ComputerDaoImpl;
import cn.liuning.dao.impl.CurrentRecordDaoImpl;
import cn.liuning.dao.impl.UserDaoImpl;
import cn.liuning.javabean.CurrentRecord;
import cn.liuning.javabean.User;


public class LoginFrame_ extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel pcNumberLabel;
	private JComboBox pcNumber;
	private JLabel userCardLabel;
	private JTextField userCard;
	private JLabel passLabel;
	private JPasswordField password;
	private JButton confirm;
	private JButton cancel;
	private JPanel centerPanel;
	String host_Nu = "";
	

//	public static void main(String[] args) {
//		LoginFrame_ aaa = new LoginFrame_();
//		aaa.setVisible(true);
//	}
	LoginFrame_(){
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
		confirm.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				UserDao userDao = new UserDaoImpl();
				ComputerDao computerDao = new ComputerDaoImpl();
				CurrentRecordDao currentDao = new CurrentRecordDaoImpl();
				if(userCard.getText().equals("") 
						|| userCard.getText()==null
						 ||	password.getText().equals("") 
						  || password.getText()==null ){
					JOptionPane.showMessageDialog(LoginFrame_.this, "�û���������Ϊ��");
				}else {
					User user = userDao.findUserOfUserCard(userCard.getText());
					if(user == null){
						JOptionPane.showMessageDialog(LoginFrame_.this, "ϵͳ�����ڴ��û���");
					}else{
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
						JOptionPane.showMessageDialog(LoginFrame_.this, "�ϻ��ɹ���");
						LoginFrame_.this.dispose();
					}
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
				password.setText("");
			}
		});
		cancel.setBounds(200, 233, 88, 33);
		centerPanel = new JPanel();
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
}
