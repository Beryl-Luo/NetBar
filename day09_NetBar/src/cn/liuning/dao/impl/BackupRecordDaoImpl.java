package cn.liuning.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import cn.liuning.dao.BackupRecordDao;
import cn.liuning.javabean.BackupRecord;
import cn.liuning.utils.BeanListHandler;
import cn.liuning.utils.CountHandler;
import cn.liuning.utils.JdbcUtils_C3P0;
import cn.liuning.utils.SingleValueHanler;


/**
 * ��ʷ��¼��Ĳ�����
 * 
 * �������ڲ�ѯ��ʷ��¼�����ϵͳ����ͳ�Ʊ����ܡ�
 * @author liuning
 *
 */
public class BackupRecordDaoImpl implements BackupRecordDao{
	
	/**
	 * �û��»���Ҫ����¼���浽���ݱ���
	 * 
	 */
	@Override
	public boolean insertIntoBaRecord(BackupRecord backupRecord){
		String sql="insert into ln_backuprecord" +
				"(year,month,day,usercard,nickname,consume," +
				"startTime,duraTime,overTime,hostNumber) values(?,?,?,?,?,?,?,?,?,?)";
		Object parames[]={
				backupRecord.getYear(),
				backupRecord.getDay(),
				backupRecord.getMonth(),
				backupRecord.getUsercard(),
				backupRecord.getNickname(),
				backupRecord.getConsume(),
				backupRecord.getStartTime(),
				backupRecord.getDuraTime(),
				backupRecord.getOverTime(),
				backupRecord.getHostnumber()
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	
	/**
	 * �õ�������ʷ��¼��Ϣ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findAllBackupRecord(){
		String sql = "select * from ln_backuprecord";
		Object params[]={};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * ��ѯ�û�usercard����ʷ��¼
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findUserBackupRecord(String usercard){
		String sql = "select * from ln_backuprecord where usercard=?";
		Object params[]={usercard};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * ��ѯ�ǳ�Ϊnickname�ĵ���ʷ��¼
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findNickBackupRecord(String nickname){
		String sql = "select * from ln_backuprecord where nickname=?";
		Object params[]={nickname};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * ��ѯ���ѽ�����max���û���Ϣ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findConsumeGeMax(BigDecimal max){
		String sql = "select * from ln_backuprecord where consume>=?";
		Object params[]={max};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * ��ѯ���ѽ��С��min���û���Ϣ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findConsumeLeMin(BigDecimal min){
		String sql = "select * from ln_backuprecord where consume<=?";
		Object params[]={min};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * ��ѯ���ѽ�����x���û���Ϣ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findConsumeEqMin(BigDecimal x){
		String sql = "select * from ln_backuprecord where consume=?";
		Object params[]={x};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * �����ʱ�����max����Ϣ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findDuraTimeGeMax(BigDecimal max){
		String sql = "select * from ln_backuprecord where duraTime>=?";
		Object params[]={max};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * �����ʱ��С�ڵ���min����Ϣ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findDuraTimeLeMin(BigDecimal min){
		String sql = "select * from ln_backuprecord where duraTime<=?";
		Object params[]={min};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	/**
	 * �����ʱ���������֮��Ĳ�ѯ��
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> findOfGeLeDuraTime(BigDecimal min,BigDecimal max){
		String sql = "select * from ln_backuprecord where duraTime>=? and duraime<=?";
		Object params[]={max,min};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}

	/**
	 * ��ѯĳ���µ���������  �������ͳ����
	 */
	@Override
	public List<Long> findCountOfYear(String year){
		
		List<Long> list = new ArrayList<Long>();
		for(int i=1;i<=12;i++){
			String str = "";
			if(i<10){
				str+="0";
				str=str+String.valueOf(i);
			}else{
				str=String.valueOf(i);
			}
			long aa = findCount_Year(str,year);
			list.add(aa);
		}
		return list;
	}
	
	/**
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Long findCount_Year(String month,String year){
		String sql="select count(*) from ln_backuprecord where month=? and year=?";
		Object params[]={month,year};
		List list = (List) JdbcUtils_C3P0.query(sql, params, new CountHandler());
		return (Long) list.get(0);
	}
	
	/**
	 * ��ѯĳ���µ�����
	 */
	@Override
	public List<BigDecimal> findIncomeOfYear(String year){
		
		List<BigDecimal> list = new ArrayList<BigDecimal>();
		for(int i=1;i<=12;i++){
			String str = "";
			if(i<10){
				str+="0";
				str=str+String.valueOf(i);
			}else{
				str=String.valueOf(i);
			}
			BigDecimal aa = findIncome_Year(str,year);
			if(aa == null){
				list.add(new BigDecimal(0));
			}else{
				list.add(aa);
			}
		}
		return list;
	}
	
	/**
	 * findIncome_Year
	 * @param month
	 * @param year
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private BigDecimal findIncome_Year(String month,String year){
		String sql="select sum(consume) from ln_backuprecord where month=? and year=?";
		Object params[]={month,year};
		List<BigDecimal> list = (List<BigDecimal>) JdbcUtils_C3P0.query(sql, params, new SingleValueHanler());
		return list.get(0);
	}
	
	/**
	 * countOnlinePersonInAday
	 * @param dateTime
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Integer countOnlinePersonInAday(String dateTime){
		String sql="select * from ln_backuprecord where dateTime=?";
		Object params[]={dateTime};
		List<Integer> list = (List<Integer>) JdbcUtils_C3P0.query(sql, params, new SingleValueHanler());
		return list.get(0);
	}
	
	/**
	 * ��ѯĳһ�������
	 */
	@Override
	@SuppressWarnings("unchecked")
	public BigDecimal countConsumeInAday(String dateTime){
		String sql="select count(consume) from ln_backuprecord where dateTime=?";
		Object params[]={dateTime};
		List<BigDecimal> list = (List<BigDecimal>) JdbcUtils_C3P0.query(sql, params, new SingleValueHanler());
		return list.get(0);
	}
	
	/**
	 * 
	 * @param dateTime
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Integer getstartTime(String dateTime){
		String sql="select count(*) from ln_backuprecord where dateTime=?";
		Object params[]={dateTime};
		List<Integer> list = (List<Integer>) JdbcUtils_C3P0.query(sql, params, new SingleValueHanler());
		return list.get(0);
	}
	
	/**
	 * ���� ����BeanList�Ĳ�ѯ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<BackupRecord> otherBcFind(String sql){
		Object params[]={};
		return (List<BackupRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(BackupRecord.class));
	}
	
	
}









