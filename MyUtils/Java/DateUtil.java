/**
 * 
 */
package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author hecaigui
 */
public class DateUtil {
	public static void main(String[] args) {
		
		Date date=new Date();//java.util.Date����ʵ������ʱ��ͱ�����ʱ�䣬ʱ����ʵ����ʱ��ʱ�����
		
		/**
		 * ͨ��java.util.Date��ȡʱ�����ʱ�������long�ͱ���
		 */
		date.getTime();//��ȡʱ���
		System.out.println(date.getTime());

		/**
		 * util.Dateת�������ݿ��ܱ����ʱ�䣺
		 * ������java.util.Dateת�� java.sql.Date��ת������sqlʱ����ͬ��
		 * java.sql����ʱ����ܣ�
		 * 	Date����ʾ���ڣ�ֻ�������գ�û��ʱ���롣�ᶪʧʱ�䣻
		 * 	Time����ʾʱ�䣬ֻ��ʱ���룬û�������ա��ᶪʧ���ڣ�
		 * 	Timestamp����ʾʱ�������������ʱ���룬�Լ����롣
		 * 	ע:util.Dateתsql.Date���ٴ�sql.Date��ȡʱ�������ʱ�����Ȼ������ʱ���롣
		 */
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		System.out.println(sqlDate);
		
		/**
		 * ���������Ƴ�n��
		 */
		Date date1 = new Date();//ȡʱ�� 
	    Calendar calendar  =   Calendar.getInstance();
	    calendar.setTime(date1); //��Ҫ��date����ת�Ƶ�Calender�����в���
	    calendar.add(calendar.DATE,2);//��������������n��.����������,������ǰ�ƶ� 
	    date1=calendar.getTime();   //���ʱ���������������һ��Ľ�� 
	    
		/**
		 * util.Date��ʽ�������:
		 */
		SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy��MM��dd�� hh:mm:ss");
		System.out.println(simpleDate.format(date));
		/**
		 * �ַ���ת��java.util.Date:
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//ע��HH:mm:ss��24���ƣ�hh:mm:ss��12����
    	try {
			Date begDate=sdf.parse("2018-06-20");
			System.out.println(begDate);
			//System.out.println(sdf.format(begDate));
		} catch (Exception e) {
			System.out.println("���ڳ���");
			e.printStackTrace();
		}
    	/**
    	 * java��ȡ�����գ�
    	 * 	1.��ȡ�����յ�ʱ�����
    	 * 		util.date��sdf��ʽ�����������ַ������ٰ��ַ���ת��util.Date:
    	 * 	2.������ȡ�����գ���ƴ��
    	 *  	
    	 */
    	Calendar rightCalendar = Calendar.getInstance();//��ȡ��ǰ������������Ϣ
        System.out.println("��: " + rightCalendar.get(Calendar.YEAR));  
        System.out.println("��: " + (rightCalendar.get(Calendar.MONTH) + 1));  
        System.out.println("��: " + rightCalendar.get(Calendar.DAY_OF_MONTH));  
        rightCalendar.get(Calendar.HOUR_OF_DAY);//ʱ
        rightCalendar.get(Calendar.MINUTE);//��
        rightCalendar.get(Calendar.SECOND);//��
        System.out.println("����: " + (rightCalendar.get(Calendar.DAY_OF_WEEK)-1));//�������ڴ������տ�ʼ���� 
        //calendar.add(Calendar.MONTH, 1);//���½���
        rightCalendar.set(calendar.get(Calendar.YEAR), rightCalendar.get(Calendar.MONTH)+1, 1);//��ʱ��Ϊ�¸��µ�һ��
        rightCalendar.add(Calendar.DAY_OF_MONTH, -1);//ʱ�䵹��һ��
    	System.out.println("�������һ�죺"+rightCalendar.get(Calendar.DAY_OF_MONTH));
    	/**
    	 * ʱ���һЩӦ��
    	 * https://blog.csdn.net/cynhafa/article/details/8053166
    	 */
		
	}
	

}
