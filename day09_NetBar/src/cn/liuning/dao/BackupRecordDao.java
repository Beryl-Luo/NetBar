package cn.liuning.dao;

import java.math.BigDecimal;
import java.util.List;

import cn.liuning.javabean.BackupRecord;

public interface BackupRecordDao {

	/**
	 * �û��»���Ҫ����¼���浽���ݱ���
	 * 
	 */
	public abstract boolean insertIntoBaRecord(BackupRecord backupRecord);

	/**
	 * �õ�������ʷ��¼��Ϣ
	 */
	public abstract List<BackupRecord> findAllBackupRecord();

	/*
	 * ��ѯ�û�usercard����ʷ��¼
	 */
	public abstract List<BackupRecord> findUserBackupRecord(String usercard);

	/**
	 * ��ѯ�ǳ�Ϊnickname�ĵ���ʷ��¼
	 */
	public abstract List<BackupRecord> findNickBackupRecord(String nickname);

	/**
	 * ��ѯ���ѽ�����max���û���Ϣ
	 */
	public abstract List<BackupRecord> findConsumeGeMax(BigDecimal max);

	/**
	 * ��ѯ���ѽ��С��min���û���Ϣ
	 */
	public abstract List<BackupRecord> findConsumeLeMin(BigDecimal min);

	/**
	 * ��ѯ���ѽ�����x���û���Ϣ
	 */
	public abstract List<BackupRecord> findConsumeEqMin(BigDecimal x);

	/**
	 * �����ʱ�����max����Ϣ
	 */
	public abstract List<BackupRecord> findDuraTimeGeMax(BigDecimal max);

	/**
	 * �����ʱ��С�ڵ���min����Ϣ
	 */
	public abstract List<BackupRecord> findDuraTimeLeMin(BigDecimal min);

	/**
	 * �����ʱ���������֮��Ĳ�ѯ��
	 */
	public abstract List<BackupRecord> findOfGeLeDuraTime(BigDecimal min,
			BigDecimal max);

	/**
	 * ��ѯĳ���µ���������  �������ͳ����
	 */
	public abstract List<Long> findCountOfYear(String year);

	/**
	 * ��ѯĳ���µ�����
	 */
	public abstract List<BigDecimal> findIncomeOfYear(String year);

	/**
	 * countOnlinePersonInAday
	 * @param dateTime
	 * @return
	 */
	public abstract Integer countOnlinePersonInAday(String dateTime);

	/**
	 * ��ѯĳһ�������
	 */
	public abstract BigDecimal countConsumeInAday(String dateTime);

	/**
	 * 
	 * @param dateTime
	 * @return
	 */
	public abstract Integer getstartTime(String dateTime);

	/**
	 * ���� ����BeanList�Ĳ�ѯ
	 */
	public abstract List<BackupRecord> otherBcFind(String sql);

}