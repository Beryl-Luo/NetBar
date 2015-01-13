package cn.liuning.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.Timer;

import cn.liuning.dao.AdminDao;
import cn.liuning.dao.UserDao;
import cn.liuning.dao.impl.AdminDaoImpl;
import cn.liuning.dao.impl.UserDaoImpl;
import cn.liuning.javabean.Admin;
import cn.liuning.javabean.User;
import cn.liuning.utils.ScreenLocation;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame implements Runnable{
	
	/**
	 * The North JComponent
	 */
	JPanel n_Panel = null;
	JLabel n_Label1=null;
	JLabel n_Label2=null;
	JLabel scroll = null;
	
	/**
	 * The Center JComponent
	 */
	JTabbedPane tab =null;
	JLabel sysTimeLabel = null;
	JLabel sysTime1 = null;
	JLabel sysTime2 = null;
	
	/**
	 * User JComponent
	 */
	JPanel c_Panel_1 =null;
	JLabel c_Label1_1=null;
	JLabel c_Label2_1=null;
	JTextField userName=null;
	JPasswordField password=null;
	JButton loginButton = null;
	JButton resetButton = null;
	
	/**
	 * Admin JComponent
	 */
	JPanel c_Panel_2 =null;
	JLabel c_Label1_2=null;
	JLabel c_Label2_2=null;
	JTextField adminName=null;
	JPasswordField adminPass=null;
	JButton adminLoginBtn= null;
	JButton adminResetBtn = null;
	
	
	
	/**
	 * The Main Program
	 */
	public static void main(String[] args) {
		LoginFrame login = new LoginFrame();
		ScreenLocation.setLocationMid(login,"��¼����");
		
	}
	
	/**
	 * The Constructor Function
	 */
	public LoginFrame(){
		initial();
		this.setTitle("�û���¼");
	    this.setSize(521,476);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * This method initialize the frame
	 * @author liuning
	 */
	private void initial(){
		/**
		 * North Initialize
		 */
		this.add(getNorthPanel(),BorderLayout.NORTH);
		/**
		 * Center Initialize
		 */
	    this.add(getCenterTab(),BorderLayout.CENTER);
	}
	
	/**
	 * Center Component
	 * @author Liuning
	 * @return JTabbedPane
	 */
	private JTabbedPane getCenterTab(){
	
		sysTime1 = new JLabel();
		sysTime1.setBounds(170, 200, 180, 25);
		sysTime1.setFont(new Font("����", Font.BOLD, 15));
		sysTime2 = new JLabel();
		sysTime2.setBounds(170, 200, 180, 25);
		sysTime2.setFont(new Font("����", Font.BOLD, 15));
		
		/**
		 * ������ʱ����ʾʱ��
		 */
		Thread t = new Thread(this);
		t.start();
		
		/**
		 * User Component
		 */
		c_Label1_1=new JLabel("�˺�:");
		c_Label1_1.setBounds(140, 40, 50, 25);
		c_Label1_1.setFont(new Font("����", Font.BOLD, 15));
		c_Label2_1=new JLabel("����:");
		c_Label2_1.setBounds(140, 86, 50, 25);
		c_Label2_1.setFont(new Font("����", Font.BOLD, 15));
		userName = new JTextField();
		userName.setBounds(200, 40, 150, 25);
		password = new JPasswordField();
		password.setBounds(200, 86, 150, 25);
		loginButton = new JButton("��¼");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/**
				 * �õ�������˺ź�����
				 */
				String usename = userName.getText();
				@SuppressWarnings("deprecation")
				String userpass = password.getText();
				/**
				 * �½��û�������
				 */
				UserDao userDao = new UserDaoImpl();
				User user = userDao.findUserOfUserCard(usename);
				/**
				 * ��֤����������Ƿ������ݿⱣ���һ��
				 */
				if(user != null && user.getPassword().equals(userpass)){
					UserFrame userFrame = new UserFrame();
					ScreenLocation.setLocationMid(userFrame, "�û�����");
					LoginFrame.this.dispose();
				}
				else{
					JOptionPane.showMessageDialog(LoginFrame.this,
							"��Ա���Ż��������\n����������", "����",
							JOptionPane.ERROR_MESSAGE);
					password.setText("");
				}
				
				
			}
		});
		loginButton.setBounds(new Rectangle(165, 140, 70, 26));
		resetButton = new JButton("����");
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userName.setText("");
				password.setText("");
			}
		});
		resetButton.setBounds(new Rectangle(265, 140, 70, 26));
		c_Panel_1 = new JPanel();
		c_Panel_1.setLayout(null);
		c_Panel_1.add(c_Label1_1,null);
		c_Panel_1.add(c_Label2_1,null);
		c_Panel_1.add(userName,null);
		c_Panel_1.add(password,null);
		c_Panel_1.add(sysTime1,null);
		c_Panel_1.add(resetButton,null);
		c_Panel_1.add(loginButton,null);
		
		/**
		 * Admin Component
		 */
		c_Label1_2=new JLabel("�˺�:");
		c_Label1_2.setBounds(140, 40, 50, 25);
		c_Label1_2.setFont(new Font("����", Font.BOLD, 15));
		c_Label2_2=new JLabel("����:");
		c_Label2_2.setBounds(140, 86, 50, 25);
		c_Label2_2.setFont(new Font("����", Font.BOLD, 15));
		adminName = new JTextField();
		adminName.setBounds(200, 40, 150, 25);
		adminPass = new JPasswordField();
		adminPass.setBounds(200, 86, 150, 25);
		adminLoginBtn = new JButton("��¼");
		adminLoginBtn.addActionListener(new ActionListener() {
			
			@Override
			@SuppressWarnings( "deprecation")
			public void actionPerformed(ActionEvent e) {

				/**
				 * �õ�������˺ź�����
				 */
				String adminCard = adminName.getText();
				String password = adminPass.getText();
				/**
				 * �½�����Ա ���ݿ������
				 */
				AdminDao adminDao= new AdminDaoImpl();
				Admin admin = adminDao.findAdmin(adminCard);
				/**
				 * ��֤����������Ƿ������ݿⱣ���һ��
				 */
				if(admin != null && admin.getAdminpass().equals(password)){
					
					if(admin.getState().equals("lock")){
						JOptionPane.showMessageDialog(LoginFrame.this,
								"����Ա�˻�����ס!", "����",
								JOptionPane.ERROR_MESSAGE);
						adminPass.setText("");
					}else{
						AdminFrame admin1 = new AdminFrame();
						ScreenLocation.setLocationMid(admin1, "����Ա����");
						LoginFrame.this.dispose();
					}
				}
				else{
					JOptionPane.showMessageDialog(LoginFrame.this,
							"����Ա�˺Ż��������\n����������", "����",
							JOptionPane.ERROR_MESSAGE);
					adminPass.setText("");
				}
				
			}
		});
		adminLoginBtn.setBounds(new Rectangle(165, 140, 70, 26));
		adminResetBtn = new JButton("����");
		adminResetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminName.setText("");
				adminPass.setText("");
				
			}
		});
		adminResetBtn.setBounds(new Rectangle(265, 140, 70, 26));
		c_Panel_2 = new JPanel();
		c_Panel_2.setLayout(null);
		c_Panel_2.add(c_Label1_2,null);
		c_Panel_2.add(c_Label2_2,null);
		c_Panel_2.add(adminName,null);
		c_Panel_2.add(adminPass,null);
		c_Panel_2.add(sysTime2,null);
		c_Panel_2.add(adminLoginBtn,null);
		c_Panel_2.add(adminResetBtn,null);
		
		tab = new JTabbedPane();
		tab.add("��ͨ�û�",c_Panel_1);
		tab.add("����Ա",c_Panel_2);
		
		return tab;
	}
	
	/**
	 * North Component
	 * @author Liuning
	 * @return JPanel(��������� Panel)
	 */
	private JPanel getNorthPanel(){
		n_Label1 = new JLabel();
		n_Label1.setBounds(new Rectangle(180, 100, 200, 30));
		n_Label1.setText("���ɹ���ϵͳ");
		n_Label1.setFont(new Font("����", Font.BOLD, 23));
		n_Label2 = new JLabel(new ImageIcon("image/ddd.png"));
		n_Label2.setBounds(new Rectangle(200, 1, 100, 100));
		scroll = new JLabel("��ӭʹ��XXX���ɹ���ϵͳ");
		scroll.setBounds(new Rectangle(125, 130, 200, 30));
		
		/**
		 * ������ʱ��,ʵ�ֹ���
		 */
		Timer timer = new Timer(50,listener);
        timer.start();
        
        //�������
        n_Panel = new JPanel();
		n_Panel.setLayout(null);
		n_Panel.setPreferredSize(new Dimension(500, 160));
		n_Panel.add(n_Label2,null);
		n_Panel.add(n_Label1,null);
		n_Panel.add(scroll,null);
		return n_Panel;
	}

	/**
	 * ϵͳʱ����ʾ
	 * @author liuning
	 */
	@SuppressWarnings("deprecation")
	public void run() {
		 while(true){
		    Date d = new Date();
			String s = d.toLocaleString();
		    sysTime1.setText(s);
		    sysTime2.setText(s);
		    try {
		    	Thread.sleep(1000);
		    } catch (InterruptedException e) {
		     e.printStackTrace();  
		    }
		 }
	}
	
	/**
	 * ʵ�ֹ���
	 * @author liuning
	 */
	ActionListener listener = new ActionListener() {
	  int pos = 180;
        public void actionPerformed(ActionEvent e) {
            pos--;
            scroll.setBounds(pos, 130, 200, 30);
            scroll.setText("��ӭʹ��XXX���ɹ���ϵͳ");
            n_Panel.add(scroll);
            if(pos == -180) {
                pos = 585;
            }
        }
    };
	
}
