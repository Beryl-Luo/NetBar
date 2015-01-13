package cn.liuning.UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.liuning.dao.UserDao;
import cn.liuning.dao.impl.UserDaoImpl;
import cn.liuning.javabean.User;
import cn.liuning.utils.PublicUtils;

public class AddUserFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	/**
	 * label����
	 */
	private JPanel jContentPane = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	
	/**
	 * �������
	 */
	private JTextField userCard = null;
	private JTextField password = null;
	private JTextField addMoney = null;
	private JComboBox userLevel = null;
	private JTextField userName = null;
	private JTextField phoneNumber = null;
	private JTextField idCardNumber = null;
	private JComboBox sex = null;
	
	/**
	 * ��ť����
	 */
	private JButton cancel=null;
	private JButton confirm=null;
	private JButton morInfo=null;
	private int count=1;
	private JButton allocate = null;
	ImageIcon icon=null;
	static JFrame frame;
	
	/**
	 * ���캯����ʼ��
	 */
	public AddUserFrame(){
		super();
		initialize();
	}
	
	/**
	 * ��ʼ��������ʼ��
	 */
	private void initialize() {
		// TODO �Զ����ɵķ������
		ImageIcon icon = new ImageIcon("image/adduser.png");
		this.setIconImage(icon.getImage());
		this.setSize(373, 265);
		this.setContentPane(getJContentPanel());
	}
	
	/**
	 * �õ� �������
	 * @return JPanel
	 */
	private JPanel getJContentPanel() {
		// TODO �Զ����ɵķ������
		if(jContentPane == null){
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(52, 27, 79, 22));
			jLabel1.setText("��Ա���ţ�");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(52, 57, 68, 24));
			jLabel2.setText("��Ա���룺");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(52, 90, 68, 21));
			jLabel3.setText("��ֵ��");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(52, 124, 66, 20));
			jLabel4.setText("��Ա���ͣ�");
			jLabel7 = new JLabel();
			jLabel7.setText("�ֻ��ţ�");
			jLabel7.setBounds(new Rectangle(57, 158, 79, 21));
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(79, 228, 40, 23));
			jLabel5.setText("������");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(40, 264, 79, 21));
			jLabel6.setText("���֤���룺");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(70, 305, 40, 23));
			jLabel8.setText("�Ա�");
			
			
			//����ͼƬ��ʾ
			icon = new  ImageIcon("image/back.jpg");
			jContentPane = new JPanel(){
				private static final long serialVersionUID = 1L;
				protected void paintComponent(Graphics g) {
                    g.drawImage(icon.getImage(), 0, 0, null);
                    super.paintComponent(g);
				}

			};
			jContentPane.setOpaque(false);
			jContentPane.setLayout(null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(jLabel8, null);
			jContentPane.add(getCardAndPass(),null);
			jContentPane.add(getUserCard(),null);
			jContentPane.add(getPassword(),null);
			jContentPane.add(getAddMoney(),null);
			jContentPane.add(getUserType(),null);
			jContentPane.add(getUserName(),null);
			jContentPane.add(getIdCard(),null);
			jContentPane.add(getPhoneNubmer(),null);
			jContentPane.add(getSex(),null);
			jContentPane.add(getConfirmBtn(),null);
			jContentPane.add(getCancelBtn(),null);
			jContentPane.add(getMoreInfoBtn(),null);
		}
		return 	jContentPane;
	}
	
	/**
	 * �õ��Ա�ѡ��
	 * @return JComboBox
	 */
	private JComboBox getSex() {
		if (sex == null) {
			sex = new JComboBox();
			sex.addItem("��");
			sex.addItem("Ů");
			sex.setBounds(new Rectangle(143, 307, 94, 20));
		}
		return sex;
	}
	
	/**
	 * �绰���������
	 * @return
	 */
	private JTextField getPhoneNubmer() {
		
		if (phoneNumber == null) {
			phoneNumber = new JTextField();
			phoneNumber.setBounds(new Rectangle(143, 158, 98, 23));
		}
		return phoneNumber;
	
	}
	
	/**
	 * ���֤�������
	 * @return
	 */
	private JTextField getIdCard() {
		if (idCardNumber == null) {
			idCardNumber = new JTextField();
			idCardNumber.setBounds(new Rectangle(143, 263, 154, 23));
		}
		return idCardNumber;
	}
	
	/**
	 * �û��������
	 * @return
	 */
	private JTextField getUserName() {
		if (userName == null) {
			userName = new JTextField();
			userName.setBounds(new Rectangle(143, 227, 97, 23));
		}
		return userName;
	}
	
	/**
	 * �û����������
	 * @return
	 */
	private JComboBox getUserType() {
		if (userLevel == null) {
			userLevel = new JComboBox();
			userLevel.addItem("��Ա�û�");
			userLevel.setBounds(new Rectangle(143, 123, 98, 23));
		}
		return userLevel;
	}
	
	/**
	 * ��ֵ��������
	 * @return
	 */
	private JTextField getAddMoney() {
		if (addMoney == null) {
			addMoney = new JTextField();
			addMoney.setBounds(new Rectangle(143, 91, 98, 23));
		}
		return addMoney;
	}
	
	/**
	 * �����
	 * @return
	 */
	private JTextField getPassword() {
		if (password == null) {
			password = new JTextField();
			password.setBounds(new Rectangle(143, 58, 98, 23));
			password.setEditable(false);
		}
		return password;
	}
	
	/**
	 * �û����������
	 * @return
	 */
	private JTextField getUserCard() {

		if (userCard == null) {
			userCard = new JTextField();
			userCard.setBounds(new Rectangle(143, 29, 97, 23));
			userCard.setEditable(false);
		}
		return userCard;
	}
	
	/**
	 * �õ�������Ϣ��ť
	 */
	private JButton getMoreInfoBtn() {
		if (morInfo == null) {
			morInfo = new JButton("����");
			morInfo.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					if(count%2==1){
						AddUserFrame.this.setSize(373, 375);
					}else{
						AddUserFrame.this.setSize(373,265);
					}
					count++;
				}
			});
			morInfo.setBounds(new Rectangle(260, 191, 80, 22));
		}
		return morInfo;
	}

	/**
	 * ȡ����ť
	 */
	private JButton getCancelBtn() {
		if (cancel == null) {
			cancel = new JButton("ȡ��");
			cancel.setBounds(new Rectangle(160, 191, 66, 23));
			cancel.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					AddUserFrame.this.dispose();
					
					frame.setEnabled(true);
					AdminToolsBar.enableButton(null);
				}
			});
		}
		return cancel;
	}
	
	/**
	 * �������밴ť
	 */
	private JButton getCardAndPass() {
		if(allocate  == null){
			allocate = new JButton("����");
			allocate.setBounds(new Rectangle(265, 35, 60, 22));
			allocate.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					UserDao userDao = new UserDaoImpl();
					User user = userDao.findMaxidInfo();
					String card = user.getUsercard();
					Integer nextCard = Integer.parseInt(card);
					nextCard++;
					String resule="0";
					resule+=String.valueOf(nextCard);
					userCard.setText(resule);
					
					password.setText(PublicUtils.getSecret());
				}
			});
		}
		return allocate;
	}
	
	/**
	 * ȷ����ť
	 */
	private JButton getConfirmBtn() {
		if(confirm == null){
			confirm = new JButton("ȷ��");
			confirm.setBounds(new Rectangle(50, 191, 66, 23));
			confirm.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					User user = new User();
					user.setBanlace(new BigDecimal(addMoney.getText()));
					user.setId(0);
					user.setLicenceNumber(idCardNumber.getText());
					user.setNickname(userName.getText());
					user.setPassword(password.getText());
					user.setPhoneNumber(phoneNumber.getText());
					user.setRegisterTime(new Date());
					user.setSex(sex.getSelectedItem().toString());
					user.setUsercard(userCard.getText());
					user.setUserState("offline");
					
					UserDao userDao = new UserDaoImpl();
					userDao.addUser(user);
					JOptionPane.showMessageDialog(AddUserFrame.this, "�û����ӳɹ�");
					//AddUserFrame.this.dispose();
					addMoney.setText("");
					idCardNumber.setText("");
					userName.setText("");
					password.setText("");
					phoneNumber.setText("");
					userCard.setText("");
					AddUserFrame.this.setSize(373,265);
					
				}
			});
		}
		return confirm;
	}
	
}











