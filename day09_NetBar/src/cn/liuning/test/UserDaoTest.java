package cn.liuning.test;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import cn.liuning.dao.UserDao;
import cn.liuning.dao.impl.UserDaoImpl;
import cn.liuning.javabean.User;
import cn.liuning.utils.PublicUtils;

public class UserDaoTest {
	
	UserDao userDao = new UserDaoImpl();
	
	/**
	 * �����û�
	 */
	@Test
	public void addUser(){
		User user = new User();
		user.setBanlace(new BigDecimal(15.322));
		user.setId(1);
		user.setLicenceNumber("37132419940307121X");
		user.setNickname("�������baef");
		user.setPassword("123456");
		user.setPhoneNumber("18369905108");
		user.setUsercard("05010");
		user.setUserState("offline");
		user.setSex("��");
		user.setRegisterTime(new Date());
		System.out.println(userDao.addUser(user));
	}
	/**
	 * �����û������޸��û���Ϣ����Ҫ�Ȳ�ѯ������ŵ�������Ϣ
	 * 
	 * ��д���޸ĵ���Ϣ
	 */
	@Test
	public void updateUser(){
		User user = new User();
		user.setBanlace(new BigDecimal(15.0));
		user.setId(1);
		user.setLicenceNumber("37132419940307151X");
		user.setNickname("�������aaa");
		user.setPassword("123456");
		user.setPhoneNumber("15853958849");
		user.setUsercard("121101");
		user.setUserState("offline");
		user.setSex("Ů");
		System.out.println(userDao.updateUser(user, "05009"));
	}
	
	/**
	 * �����û����Ÿ����û�״̬
	 * ʹ�û�״̬��ΪOnline
	 */
	@Test
	public void updateState_Online(){
		System.out.println(userDao.updateState_Online("05004"));
	}
	/**
	 * �����û����Ÿ����û�״̬
	 * ʹ�û�״̬��Ϊoffline
	 */
	@Test
	public void updateState_Offline(){
		System.out.println(userDao.updateState_Offline("05003"));
	}
	
	/**
	 * �����û���card��
	 * �Ի�Ա���г�ֵ
	 */
	@Test
	public void recharge(){
		System.out.println(userDao.recharge(15, "05002"));
	}
	
	/**
	 * ɾ���û���Ϣ����
	 */
	@Test
	public void delete(){
		System.out.println(userDao.delete("05001"));
	}
	
	/**
	 * ��ѯ�����û���Ϣ
	 */
	@Test
	public void findAllUser(){
		System.out.println(PublicUtils.outputListBeanInfo(userDao.findAllUser(), User.class));
	}
	
	/**
	 * ��ѯ�������min���û���Ϣ
	 */
	@Test
	public void findUser(){
		System.out.println(PublicUtils.outputListBeanInfo(userDao.findBleMin(20), User.class));
	}
	
	/**
	 *  ��ѯ�û��治����
	 */
	@Test
	public void findSingleUser(){
		User user = userDao.findUserOfUserCard("050000");
		if(user==null){
			System.out.println("AAAAAAA");
		}else{
			System.out.println("BBBBBBB");
		}
	}
	
}








