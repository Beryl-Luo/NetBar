package cn.liuning.UI;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class DeleteUserFrame extends JFrame {

	
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
	public DeleteUserFrame(){
		super();
		initialize();
	}

	/**
	 * ��ʼ��������ʼ��
	 */
	private void initialize() {
		ImageIcon icon = new ImageIcon("image/deleteuser.png");
		this.setIconImage(icon.getImage());
		this.setSize(350, 150);
		this.setContentPane(getJContentPane());
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
	 * ��ȡ���ð�ť
	 * @return JButton
	 */
	private JButton getReset() {
		if (reset == null){
			reset = new JButton("ȡ��");
			reset.setBounds(new Rectangle(154, 77, 62, 22));
			reset.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					DeleteUserFrame.this.dispose();
					frame.setEnabled(true);
					AdminToolsBar.enableButton(null);
				}
			});
		}
		return reset;
	}

	/**
	 * ��ȡȷ����ť
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
							System.out.println("aaaaa");
							userDao.delete(str);
							jp.showMessageDialog(jp, "�û�ɾ���ɹ�!");
							DeleteUserFrame.this.dispose();
							frame.setEnabled(true);
							AdminToolsBar.enableButton(null);
						}
					}
				}
			});
		}
		return commit;
	}
	
}










