package cn.liuning.utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;


/**
 * 
 * ��Ļ��λ - ʹ������ʾ������
 * @author liuning
 *
 */
public class ScreenLocation {
	
	/**
	 * frame :����
	 * Title :��������
	 * @param frame
	 * @param Title
	 */
	public static void setLocationMid(Component frame,String Title) {
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      Dimension frameSize = frame.getSize();
	      frame.setLocation((screenSize.width - frameSize.width) / 2,
	                        (screenSize.height - frameSize.height) / 2-30);
	      frame.setVisible(true);
	  }


}
