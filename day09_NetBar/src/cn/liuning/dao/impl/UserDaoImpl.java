package cn.liuning.dao.impl;

import java.util.List;

import cn.liuning.dao.UserDao;
import cn.liuning.javabean.User;
import cn.liuning.utils.BeanHandler;
import cn.liuning.utils.BeanListHandler;
import cn.liuning.utils.JdbcUtils_C3P0;


/**
 * �û�����޸���
 * �����û���Ϣ����ɾ�Ĳ�
 * @author liuning
 *
 */
public class UserDaoImpl implements UserDao {
	
	/**
	 * ��Աע��
	 */
	@Override
	public boolean addUser(User user){
		String sql = "insert into ln_user" +
				"(usercard,password,banlace,licenceNumber," +
				"sex,nickname,phoneNumber,userState,registerTime)" +
				" values(?,?,?,?,?,?,?,?,?)";
		Object parames[]={
				user.getUsercard(),
				user.getPassword(),
				user.getBanlace(),
				user.getLicenceNumber(),
				user.getSex(),
				user.getNickname(),
				user.getPhoneNumber(),
				user.getUserState(),
				user.getRegisterTime()
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	
	/**
	 * ���ݿ��ŶԻ�Ա��Ϣ�����޸�
	 */
	@Override
	public boolean updateUser(User user,String card){
		String sql = "update ln_user set sex=?,nickname=?,phoneNumber=?,password=?,banlace=? where usercard=?";
		Object parames[]={
				user.getSex(),
				user.getNickname(),
				user.getPhoneNumber(),
				user.getPassword(),
				user.getBanlace(),
				card
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	
	/**
	 * �����û�card��
	 * �����û�״̬-ʹ�û���ΪOnline
	 */
	@Override
	public boolean updateState_Online(String card){
		String sql = "update ln_user set userState=? where usercard=?";
		Object parames[]={
				"online",card
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	
	/**
	 * �����û�card��
	 * �����û�״̬-ʹ�û���Ϊoffline
	 */
	@Override
	public boolean updateState_Offline(String card){
		String sql = "update ln_user set userState=? where usercard=?";
		Object parames[]={
				"offline",card
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	
	/**
	 * �����û���card��
	 * �Ի�Ա���г�ֵ
	 */
	@Override
	public boolean recharge(double money,String card){
		String sql = "update ln_user set banlace=banlace+? where usercard=?";
		Object parames[]={
				money,card
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	
	/**
	 * ɾ���û���Ϣ
	 */
	@Override
	public boolean delete(String card){
		System.out.println("******");
		String sql = "delete from ln_user where usercard=?";
		Object params[]={card};
		return JdbcUtils_C3P0.update(sql, params);
	}
	
	/**
	 * �����û����ţ���ѯ�����û�����Ϣ
	 */
	@Override
	public User findUserOfUserCard(String card){
		String sql = "select * from ln_user where usercard=?";
		Object params[]={card};
		return (User) JdbcUtils_C3P0.query(sql, params, new BeanHandler(User.class));
	}
	
	/**
	 * ��ѯ���id���û���Ϣ
	 */
	@Override
	public User findMaxidInfo(){
		String sql = "select * from ln_user where id=(select max(id) from ln_user)";
		Object params[]={};
		return (User) JdbcUtils_C3P0.query(sql, params, new BeanHandler(User.class));
	}
	
	/**
	 * ��ѯ�����û�����Ϣ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAllUser(){
		String sql = "select * from ln_user";
		Object params[]={};
		return (List<User>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(User.class));
	}
	
	
	
	//�������ܵĲ�ѯ.......................................................
	
	/**
	 * ��ѯ���֤��Ϊ idcard���û���Ϣ
	 */
	@Override
	public User findUserOfIdcard(String idCard){
		String sql = "select * from ln_user where licenceNumber=?";
		Object params[]={idCard};
		return (User) JdbcUtils_C3P0.query(sql, params, new BeanHandler(User.class));
	}
	
	/**
	 * ����nickname��ѯ�û�����Ϣ
	 */
	@Override
	public User findUserOfNickname(String nickname){
		String sql = "select * from ln_user where nickname=?";
		Object params[]={nickname};
		return (User) JdbcUtils_C3P0.query(sql, params, new BeanHandler(User.class));
	}
	
	/**
	 * ���ݲ��� state�ɲ�ѯ�������߻��������û�����Ϣ��
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findManyUserOfState(String state){
		String sql = "select * from ln_user where userState=?";
		Object params[]={state};
		return (List<User>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(User.class));
	}
	
	/**
	 * ����sex��ѯ�����û�����Ϣ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findManyUserOfSex(String sex){
		String sql = "select * from ln_user where sex=?";
		Object params[]={sex};
		return (List<User>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(User.class));
	}
	
	/**
	 * ��ѯ������ڵ���min���û���Ϣ
	 * Ҫ���ѯ���Ϊ0���û���ϢҲ����ʹ�������ѯ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findBleMin(float min){
		String sql = "select * from ln_user where banlace <=?";
		Object params[]={min};
		return (List<User>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(User.class));
	}
	
	/**
	 * ��ѯ�����ڵ���max���û���Ϣ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> findBgeMax(float max){
		String sql = "select * from ln_user where banlace >=?";
		Object params[]={max};
		return (List<User>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(User.class));
	}
	
	/**
	 * ����BeanList��ѯ��ѯ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> otherBcFind(String sql){
		Object params[]={};
		return (List<User>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(User.class));
	}
}











