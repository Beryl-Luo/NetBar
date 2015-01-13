package cn.liuning.dao.impl;

import java.util.List;

import cn.liuning.dao.ComputerDao;
import cn.liuning.javabean.Computer;
import cn.liuning.utils.BeanListHandler;
import cn.liuning.utils.JdbcUtils_C3P0;
import cn.liuning.utils.SingleValueHanler;


/**
 * ����������ݿ������
 * 
 * @author liuning
 *
 */
public class ComputerDaoImpl implements ComputerDao{

	/**
	 * ����state��ѯ���е������Ż�����ʹ�õ�����������
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> findFreeHost(String state){
		String sql = "select hostnumber from ln_computer where state=?";
		Object params[]={state};
		return (List<String>) JdbcUtils_C3P0.query(sql, params, new SingleValueHanler());
	}
	
	/**
	 * ��ѯ��������
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Computer> findAllHost(){
		String sql = "select * from ln_computer";
		Object params[]={};
		return (List<Computer>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(Computer.class));
	}
	
	
	/**
	 * �����û��ϻ�ʱ�����������
	 * �޸�����״̬ һ���޸�Ϊ online
	 * �޸�Ϊofflineʹ��deleteHostState
	 */
	@Override
	public boolean updateHostState(String usercard,String nicaname,String hostnumber,String state){
		String sql = "update ln_computer set nickname=?,usercard=?,state=? where hostnumber=?";
		Object params[]={
				nicaname,usercard,state,hostnumber
		};
		return JdbcUtils_C3P0.update(sql, params);
	}
	
	/**
	 * �޸�����״̬Ϊoffline
	 */
	@Override
	public boolean deleteHostState(String hostnumber,String state){
		String sql = "update ln_computer set nickname=?,usercard=?,state=? where hostnumber=?";
		Object params[]={
				null,null,state,hostnumber
		};
		return JdbcUtils_C3P0.update(sql, params);
	}
	
	/**
	 * ��ѯ����Ϊ usercard���û�����ʹ�õ�����
	 */
	@Override
	@SuppressWarnings("unchecked")
	public String findUserHost(String usercard){
		String sql = "select hostnumber from ln_computer where usercard=?";
		Object params[]={usercard};
		List<String> list = (List<String>) JdbcUtils_C3P0.query(sql, params, new SingleValueHanler());
		return list.get(0).toString();
	}
	
	/**
	 * ������ѯ
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Computer> otherBcFind(String sql){
		Object params[]={};
		return (List<Computer>) JdbcUtils_C3P0.query(sql, params, new BeanListHandler(Computer.class));
	}
	
}
