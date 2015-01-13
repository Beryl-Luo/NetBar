package cn.liuning.UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import cn.liuning.javabean.CurrentRecord;
import cn.liuning.utils.ScreenLocation;

public class ShowLogoutInfo extends JFrame{

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
	
	/**
	 * �������
	 */
	private JTextField userCard = null;
	private JTextField userName = null;
	private JTextField consume = null;
	private JTextField banlance = null;
	private JTextField duratime = null;
	
	private JButton cancel=null;
	private ImageIcon icon = null;
	static JFrame frame;
	static String card;
	static CurrentRecord record = null;
	
	
	/**
	 * ���캯����ʼ��
	 */
	public ShowLogoutInfo(){
		super();
		initialize();
	}
	
	/**
	 * ��ʼ��������ʼ��
	 */
	private void initialize() {
		this.setSize(373, 380);
		this.setContentPane(getJContentPanel());
		ImageIcon icon = new ImageIcon("image/user.png");
		this.setIconImage(icon.getImage());
	}
	
	/**
	 * �в�����ʼ��
	 */
	private JPanel getJContentPanel() {
		
		if(jContentPane == null){
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(52, 27, 79, 22));
			jLabel1.setText("��Ա���ţ�");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(62, 65, 79, 24));
			jLabel2.setText("������");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(62, 115, 79, 21));
			jLabel3.setText("���ѣ�");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(62, 165, 79, 20));
			jLabel4.setText("��");
			jLabel5 = new JLabel();
			jLabel5.setText("�ۼ�ʱ�䣺");
			jLabel5.setBounds(new Rectangle(52, 215, 79, 20));
			icon  = new  ImageIcon("image/back.jpg");
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

			jContentPane.add(getUserCard(),null);
			jContentPane.add(getUserName(),null);
			jContentPane.add(getConsume(),null);
			jContentPane.add(getBanlance(),null);
			jContentPane.add(getDuratime(),null);
			jContentPane.add(getButton(),null);
		}
		return 	jContentPane;
	}
	
	/**
	 * �õ��û�����
	 * @return
	 */
	private JTextField getUserCard() {
		if (userCard == null) {
			userCard = new JTextField();
			userCard.setHorizontalAlignment(JTextField.CENTER);
			userCard.setBounds(new Rectangle(150, 27, 79, 22));
			userCard.setEditable(false);
			userCard.setText(record.getUsercard());
		}
		return userCard;
	}
	
	/**
	 * �õ��û�����
	 * @return
	 */
	private JTextField getUserName() {
		
		if (userName == null) {
			userName = new JTextField();
			userName.setHorizontalAlignment(JTextField.CENTER);
			userName.setBounds(new Rectangle(150, 71, 79, 23));
			userName.setEditable(false);
			userName.setText(record.getNickname());
		}
		return userName;
	
	}
	
	/**
	 * �õ����ѽ��
	 * @return
	 */
	private JTextField getConsume() {
		if (consume == null) {
			consume = new JTextField();
			consume.setHorizontalAlignment(JTextField.CENTER);
			consume.setBounds(new Rectangle(150, 115, 79, 23));
			consume.setEditable(false);
			consume.setText(record.getCurrentCost().toString());
		}
		return consume;
	}
	
	/**
	 * �õ����
	 * @return
	 */
	private JTextField getBanlance() {
		if (banlance == null) {
			banlance = new JTextField();
			banlance.setHorizontalAlignment(JTextField.CENTER);
			banlance.setBounds(new Rectangle(150, 166, 79, 23));
			banlance.setEditable(false);
			banlance.setText(record.getExpectBanlance().toString());
		}
		return banlance;
	}
	
	/**
	 * �õ�����ʱ��
	 * @return
	 */
	private JTextField getDuratime() {
		if (duratime == null) {
			duratime = new JTextField();
			banlance.setHorizontalAlignment(JTextField.CENTER);
			consume.setHorizontalAlignment(JTextField.CENTER);
			duratime.setBounds(new Rectangle(150, 212, 79, 23));
			duratime.setEditable(false);
			duratime.setText(record.getDuratime());
		}
		return duratime;
	}
	
	/**
	 * ��ť ȷ���¼�
	 * @return
	 */
	private JButton getButton() {
		if (cancel == null) {
			cancel = new JButton("ȷ��");
			cancel.setBounds(new Rectangle(68, 305, 60, 29));
			cancel.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					ShowLogoutInfo.this.dispose();
					frame.dispose();
					UserFrame aaa = new UserFrame();
					ScreenLocation.setLocationMid(aaa, "�û���¼");
				}
			});
		}
		return cancel;
	}
}











