package cn.liuning.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ���������� ����ֻ��һ��ֵ��list
 * @author liuning
 *
 */
public class CountHandler implements ResultSetHandler{

	/**
	 * count(*)��ѯ  ��ѯ��ֵ�Ĵ�����  ----  ����������
 	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object handler(ResultSet rs) {
		try{
			List list = new ArrayList();
			while(rs.next()){
	
				ResultSetMetaData metadata = rs.getMetaData();
				int count = metadata.getColumnCount();
				for(int i=0;i<count;){
					long value = (Long) rs.getObject("count(*)");
					list.add(value);
					break;
				}
			}
			return list.size()>0?list:null;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
