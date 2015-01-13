package cn.liuning.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import Decoder.BASE64Encoder;


/**
 * ���ù����� 
 * 1.�õ�MD5���ܵ�ֵ
 * 2.InputStream-2-String
 * 3.ͨ�õ�list beanԪ���������
 * 4.�õ��������
 * 5.�ڴ������� List ���ϵ������ѡһ��������
 * @author liuning
 *
 */
public class PublicUtils {
	
	/**
	 * �õ�MD5���ܵ�ֵ
	 */
	public static String getMD5(String message){
			
		try {
			
			MessageDigest md=MessageDigest.getInstance("md5");
			byte md5[] = md.digest(message.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			//����һ�������ַ���
			return encoder.encode(md5);
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * InputStream-2-String
	 * ���ֽ�����new string��ʱ��ʹ��strָ���ı���new
	 * @param in
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String inputStreamtoString(InputStream in,String str) throws Exception{
		
		byte[] buffer = new byte[1024];
		int len = -1;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while((len = in.read(buffer)) != -1){
			baos.write(buffer, 0, len);
		}
		baos.close();
		in.close();
		byte[] lens = baos.toByteArray();
		return new String(lens,str);
	}
	
	/**
	 * ͨ�õ�list beanԪ���������
	 * @param list
	 * @param clazz
	 * @return String
	 */
	@SuppressWarnings("rawtypes")
	public static String outputListBeanInfo(List list,Class clazz){
		try {
			Object bean = clazz.newInstance();
			String result="[";
			for(int i=0;i<list.size();i++){
				bean = list.get(i);
				result+=bean.toString();
				if(i<list.size()-1){
					result+=",";
				}
			}
			result+="]";
			return result;
		} catch (InstantiationException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * �ڴ������� List ���ϵ������ѡһ��������
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getRandomHost(List list){
		
		int index=list.size();
		Random ran = new Random();
		int i = (ran.nextInt()%index)%index;
		return (String) list.get(i);
	}
	
	/**
	 * �û�ע���ʱ�򣬵õ��������
	 * @return String
	 */
	public static String getSecret(){
		String[] array = {"a","b","c","d","e","f","g",
				"j","h","i","k","m","n","p","q","r",
				"s","t","u","v","w","x","y","z","1","2","3",
				"4","5","6","7","8","9","A","C","B","D","E",
				"F","G","H","J","K",
				"L","M","N","P","Q","R","S","T","U","V","W",
				"X","Y","Z"};
		int i=0;
		String str="";
		while(i<6){
			Random ran = new Random();
			int temp = ran.nextInt();
			int sum = array.length;
			int index = (temp%sum+sum)%sum;
			str+=array[index];
			i++;
		}
		return str;
	}
	
	/**
	 * ʱ���1�뷵��
	 * @param times
	 * @return String
	 */
	public String getTimesAddoneSecond(String times){
		int seconds,minute,hour;
		hour = Integer.parseInt(times.split(":")[0]);
		minute = Integer.parseInt(times.split(":")[1]);
		seconds = Integer.parseInt(times.split(":")[2]);
		if(seconds>=60){
			minute=minute+1;
			seconds=seconds%60;
    	}
    	if(minute>=60){
    		hour=hour+1;
    		minute=minute%60;
    	}
    	String str = "";
    	if(hour<10){
    		str=str+"0"+String.valueOf(hour);
    	}else{
    		str += String.valueOf(hour);
    	}
    	str+=":";
    	if(minute<10){
    		str=str+"0"+String.valueOf(minute);
    	}else{
    		str += String.valueOf(minute);
    	}
    	str+=":";
    	if(seconds<10){
    		str=str+"0"+String.valueOf(seconds);
    	}else{
    		str += String.valueOf(seconds);
    	}
	    	return str;
	}
	
	public String string2Date(Calendar calendar) {
		
		// HH ��ʾ24Сʱ�ƣ� hh ��ʾ12Сʱ��
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sf.format(calendar.getTime());
	
        return time;
	}
}





