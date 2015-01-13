package cn.liuning.dao;

import java.util.List;

import cn.liuning.javabean.Computer;

public interface ComputerDao {

	/**
	 * ����state��ѯ���е������Ż�����ʹ�õ�����������
	 */
	public abstract List<String> findFreeHost(String state);

	/**
	 * ��ѯ��������
	 */
	public abstract List<Computer> findAllHost();

	/**
	 * �����û��ϻ�ʱ�����������
	 * �޸�����״̬ һ���޸�Ϊ online
	 * �޸�Ϊofflineʹ��deleteHostState
	 */
	public abstract boolean updateHostState(String usercard, String nicaname,
			String hostnumber, String state);

	/**
	 * �޸�����״̬Ϊoffline
	 */
	public abstract boolean deleteHostState(String hostnumber, String state);

	/**
	 * ��ѯ����Ϊ usercard���û�����ʹ�õ�����
	 */
	public abstract String findUserHost(String usercard);

	/**
	 * ������ѯ
	 */
	public abstract List<Computer> otherBcFind(String sql);

}