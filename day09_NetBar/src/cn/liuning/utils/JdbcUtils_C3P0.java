package cn.liuning.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * JdbcUtils_C3P0 ģ��
 * @author liuning
 *
 */
public class JdbcUtils_C3P0 {
	private static ComboPooledDataSource dataSource = null;
	
	/**
	 * ��ʼ�����ݿ����ӳ�
	 */
	static{
		try {
			//��ָ���Ļ���ʹ��ȱʡ������
			dataSource=new ComboPooledDataSource("liuning");
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	/**
	 * ��ȡ����
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	/**
	 * �ͷ���Դ
	 */
	public static void release(Connection conn,Statement st,ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		if(st!=null){
			try{
				st.close();
			}catch (Exception e){
				e.printStackTrace();
			}
			
		}
		if(conn!=null){
			try{
				conn.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}	
	}
	
	/**
	 * �滻dao�е���ɾ�ķ���
	 * @param sql
	 * @param params
	 * @return
	 */
	public static boolean update(String sql,Object params[]){
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs= null;
		try{
			conn = getConnection();
			//Ԥ����sql��䣬�������ʺţ���Ҫ��Object�����滻
			st = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				st.setObject(i+1, params[i]);
			}
			int count = st.executeUpdate();
			System.out.println("Ӱ��ļ�¼����"+count);
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}finally{
			release(conn, st, rs);
		}
	}
	
	/**
	 * �滻dao�е���ɾ�ķ���   ----- �Լ��ͷ���Դ,������Ҫ�Լ�������������ݿ����.
	 * @param sql
	 * @param params
	 * @return
	 */
	public static boolean update_acid(String sql,Object params[]){
		Connection conn = null;
		PreparedStatement st = null;
		try{
			conn = getConnection();
			st = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				st.setObject(i+1, params[i]);
			}
			st.executeUpdate();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	

	/**
	 * �滻����dao�еĲ�ѯ ,����ģʽ,��֪������Ĳ���,���û�������.
	 * ResultSetHandler ��һ���ӿ�,���,�û��Լ�д�Ĵ�����Ҫʵ������ӿ�.
	 * ����ʵ��д�������õ�Handler���õ�ʱ��ֱ��ʹ��
	 * @param sql
	 * @param params
	 * @param rsh
	 * @return
	 */
	public static Object query(String sql,Object params[], ResultSetHandler rsh){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs= null;
		try{
			conn = getConnection();
			st = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				st.setObject(i+1, params[i]);
			}
			rs = st.executeQuery();
			//��֪���Խ������ô�������û�������ô����Լ���û����д�����ӿڼ���
			return rsh.handler(rs);

		}catch (Exception e){
			e.printStackTrace();
			return null;
		}finally{
			release(conn, st, rs);
		}
	}
}
