package cn.liuning.UI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import cn.liuning.dao.BackupRecordDao;
import cn.liuning.dao.impl.BackupRecordDaoImpl;
import cn.liuning.utils.BarChart;

public class LeftPanel {
	
	/**
	 * ��ʼ������
	 */
	static JPanel leftPanel = new JPanel();
	static JLabel dateLabel;
	static JLabel timeLabel;
	static JLabel l_nameLabel;
	static JTextField l_nameText;
	static JTextField l_timeText;
	static JLabel l_consume;
	static JTextField l_consumeText;
	static JLabel l_banlance;
	static JTextField l_banlanceText;
	static JLabel l_idcardLabel;
	static JTextField l_idcardText;
	static JLabel l_timeLabel;
	static JComboBox personCount_m;
	static JComboBox incomeYear;
	static JComboBox incomeMouth;
	static JComboBox personCount_y;
	static String count_year="2014";
	static String count_mouth = "0";
	static String income_year = "2014";
	static String income_mouth = "0";
	static JButton confirm1 ;
	static JButton confirm2 ;
	static JLabel l_registerTime;
	static JTextField l_registerTimeText;
	
	
	/**
	 * �õ�����Ա��������ʾ�Ĵ���
	 * @return
	 */
	public static JPanel getLeftPanel2(){
		JLabel lblNewLabel = new JLabel("��������ͳ��:");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 106, 32);
		leftPanel.add(lblNewLabel);
		JLabel label_1 = new JLabel("����ͳ��:");
		label_1.setFont(new Font("����", Font.BOLD, 14));
		label_1.setBounds(10, 188, 106, 32);
		leftPanel.add(label_1);
		
		JLabel label_2 = new JLabel("���");
		label_2.setBounds(13, 239, 43, 15);
		leftPanel.add(label_2);
		
		JLabel label_3 = new JLabel("�·�");
		label_3.setBounds(12, 289, 43, 15);
		leftPanel.add(label_3);
		JLabel lblNewLabel_1 = new JLabel("���");
		lblNewLabel_1.setBounds(11, 52, 45, 15);
		leftPanel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("�·�");
		label.setBounds(11, 100, 47, 15);
		leftPanel.add(label);
		
		//�����ͳ������
		personCount_y = new JComboBox();
		personCount_y.setBounds(70, 52, 60, 21);
		personCount_y.addItem("2010");
		personCount_y.addItem("2011");
		personCount_y.addItem("2012");
		personCount_y.addItem("2013");
		personCount_y.addItem("2014");
		personCount_y.addItem("2015");
		leftPanel.add(personCount_y);
		
		//���·�ͳ������
		personCount_m = new JComboBox();
		personCount_m.setBounds(70, 97, 62, 21);
		personCount_m.addItem("0");
		personCount_m.addItem("1");
		personCount_m.addItem("2");
		personCount_m.addItem("3");
		personCount_m.addItem("4");
		personCount_m.addItem("5");
		personCount_m.addItem("6");
		personCount_m.addItem("7");
		personCount_m.addItem("8");
		personCount_m.addItem("9");
		personCount_m.addItem("10");
		personCount_m.addItem("11");
		personCount_m.addItem("12");
		leftPanel.add(personCount_m);
		
		//�����ͳ������
		incomeYear = new JComboBox();
		incomeYear.setBounds(70, 236, 60, 21);
		incomeYear.addItem("2010");
		incomeYear.addItem("2011");
		incomeYear.addItem("2012");
		incomeYear.addItem("2013");
		incomeYear.addItem("2014");
		incomeYear.addItem("2015");
		leftPanel.add(incomeYear);
		
		//���·�ͳ������
		incomeMouth = new JComboBox();
		incomeMouth.setBounds(70, 286, 60, 21);
		incomeMouth.addItem("0");
		incomeMouth.addItem("1");
		incomeMouth.addItem("2");
		incomeMouth.addItem("3");
		incomeMouth.addItem("4");
		incomeMouth.addItem("5");
		incomeMouth.addItem("6");
		incomeMouth.addItem("7");
		incomeMouth.addItem("8");
		incomeMouth.addItem("9");
		incomeMouth.addItem("10");
		incomeMouth.addItem("11");
		incomeMouth.addItem("12");
		leftPanel.add(incomeMouth);

		/**
		 * �����¼�
		 */
		personCount_y.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				count_year = personCount_y.getSelectedItem().toString();
			}
		});
		personCount_m.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				count_mouth = personCount_m.getSelectedItem().toString();
			}
		});
		incomeYear.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				income_year = incomeYear.getSelectedItem().toString();
			}
		});
		incomeMouth.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO �Զ����ɵķ������
				income_mouth = incomeMouth.getSelectedItem().toString();
			}
		});
		confirm1 = new JButton("ȷ��");
		confirm1.setBounds(34, 136, 64, 25);
		leftPanel.add(confirm1);
		confirm2 = new JButton("ȷ��");
		confirm2.setBounds(34, 326, 64, 25);
		leftPanel.add(confirm2);
		
		confirm1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if(count_mouth.equals("0")){
					BackupRecordDao backDao = new BackupRecordDaoImpl();
					List<Long> list = backDao.findCountOfYear(count_year);
					AdminFrame.centerPanel.setViewportView(new BarChart(list,"����ͳ��ͼ").getChartPanel());
					
				}else{
					System.out.println("���·�ͳ���д�ʵ��");
				}
				
			}
		});
		confirm2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if(income_mouth.equals("0")){
					BackupRecordDao backDao = new BackupRecordDaoImpl();
					List<BigDecimal> list = backDao.findIncomeOfYear((income_year));
					AdminFrame.centerPanel.setViewportView(new BarChart(list,"����ͳ��ͼ").getChartPanel());
				}else{
					System.out.println("���·�ͳ���д�ʵ��");
				}
			}
		});
		
		
		return leftPanel;
	}
	 
	public static JPanel getLeftPanel() {
		//���ڱ�ǩ
		dateLabel = new JLabel("2014-21-12", JLabel.CENTER);
		dateLabel.setFont(new Font("����", Font.BOLD, 14));
		dateLabel.setBounds(new Rectangle(16, 465, 90, 20));
		//ʱ���ǩ
		timeLabel = new JLabel("01:25:34", JLabel.CENTER);
		timeLabel.setFont(new Font("����", Font.BOLD, 14));
		timeLabel.setBounds(new Rectangle(16, 485, 90, 20));
		
		l_nameLabel = new JLabel("�� ��:");
		l_nameLabel.setFont(new Font("����", Font.BOLD, 14));
		l_nameLabel.setBounds(new Rectangle(22, 35, 90, 20));
		
		l_nameText = new JTextField();
		l_nameText.setFont(new Font("����", Font.BOLD, 14));
		l_nameText.setBounds(new Rectangle(83, 35, 87, 25));
		l_nameText.setHorizontalAlignment(JTextField.CENTER);
		l_nameText.setEditable(false);
		
		l_timeLabel = new JLabel("����ʱ��:");
		l_timeLabel.setFont(new Font("����", Font.BOLD, 14));
		l_timeLabel.setBounds(new Rectangle(12, 75, 90, 20));
		
		l_timeText = new JTextField();
		l_timeText.setFont(new Font("����", Font.BOLD, 14));
		l_timeText.setBounds(new Rectangle(83, 75, 87, 25));
		l_timeText.setHorizontalAlignment(JTextField.CENTER);
		l_timeText.setEditable(false);
		
		l_consume = new JLabel("������:");
		l_consume.setFont(new Font("����", Font.BOLD, 14));
		l_consume.setBounds(new Rectangle(18, 115, 90, 20));
		
		l_consumeText = new JTextField();
		l_consumeText.setFont(new Font("����", Font.BOLD, 14));
		l_consumeText.setBounds(new Rectangle(83, 115, 87, 25));
		l_consumeText.setHorizontalAlignment(JTextField.CENTER);
		l_consumeText.setEditable(false);
		
		l_banlance = new JLabel("���:");
		l_banlance.setFont(new Font("����", Font.BOLD, 14));
		l_banlance.setBounds(new Rectangle(22, 155, 90, 20));
		
		l_banlanceText = new JTextField(" ",JTextField.CENTER);
		l_banlanceText.setFont(new Font("����", Font.BOLD, 14));
		l_banlanceText.setBounds(new Rectangle(83, 155, 87, 25));
		l_banlanceText.setHorizontalAlignment(JTextField.CENTER);
		l_banlanceText.setEditable(false);
		
		l_idcardLabel = new JLabel("���֤��:");
		l_idcardLabel.setFont(new Font("����", Font.BOLD, 14));
		l_idcardLabel.setBounds(new Rectangle(12, 195, 90, 20));
		
		l_idcardText = new JTextField();
		l_idcardText.setFont(new Font("����", Font.BOLD, 12));
		l_idcardText.setBounds(new Rectangle(18, 230, 135, 25));
		l_idcardText.setHorizontalAlignment(JTextField.CENTER);
		l_idcardText.setEditable(false);
		
		l_registerTime = new JLabel("ע��ʱ��:");
		l_registerTime.setFont(new Font("����", Font.BOLD, 14));
		l_registerTime.setBounds(new Rectangle(12, 285, 90, 20));
		
		l_registerTimeText = new JTextField();
		l_registerTimeText.setFont(new Font("����", Font.BOLD, 12));
		l_registerTimeText.setBounds(new Rectangle(18, 320, 135, 25));
		l_registerTimeText.setHorizontalAlignment(JTextField.CENTER);
		l_registerTimeText.setEditable(false);
		
		
		//���������
		leftPanel.setLayout(null);
		leftPanel.add(dateLabel);
		leftPanel.add(timeLabel);
		leftPanel.add(l_nameLabel);
		leftPanel.add(l_timeLabel);
		leftPanel.add(l_consume);
		leftPanel.add(l_banlance);
		leftPanel.add(l_idcardLabel);
		leftPanel.add(l_registerTime);
		
		leftPanel.add(l_nameText);
		leftPanel.add(l_timeText);
		leftPanel.add(l_consumeText);
		leftPanel.add(l_banlanceText);
		leftPanel.add(l_idcardText);
		leftPanel.add(l_registerTimeText);
		leftPanel.setBorder(new CompoundBorder(new EtchedBorder(),
				new LineBorder(null)));
		leftPanel.setPreferredSize(new Dimension(180, 500));
		return leftPanel;
	}
}
