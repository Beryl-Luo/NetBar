package cn.liuning.dao.impl;

import java.util.Date;
import java.util.List;

import cn.liuning.dao.CurrentRecordDao;
import cn.liuning.javabean.CurrentRecord;
import cn.liuning.javabean.struct.UpdateTime;
import cn.liuning.utils.BeanHandler;
import cn.liuning.utils.BeanListHandler;
import cn.liuning.utils.JdbcUtils_C3P0;
import cn.liuning.utils.SingleValueHanler;

/**
 * ʵʱ��¼������ݿ��޸���
 *  addRecord
 *	findRecordOfUserCard
 *	deleteRecord
 *	and ....
 * @author liuning
 *
 */
public class CurrentRecordDaoImpl implements CurrentRecordDao {
	
	/**
	 * ���û��ϻ�����ô��¼����Ҫ�������
	 */
	@Override
	public boolean addRecord(CurrentRecord record){
		String sql="insert into ln_currentrecord" +
				"(usercard,nickname,duratime,starttime," +
				"currentCost,hostnumber,expectBanlance) values(?,?,?,?,?,?,?)";
		Object parames[]={
				record.getUsercard(),
				record.getNickname(),
				record.getDuratime(),
				record.getStarttime(),
				record.getCurrentCost(),
				record.getHostnumber(),
				record.getExpectBanlance()
		};
		return JdbcUtils_C3P0.update(sql, parames);
	}
	
	/**
	 * �����û����Ų�ѯ��¼��Ϣ
	 */
	@Override
	public CurrentRecord findRecordOfUserCard(String card){
		String sql = "select * from ln_currentrecord where usercard=?";
		Object params[]={card};
		return (CurrentRecord) JdbcUtils_C3P0.query(sql, params, new BeanHandler(CurrentRecord.class));
	}
	
	/**
	 * ���������Ų�ѯ�û��ϻ���Ϣ
	 */
	@Override
	public CurrentRecord findRecordOfHost(String host){
		String sql = "select * from ln_currentrecord where hostnumber=?";
		Object params[]={host};
		return (CurrentRecord) JdbcUtils_C3P0.query(sql, params, new BeanHandler(CurrentRecord.class));
	}
	
	/**
	 * �û��»�����¼���ɾ������
	 */
	@Override
	public boolean deleteRecord(String usercard){
		String sql="delete from ln_currentrecord where usercard=?";
		Object params[]={usercard};
		return JdbcUtils_C3P0.update(sql, params);
	}
	
	/**
	 * �õ�ʵʱ��¼����Ϣ(�������û��ϻ�����Ϣ)
	 * @return List<CurrentRecord>
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<CurrentRecord> findAllCurrentRecord(){
		String sql = "select * from ln_currentrecord";
		Object params[]={};
		return (List<CurrentRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(CurrentRecord.class));
	}
	
	/**
	 * �������ݿⱣ��� �û������û�����.
	 * @param money
	 * @return
	 */
	@Override
	public boolean updateAllUserMoney(String money){
		String sql1 = "update ln_currentrecord set currentCost=currentCost+?";
		Object params1[]={money};
		JdbcUtils_C3P0.update(sql1, params1);
		String sql = "update ln_currentrecord set expectBanlance=expectBanlance-?";
		Object params[]={money};
		return JdbcUtils_C3P0.update(sql, params);
	}
	
	/**
	 * ���³���ʱ��
	 */
	@Override
	public boolean updateDuTime(String money){

		List<UpdateTime> list = findAllOnlineUser();
		for(int i=0;i<list.size();i++){
			UpdateTime up = (UpdateTime)list.get(i);
			String str = up.getDuratime();
			String hour = str.split(":")[0];
			String minute = str.split(":")[1];
			String second = str.split(":")[2];
			
			int hour_i = Integer.parseInt(hour);
			int minute_i = Integer.parseInt(minute);
			int second_i = Integer.parseInt(second);
			String strTime = getDuraTime(second_i+6,minute_i,hour_i);
			
			String sql = "update ln_currentrecord set duratime=? where usercard=?";
			Object params[]={strTime,up.getUsercard()};
			JdbcUtils_C3P0.update(sql, params);
			
			String sql2 = "update ln_user set banlace=banlace-? where usercard=?";
			Object params2[]={money,up.getUsercard()};
			JdbcUtils_C3P0.update(sql2, params2);
		}
		return true;
	}
	/**
	 * ���ߺ��� ��װʱ��
	 */
	private String getDuraTime(int x, int y, int z) {
		if(x>=60){
    		y=y+1;
    		x=x%60;
    	}
    	if(y>=60){
    		z=z+1;
    		y=y%60;
    	}
    	String str = "";
    	if(z<10){
    		str=str+"0"+String.valueOf(z);
    	}else{
    		str += String.valueOf(z);
    	}
    	str+=":";
    	if(y<10){
    		str=str+"0"+String.valueOf(y);
    	}else{
    		str += String.valueOf(y);
    	}
    	str+=":";
    	if(x<10){
    		str=str+"0"+String.valueOf(x);
    	}else{
    		str += String.valueOf(x);
    	}
    	return str;
	}

	/**
	 * ��ѯ���ߵ������û���  �û���  �� duratime ��
	 * ����ϵͳ����ʱ��
	 */
	@SuppressWarnings("unchecked")
	private List<UpdateTime> findAllOnlineUser(){
		String sql = "select usercard,duratime from ln_currentrecord";
		Object params[]={};
		return (List<UpdateTime>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(UpdateTime.class));
	}
	
	
	
	//������ѯ......................................
	
	/**
	 * �õ���ʼʱ��
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Date getstartTime(String usercard){
		String sql="select starttime from ln_currentrecord where usercard=?";
		Object params[]={usercard};
		List<Date> list = (List<Date>) JdbcUtils_C3P0.query(sql, params, new SingleValueHanler());
		return list.get(0);
	}
	
	/**
	 * ����BeanList��ѯ��ѯ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<CurrentRecord> otherBcFind(String sql){
		Object params[]={};
		return (List<CurrentRecord>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(CurrentRecord.class));
	}
	
}









