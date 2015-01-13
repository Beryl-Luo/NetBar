package cn.liuning.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 
 * Bean������
 * @author liuning
 *
 */
@SuppressWarnings("rawtypes")
public class BeanHandler implements ResultSetHandler{
	
	
	private Class clazz;
	
	/**
	 * ���캯�������ĸ�Bean
	 * @param clazz
	 */
	public BeanHandler(Class clazz){
		this.clazz=clazz;
	}

	/**
	 * Bean������
	 */
	@Override
	public Object handler(ResultSet rs) {
		try {
				if(!rs.next())
				{
					return null;
				}
				
				//�½����յ�Bean��ʾ��,�൱��New��һ��Bean
				Object bean = clazz.newInstance();
				
				//��ȡԪ����,�����������,��������Ϣ
				ResultSetMetaData metadata = rs.getMetaData();
				//�õ���������м�������
				int columnCount=metadata.getColumnCount();
				
				//ѭ���õ�ÿһ�е�����,Ȼ��ͨ�����佫rs��ֵ����Bean��ʵ��
				for(int i=0;i<columnCount;i++){
					//�õ�ÿһ�е�����
					String columnName = metadata.getColumnName(i+1);
					//����е�����
					Object columnData = rs.getObject(i+1);
					//����,��bean��ֵ. �������������,Ҫ�ͱ������һ��
					Field f = clazz.getDeclaredField(columnName);
					//����Ϊ����ֵ
					f.setAccessible(true);
					f.set(bean, columnData);
				}
				return bean;	
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			throw new RuntimeException(e);
		}
	}
}
