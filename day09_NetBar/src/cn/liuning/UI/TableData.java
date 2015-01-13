package cn.liuning.UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.liuning.dao.AdminDao;
import cn.liuning.dao.ComputerDao;
import cn.liuning.dao.CurrentRecordDao;
import cn.liuning.dao.UserDao;
import cn.liuning.dao.impl.AdminDaoImpl;
import cn.liuning.dao.impl.ComputerDaoImpl;
import cn.liuning.dao.impl.CurrentRecordDaoImpl;
import cn.liuning.dao.impl.UserDaoImpl;
import cn.liuning.javabean.Computer;
import cn.liuning.javabean.CurrentRecord;
import cn.liuning.javabean.User;

public class TableData {
	
	static JTable jTable=new JTable();
	static JTable jTable2=new JTable();
	
	
	/**
	 * �õ�    δ�ۼ����     ��ʾ����
	 */
	public static JTable getJTable(){
		jTable.setModel(getHomeModel());
		jTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		jTable.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=jTable.getSelectedRow();
				TableModel model=jTable.getModel();
				LeftPanel.l_nameText.setText((String)model.getValueAt(index, 6));
				LeftPanel.l_timeText.setText((String)model.getValueAt(index, 2));
				LeftPanel.l_consumeText.setText(model.getValueAt(index, 3).toString());
				LeftPanel.l_banlanceText.setText(model.getValueAt(index, 4).toString());
				
				UserDao userDao = new UserDaoImpl();
				User user = userDao.
						findUserOfUserCard((String)model.getValueAt(index, 7));
				if(user == null){
					LeftPanel.l_idcardText.setText("");
					LeftPanel.l_registerTimeText.setText("");
				}else{
					LeftPanel.l_idcardText.setText(user.getLicenceNumber());
					LeftPanel.l_registerTimeText.setText(user.getRegisterTime().toLocaleString());
				}

			}
			
		});
		return jTable;
	}
	
	/**
	 * �ĵõ�     �ۼ����     ��ʾ����
	 * @return
	 */
	public static JTable getJTable2(){
		jTable.setModel(getHomeModel2());
		jTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		return jTable;
	}
	
	/**
	 * �õ�����������ʾ��ģ��
	 */
	@SuppressWarnings("deprecation")
	private static  TableModel getHomeModel(){
		String[] colums = {
			"���","����","����ʱ��","��ǰ����","���","��ʼʱ��",
			"����","�û�����","״̬","����"
		};
		ComputerDao computerDao = new ComputerDaoImpl();
		CurrentRecordDao recordDao = new CurrentRecordDaoImpl();
		AdminDao adminDao = new AdminDaoImpl();
		
		List<Computer> computList = computerDao.findAllHost();
		
		Object[][] datas = new Object[computList.size()][10];
		Computer computer = new Computer();
		for(int i=0;i<computList.size();i++){
			computer = computList.get(i);
			datas[i][0] = i+1+"";
			datas[i][1] = computer.getHostnumber();
			if(computer.getState().equals("online")){
				CurrentRecord record = recordDao.
						findRecordOfHost(computer.getHostnumber());
				datas[i][2] = record.getDuratime();
				datas[i][3] = record.getCurrentCost();
				datas[i][4] = record.getExpectBanlance();
				datas[i][5] = record.getStarttime().toLocaleString().split(" ")[1];
				datas[i][6] = record.getNickname();
				datas[i][7] = record.getUsercard();
				datas[i][8] = "online";
				datas[i][9] = adminDao.findRate().getRate()+"Ԫ/h";
			}else{
				datas[i][2] = " ";
				datas[i][3] = " ";
				datas[i][4] = " ";
				datas[i][5] = " ";
				datas[i][6] = " ";
				datas[i][7] = " ";
				datas[i][8] = " ";
				datas[i][9] = " ";
			}
		}
		//������ʾ���ݣ�������
		return new DefaultTableModel(datas,colums);
	}
	
	/**
	 * �õ��������ʾģ��
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private static  TableModel getHomeModel2(){
		String[] colums = {
			"���","����","����ʱ��","��ǰ����","���","��ʼʱ��",
			"����","�û�����","״̬","����"
		};
		ComputerDao computerDao = new ComputerDaoImpl();
		CurrentRecordDao recordDao = new CurrentRecordDaoImpl();
		AdminDao adminDao = new AdminDaoImpl();
		
		List<Computer> computList = computerDao.findAllHost();
		
		Object[][] datas = new Object[computList.size()][10];
		Computer computer = new Computer();
		int k=0;
		for(int i=0;i<computList.size();i++){
			
			computer = computList.get(i);
			datas[k][0] = k+1+"";
			if(computer.getState().equals("online")){
				datas[k][1] = computer.getHostnumber();
				CurrentRecord record = recordDao.
						findRecordOfHost(computer.getHostnumber());
				datas[k][2] = record.getDuratime();
				datas[k][3] = record.getCurrentCost();
				datas[k][4] = record.getExpectBanlance();
				datas[k][5] = record.getStarttime().toLocaleString().split(" ")[1];
				datas[k][6] = record.getNickname();
				datas[k][7] = record.getUsercard();
				datas[k][8] = "online";
				datas[k][9] = adminDao.findRate().getRate()+"Ԫ/h";
				k++;
			}
		}
		for(int i=0;i<computList.size();i++){
			computer = computList.get(i);
			datas[k][0] = k+1+"";
			if(computer.getState().equals("offline")){
				datas[k][1] = computer.getHostnumber();
				datas[k][2] = "";
				datas[k][3] = "";
				datas[k][4] = "";
				datas[k][5] = "";
				datas[k][6] = "";
				datas[k][7] = "";
				datas[k][8] = "";
				datas[k][9] = "";
				k++;
			}
		}
		//������ʾ���ݣ�������
		return new DefaultTableModel(datas,colums);
	}
}







