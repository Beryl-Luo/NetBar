package cn.liuning.utils;
import java.awt.BasicStroke;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
 
/**
 * ��ͼ��
 * @author liuning
 *
 */
public class BarChart {
   
	
	/**
	 * ���ݽ��յ����� ������ͼ
	 * 
	 * �õĵ�����jar��
	 */
	
	ChartPanel panel;
    static List<BigDecimal> list;
    static String title="";
    
    /**
     * �޲εĹ��캯��
     */
    public  BarChart(){
    	
    }
    
    /**
     * ���캯����ʼ��
     * @param list
     * @param title
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public  BarChart(List list,String title){
    	BarChart.title=title;
    	BarChart.list=list;
        CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
        					title, // ͼ�����
                            "����", // Ŀ¼�����ʾ��ǩ
                            "����", // ��ֵ�����ʾ��ǩ
                            dataset, // ���ݼ�
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                            true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
                            false,          // �Ƿ����ɹ���
                            false           // �Ƿ�����URL����
                            );
        BarRenderer renderer = new BarRenderer(); 
        renderer.setItemLabelAnchorOffset(10d);
        renderer  
        .setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
        renderer.setBaseItemLabelsVisible(true); 
       
        //�����￪ʼ
        CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������
        plot.setRenderer(renderer);  
        CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�
        domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����
        domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����
        ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״
        rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
        chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
        rangeAxis.setAxisLineStroke(new BasicStroke(1.6f));
        //���������������
        panel=new ChartPanel(chart,true);        //����Ҳ������chartFrame,����ֱ������һ��������Frame
          
    }
    private static CategoryDataset getDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       
        for(int i=1;i<=12;i++){
        	 dataset.addValue(list.get(i-1),"",String.valueOf(i));
        }
        return dataset;
    }
    
    /**
     * ��ȡͼ����ʾ���
     * @return
     */
    public ChartPanel getChartPanel(){
    	return panel;
     
    }
}