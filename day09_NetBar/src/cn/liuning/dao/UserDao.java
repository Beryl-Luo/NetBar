package cn.liuning.dao;

import java.util.List;

import cn.liuning.javabean.User;

public interface UserDao {

	/**
	 * ��Աע��
	 */
	public abstract boolean addUser(User user);

	/**
	 * ���ݿ��ŶԻ�Ա��Ϣ�����޸�
	 */
	public abstract boolean updateUser(User user, String card);

	/**
	 * �����û�card��
	 * �����û�״̬-ʹ�û���ΪOnline
	 */
	public abstract boolean updateState_Online(String card);

	/**
	 * �����û�card��
	 * �����û�״̬-ʹ�û���Ϊoffline
	 */
	public abstract boolean updateState_Offline(String card);

	/**
	 * �����û���card��
	 * �Ի�Ա���г�ֵ
	 */
	public abstract boolean recharge(double money, String card);

	/**
	 * ɾ���û���Ϣ
	 */
	public abstract boolean delete(String card);

	/**
	 * �����û����ţ���ѯ�����û�����Ϣ
	 */
	public abstract User findUserOfUserCard(String card);

	/**
	 * ��ѯ���id���û���Ϣ
	 */
	public abstract User findMaxidInfo();

	/**
	 * ��ѯ�����û�����Ϣ
	 */
	public abstract List<User> findAllUser();

	/**
	 * ��ѯ���֤��Ϊ idcard���û���Ϣ
	 */
	public abstract User findUserOfIdcard(String idCard);

	/**
	 * ����nickname��ѯ�û�����Ϣ
	 */
	public abstract User findUserOfNickname(String nickname);

	/**
	 * ���ݲ��� state�ɲ�ѯ�������߻��������û�����Ϣ��
	 */
	public abstract List<User> findManyUserOfState(String state);

	/**
	 * ����sex��ѯ�����û�����Ϣ
	 */
	public abstract List<User> findManyUserOfSex(String sex);

	/**
	 * ��ѯ������ڵ���min���û���Ϣ
	 * Ҫ���ѯ���Ϊ0���û���ϢҲ����ʹ�������ѯ
	 */
	public abstract List<User> findBleMin(float min);

	/**
	 * ��ѯ�����ڵ���max���û���Ϣ
	 */
	public abstract List<User> findBgeMax(float max);

	/**
	 * ����BeanList��ѯ��ѯ
	 */
	public abstract List<User> otherBcFind(String sql);

}