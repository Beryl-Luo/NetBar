package cn.liuning.dao;

import java.util.Date;
import java.util.List;

import cn.liuning.javabean.CurrentRecord;

public interface CurrentRecordDao {

	/**
	 * ���û��ϻ�����ô��¼����Ҫ�������
	 */
	public abstract boolean addRecord(CurrentRecord record);

	/**
	 * �����û����Ų�ѯ��¼��Ϣ
	 */
	public abstract CurrentRecord findRecordOfUserCard(String card);

	/**
	 * ���������Ų�ѯ�û��ϻ���Ϣ
	 */
	public abstract CurrentRecord findRecordOfHost(String host);

	/**
	 * �û��»�����¼���ɾ������
	 */
	public abstract boolean deleteRecord(String usercard);

	/**
	 * �õ�ʵʱ��¼����Ϣ(�������û��ϻ�����Ϣ)
	 * @return List<CurrentRecord>
	 */
	public abstract List<CurrentRecord> findAllCurrentRecord();

	/**
	 * �������ݿⱣ��� �û������û�����.
	 * @param money
	 * @return
	 */
	public abstract boolean updateAllUserMoney(String money);

	/**
	 * ���³���ʱ��
	 */
	public abstract boolean updateDuTime(String money);

	/**
	 * �õ���ʼʱ��
	 */
	public abstract Date getstartTime(String usercard);

	/**
	 * ����BeanList��ѯ��ѯ
	 */
	public abstract List<CurrentRecord> otherBcFind(String sql);

}