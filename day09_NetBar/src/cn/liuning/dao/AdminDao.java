package cn.liuning.dao;

import java.util.List;

import cn.liuning.javabean.Admin;

public interface AdminDao {

	/**
	 * ���¼Ʒѷ�ʽ
	 */
	public abstract boolean updateRate(String rate);

	/**
	 * ��ѯ����
	 */
	public abstract Admin findRate();

	/**
	 * ɾ������Ա
	 */

	public abstract boolean delete(String card);

	/**
	 * ���ӹ���Ա
	 */

	public abstract boolean addAdmin(Admin admin);

	/**
	 * ��ѯ����Ա�ڲ���
	 */
	public abstract Admin findAdmin(String card);

	/**
	 * �������й���Ա����Ϣ
	 */
	public abstract List<Admin> findAllAdmin();

}