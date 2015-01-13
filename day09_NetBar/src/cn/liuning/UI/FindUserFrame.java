package cn.liuning.UI;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.liuning.dao.UserDao;
import cn.liuning.dao.impl.UserDaoImpl;
import cn.liuning.javabean.User;
import cn.liuning.utils.ScreenLocation;

public class FindUserFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel jContentPanel = null;
	private JLabel	jLabel	= null;
	private JButton	commit= null;
	private JButton	reset= null;
	private JTextField	userCard= null;
	static JFrame frame;
	
	/**
	 * ���캯����ʼ��
	 */
	public FindUserFrame(){
		super();
		initialize();
	}

	/**
	 * ��ʼ��������ʼ��
	 */
	private void initialize() {
		this.setSize(350, 150);
		this.setContentPane(getJContentPane());
		ImageIcon icon = new ImageIcon("image/finduser.png");
		this.setIconImage(icon.getImage());
	}

	/**
	 * �õ��������
	 * @return
	 */
	private JPanel getJContentPane() {
		if(jContentPanel == null){
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(44, 29, 79, 22));
			jLabel.setText("��Ա���ţ�");
			jContentPanel = new JPanel();
			jContentPanel.setLayout(null);
			jContentPanel.add(jLabel, null);
			jContentPanel.add(getCommit(), null);
			jContentPanel.add(getReset(), null);
			jContentPanel.add(getUserCard(), null);
		}
		return jContentPanel;
	}

	/**
	 * ��ȡ�û���
	 */
	private JTextField getUserCard() {
		if (userCard == null){
		
			userCard = new JTextField();
			userCard.setBounds(new Rectangle(147, 29, 98, 23));
		}
		return userCard;
	}

	/**
	 * getReset
	 * @return
	 */
	private JButton getReset() {
		if (reset == null){
			reset = new JButton("ȡ��");
			reset.setBounds(new Rectangle(154, 77, 62, 22));
			reset.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					FindUserFrame.this.dispose();
					frame.setEnabled(true);
					AdminToolsBar.enableButton(null);
				}
			});
		}
		return reset;
	}

	/**
	 * getCommit
	 * @return
	 */
	@SuppressWarnings("static-access")
	private JButton getCommit() {
		if (commit == null){
			commit = new JButton("ȷ��");
			commit.setBounds(new Rectangle(72, 76, 62, 22));
			commit.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e)	{
			
					String str = getUserCard().getText();
					JOptionPane jp = new JOptionPane();
					if (str.equals("") || str == null){
						jp.showMessageDialog(jp, "����д�û�����!");
					}else{
						UserDao userDao = new UserDaoImpl();
						User user = userDao.findUserOfUserCard(str);
						if(user == null){
							jp.showMessageDialog(jp, "�û�������!");
						}else{
							FindUserFrame.this.dispose();
							ShowUserInfoFrame.frame=frame;
							ShowUserInfoFrame.card=getUserCard().getText();
							ShowUserInfoFrame show = new ShowUserInfoFrame();
							show.addWindowListener(new WindowAdapter() {
								public void windowClosing(WindowEvent e){
									
									frame.setEnabled(true);
									AdminToolsBar.enableButton(null);
								}
							});
							ScreenLocation.setLocationMid(show, "�û���Ϣ");
						}
					}
				}
			});
		}
		return commit;
	}
}










