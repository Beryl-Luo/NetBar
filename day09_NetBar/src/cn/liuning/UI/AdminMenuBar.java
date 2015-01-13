package cn.liuning.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import cn.liuning.utils.ScreenLocation;


/**
 * ����Ա������    �˵���
 * menuMenu   ���˵�
 * helpMenu   ������
 * manageMenu ������
 * viewMenu   ����ͼ
 * statMenu   �� ͳ�Ʊ���
 */

public class AdminMenuBar {
	
	/**
	 * �˵�����JMenuBar
	 */
	private JMenuBar menuBar=null;
	private JMenu menuMenu=null;
	private JMenu helpMenu=null;
	private JMenu manageMenu=null;
	private JMenu viewMenu=null;
	private JMenu statMenu=null;
	private JMenuItem sysItem=null;
	private JMenuItem exitItem=null;
	private JMenuItem deleteItem=null;
	private JMenuItem addItem=null;
	private JMenuItem updateItem=null;
	private JMenuItem findItem=null;
	private JMenuItem homeItem=null;
	private JMenuItem onlineItem=null;
	private JMenuItem statItem=null;
	private JMenuItem personItem=null;
	private JMenuItem incomeItem=null;
	private JMenuItem contactUsItem=null;
	private JMenuItem aboutsysItem=null;
	private JMenuItem login = null;
	private JMenuItem logout = null;
	static JFrame frame;
	
	/**
	 * �õ� ����Ա����� MenuBar
	 * @return:JMenuBar
	 */
	public JMenuBar getAdminJMenuBar(){
		if(menuBar == null){
			menuBar = new JMenuBar();
			menuBar.add(getMenuMenu());
			menuBar.add(getManageMenu());
			menuBar.add(getViewMenu());
			menuBar.add(getStatMenu());
			menuBar.add(getHelpMenu());
		}
		return menuBar;
	}

	/**
	 * ����ѡ��
	 * @return
	 */
	private JMenu getHelpMenu() {
		helpMenu = new JMenu("����(H)");
		contactUsItem = new JMenuItem("��ϵ����");
		contactUsItem.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				JOptionPane jp = new JOptionPane();
				String str = "���ɹ���ϵͳ\n"+
							"Version: 1.0\n"+
							"Author: LiuNing/YanXiuhao\n"+
							"1127746065@qq.com";
				jp.showMessageDialog(jp, str);
			}
		});
		aboutsysItem = new JMenuItem("����ϵͳ");
		aboutsysItem.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				JOptionPane jp = new JOptionPane();
				String str = "����ϵ:liu8521@live.com";
				jp.showMessageDialog(jp, str);
			}
		});
		helpMenu.add(contactUsItem);
		helpMenu.add(aboutsysItem);
		return helpMenu;
	}

	/**
	 * ͳ��ѡ��
	 * @return
	 */
	private JMenu getStatMenu() {
		statMenu = new JMenu("ͳ�Ʊ���(T)");
		personItem = new JMenuItem("��������");
		personItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminToolsBar.temp=false;
				// TODO �Զ����ɵķ������
				AdminToolsBar.enableButton(AdminToolsBar.statButton);
				AdminFrame.leftPanel=LeftPanel.leftPanel;
				AdminFrame.leftPanel.removeAll();
				
				AdminFrame.leftPanel=LeftPanel.getLeftPanel2();
				AdminFrame.centerPanel.setViewportView(null);
				AdminFrame.leftPanel.updateUI();
				AdminFrame.centerPanel.updateUI();
			}
		});
		incomeItem = new JMenuItem("���뱨��");
		incomeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				AdminToolsBar.temp=false;
				AdminToolsBar.enableButton(AdminToolsBar.statButton);
				AdminFrame.leftPanel=LeftPanel.leftPanel;
				AdminFrame.leftPanel.removeAll();
				
				AdminFrame.leftPanel=LeftPanel.getLeftPanel2();
				AdminFrame.centerPanel.setViewportView(null);
				AdminFrame.leftPanel.updateUI();
				AdminFrame.centerPanel.updateUI();
			}
		});
		statMenu.add(personItem);
		statMenu.add(incomeItem);
		return statMenu;
	}

	/**
	 * ��ͼѡ��
	 * @return
	 */
	@SuppressWarnings("static-access")
	private JMenu getViewMenu() {
		viewMenu = new JMenu("��ͼ(V)");
		homeItem = new JMenuItem("��ҳ��ͼ");
		homeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				AdminToolsBar.temp=true;
				AdminFrame.centerPanel.setViewportView(new TableData().getJTable());
				
				AdminFrame.leftPanel=LeftPanel.getLeftPanel();
				AdminFrame.leftPanel.removeAll();
				AdminFrame.leftPanel=LeftPanel.getLeftPanel();
				AdminFrame.centerPanel.updateUI();
				
				AdminToolsBar.enableButton(AdminToolsBar.homeButton);
				AdminToolsBar.enableButton(AdminToolsBar.homeButton);
			}
		});
		onlineItem = new JMenuItem("�����û�");
		onlineItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminToolsBar.temp=true;
				if(AdminToolsBar.count%2 == 0){
					AdminFrame.centerPanel.setViewportView(TableData.getJTable2());
					AdminToolsBar.count++;
				}else{
					AdminFrame.centerPanel.setViewportView(TableData.getJTable());
					AdminToolsBar.count++;
				}
			}
		});
		statItem = new JMenuItem("ͳ����ͼ");
		statItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				AdminToolsBar.temp=false;
				AdminToolsBar.enableButton(AdminToolsBar.statButton);
				AdminFrame.leftPanel=LeftPanel.leftPanel;
				AdminFrame.leftPanel.removeAll();
				
				AdminFrame.leftPanel=LeftPanel.getLeftPanel2();
				AdminFrame.centerPanel.setViewportView(null);
				AdminFrame.leftPanel.updateUI();
				AdminFrame.centerPanel.updateUI();
			}
		});
		viewMenu.add(homeItem);
		viewMenu.add(onlineItem);
		viewMenu.add(statItem);
		return viewMenu;
	}

	/**
	 * ����ѡ��
	 * @return
	 */
	private JMenu getManageMenu() {
		manageMenu = new JMenu("����(A)");
		addItem = new JMenuItem("���ӻ�Ա");
		addItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				AddUserFrame.frame=frame;
				final AddUserFrame addFrame = new AddUserFrame();
				ScreenLocation.setLocationMid(addFrame, "�û�����");
				
				addFrame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						frame.setEnabled(true);
						AdminToolsBar.enableButton(null);
					}
				});
				frame.setEnabled(false);
				AdminToolsBar.enableButton(AdminToolsBar.addButton);
			}
		});
		deleteItem = new JMenuItem("ɾ����Ա");
		deleteItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				DeleteUserFrame.frame=frame;
				final DeleteUserFrame deleteFrame = new DeleteUserFrame();
				ScreenLocation.setLocationMid(deleteFrame, "ɾ���û�");
				
				deleteFrame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						AdminToolsBar.enableButton(null);
						frame.setEnabled(true);
					}
				});
				
				frame.setEnabled(false);
				AdminToolsBar.enableButton(AdminToolsBar.deleteButton);
			}
		});
		updateItem = new JMenuItem("��Ϣ�޸�");
		updateItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				UpdateUserFrame.frame = frame;
				UpdateUserFrame update = new UpdateUserFrame();
				update.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						AdminToolsBar.enableButton(null);
						frame.setEnabled(true);
					}
				});
				ScreenLocation.setLocationMid(update, "�޸���Ϣ");
				
				frame.setEnabled(false);
				AdminToolsBar.enableButton(AdminToolsBar.updateButton);
			}
		});
		findItem = new JMenuItem("��Ϣ��ѯ");
		findItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				FindUserFrame.frame = frame;
				FindUserFrame find = new FindUserFrame();
				find.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						AdminToolsBar.enableButton(null);
						frame.setEnabled(true);
					}
				});
				ScreenLocation.setLocationMid(find, "�޸���Ϣ");
				frame.setEnabled(false);
				AdminToolsBar.enableButton(AdminToolsBar.findButton);
			}
		});
		manageMenu.add(addItem);
		manageMenu.add(deleteItem);
		manageMenu.add(updateItem);
		manageMenu.add(findItem);
		return manageMenu;
	}

	/**
	 * �˵� ѡ��
	 * @return
	 */
	private JMenu getMenuMenu() {
		menuMenu = new JMenu("�˵�(M)");
		sysItem = new JMenuItem("ϵͳ����");
		login = new JMenuItem("�ϻ�");
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				LoginFrame_ loginFrame = new LoginFrame_();
				ScreenLocation.setLocationMid(loginFrame, "�ϻ�");
			}
		});
		logout = new JMenuItem("�»�");
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				LogoutFrame_ logoutFrame = new LogoutFrame_();
				ScreenLocation.setLocationMid(logoutFrame, "�»�");
			}
		});
		sysItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SetUpFrame.frame=frame;
				final SetUpFrame setup = new SetUpFrame();
				ScreenLocation.setLocationMid(setup, "����");
				setup.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						AdminToolsBar.enableButton(null);
						frame.setEnabled(true);
					}
				});
				frame.setEnabled(false);
				
			}
		});
		exitItem = new JMenuItem("�˳�ϵͳ");
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		
		
		menuMenu.add(login);
		menuMenu.add(logout);
		menuMenu.add(sysItem);
		menuMenu.add(exitItem);
		return menuMenu;
	}
	
	
}
