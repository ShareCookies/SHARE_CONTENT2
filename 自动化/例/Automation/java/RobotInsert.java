
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RobotInsert {
	private static int second1 = 25;
	private static Thread t;
	public static void main(String[] args) {
		drawFrame();
	}
	public static void drawFrame(){
        // 创建 JFrame 实例
        JFrame frame = new JFrame("Example");
        // Setting the width and height of frame
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();    
        // 添加面板
        frame.add(panel);
        /* 
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
	}
	private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);
        
     // 创建 JLabel
        JLabel userLabel1 = new JLabel("秒:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel1.setBounds(10,20,80,25);
        panel.add(userLabel1);

        /* 
         * 创建文本域用于用户输入
         */
        final JTextField userText1 = new JTextField(20);
        userText1.setBounds(100,20,165,25);
        userText1.setText("25");
        panel.add(userText1);
       
     // 创建 JLabel
        JLabel userLabel = new JLabel("运行状态:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(10,50,80,25);
        panel.add(userLabel);

        /* 
         * 创建文本域用于用户输入
         */
        final JTextField userText = new JTextField(20);
        userText.setBounds(100,50,165,25);
        userText.setText("未运行");
        panel.add(userText);
        
        // 创建结束按钮
        JButton stopButton = new JButton("结束");
        stopButton.setBounds(100,90,165,25);
        panel.add(stopButton);
        stopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				second1 = Integer.parseInt(userText1.getText());
				ThreadStop();
				userText.setText("已结束运行");
			}
		});
        
        // 创建运行按钮
        JButton loginButton = new JButton("运行");
        loginButton.setBounds(10, 120, 80, 25);
        panel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				second1 = Integer.parseInt(userText1.getText());
				userText.setText("正在运行");
				threadStart();
			}
		});
    }
	public static void pressMouse(Robot r,int m,int delay){
		r.mousePress(m);
		r.delay(10);
		r.mouseRelease(m);
	}
	public static void pressKeyShang(Robot robot){
		//输入箭头 上,
        robot.keyPress(KeyEvent.VK_UP);  
        robot.keyRelease(KeyEvent.VK_UP);  
        robot.delay(500);  
        //回车
        robot.keyPress(KeyEvent.VK_ENTER);    
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(500);
	}
	public static void pressKey(Robot robot,int keyEvent){
        robot.keyPress(keyEvent);  
        robot.keyRelease(keyEvent);  
        robot.delay(50);
	}
	/**
	 * 图片上传
	 * @param rb
	 */
	public static void tabPressPicUpload(Robot rb){
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_U);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_A);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_5);
		pressKey(rb,KeyEvent.VK_4);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_1);
		pressKey(rb,KeyEvent.VK_8);
		pressKey(rb,KeyEvent.VK_2);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_ENTER);
	}
	/**
	 * 文字上传
	 * @param rb
	 */
	public static void tabPressTextUpload(Robot rb){
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_U);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_A);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_1);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_1);
		pressKey(rb,KeyEvent.VK_8);
		pressKey(rb,KeyEvent.VK_2);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_ENTER);
	}
	/**
	 * 起APK
	 * @param rb
	 */
	public static void tabPressApk(Robot rb){
		pressKey(rb,KeyEvent.VK_A);
		pressKey(rb,KeyEvent.VK_M);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_S);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_A);
		pressKey(rb,KeyEvent.VK_R);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_MINUS);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_C);
		pressKey(rb,KeyEvent.VK_O);
		pressKey(rb,KeyEvent.VK_M);
		pressKey(rb,KeyEvent.VK_PERIOD);
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_S);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_U);
		pressKey(rb,KeyEvent.VK_R);
		pressKey(rb,KeyEvent.VK_PERIOD);
		pressKey(rb,KeyEvent.VK_H);
		pressKey(rb,KeyEvent.VK_E);
		pressKey(rb,KeyEvent.VK_L);
		pressKey(rb,KeyEvent.VK_L);
		pressKey(rb,KeyEvent.VK_O);
		pressKey(rb,KeyEvent.VK_W);
		pressKey(rb,KeyEvent.VK_O);
		pressKey(rb,KeyEvent.VK_R);
		pressKey(rb,KeyEvent.VK_D);
		pressKey(rb,KeyEvent.VK_SLASH);
		pressKey(rb,KeyEvent.VK_C);
		pressKey(rb,KeyEvent.VK_O);
		pressKey(rb,KeyEvent.VK_M);
		pressKey(rb,KeyEvent.VK_PERIOD);
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_S);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_U);
		pressKey(rb,KeyEvent.VK_R);
		pressKey(rb,KeyEvent.VK_PERIOD);
		pressKey(rb,KeyEvent.VK_H);
		pressKey(rb,KeyEvent.VK_E);
		pressKey(rb,KeyEvent.VK_L);
		pressKey(rb,KeyEvent.VK_L);
		pressKey(rb,KeyEvent.VK_O);
		pressKey(rb,KeyEvent.VK_W);
		pressKey(rb,KeyEvent.VK_O);
		pressKey(rb,KeyEvent.VK_R);
		pressKey(rb,KeyEvent.VK_D);
		pressKey(rb,KeyEvent.VK_PERIOD);
		pressKey(rb,KeyEvent.VK_CAPS_LOCK);
		pressKey(rb,KeyEvent.VK_M);
		pressKey(rb,KeyEvent.VK_CAPS_LOCK);
		pressKey(rb,KeyEvent.VK_A);
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_CAPS_LOCK);
		pressKey(rb,KeyEvent.VK_A);
		pressKey(rb,KeyEvent.VK_CAPS_LOCK);
		pressKey(rb,KeyEvent.VK_C);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_V);
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_Y);
		pressKey(rb,KeyEvent.VK_ENTER);
	}
	/**
	 * 点击复制
	 * @param rb
	 */
	public static void tabPressCopy(Robot rb){
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_U);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_A);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_9);
		pressKey(rb,KeyEvent.VK_8);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_1);
		pressKey(rb,KeyEvent.VK_1);
		pressKey(rb,KeyEvent.VK_6);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_ENTER);
	}
	/**
	 * 返回
	 * @param rb
	 */
	public static void tabPressBack(Robot rb){
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_U);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_K);
		pressKey(rb,KeyEvent.VK_E);
		pressKey(rb,KeyEvent.VK_Y);
		pressKey(rb,KeyEvent.VK_E);
		pressKey(rb,KeyEvent.VK_V);
		pressKey(rb,KeyEvent.VK_E);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_4);
		pressKey(rb,KeyEvent.VK_ENTER);
	}
	/**
	 * 保存图片
	 * @param rb
	 */
	public static void tabPressSaveImg(Robot rb){
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_U);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_A);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_6);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_1);
		pressKey(rb,KeyEvent.VK_7);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_ENTER);
	}
	/**
	 * 查看大图
	 * @param rb
	 */
	public static void tabPressLookBig(Robot rb){
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_U);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_A);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_6);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_4);
		pressKey(rb,KeyEvent.VK_8);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_ENTER);
	}
	/**
	 * 分享
	 * @param rb
	 */
	public static void tabPressShare(Robot rb){
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_U);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_A);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_5);
		pressKey(rb,KeyEvent.VK_4);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_1);
		pressKey(rb,KeyEvent.VK_8);
		pressKey(rb,KeyEvent.VK_2);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_ENTER);
	}
	/**
	 * 向上滑动
	 * @param rb
	 */
	public static void tabPressSwipe(Robot rb){
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_U);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_S);
		pressKey(rb,KeyEvent.VK_W);
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_E);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_5);
		pressKey(rb,KeyEvent.VK_4);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_4);
		pressKey(rb,KeyEvent.VK_8);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_5);
		pressKey(rb,KeyEvent.VK_4);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_1);
		pressKey(rb,KeyEvent.VK_9);
		pressKey(rb,KeyEvent.VK_7);
		pressKey(rb,KeyEvent.VK_ENTER);
	}
	/**
	 * 点击item
	 */
	public static void tabPressItem(Robot rb){
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_U);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_A);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_5);
		pressKey(rb,KeyEvent.VK_4);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_4);
		pressKey(rb,KeyEvent.VK_8);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_ENTER);
	}
	/**
	 * 点击关闭
	 */
	public static void tabPressClose(Robot rb){
		pressKey(rb,KeyEvent.VK_I);
		pressKey(rb,KeyEvent.VK_N);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_U);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_T);
		pressKey(rb,KeyEvent.VK_A);
		pressKey(rb,KeyEvent.VK_P);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_9);
		pressKey(rb,KeyEvent.VK_8);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_SPACE);
		pressKey(rb,KeyEvent.VK_9);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_0);
		pressKey(rb,KeyEvent.VK_ENTER);
	}
	public static void threadStart(){
		try {
			Thread.sleep(5000);
			Robot rb = new Robot();
			rb.mouseMove(518,339);
			rb.delay(500);
			pressMouse(rb,InputEvent.BUTTON1_MASK,500);
			pressKey(rb,KeyEvent.VK_A);
			pressKey(rb,KeyEvent.VK_D);
			pressKey(rb,KeyEvent.VK_B);
			pressKey(rb,KeyEvent.VK_SPACE);
			pressKey(rb,KeyEvent.VK_S);
			pressKey(rb,KeyEvent.VK_H);
			pressKey(rb,KeyEvent.VK_E);
			pressKey(rb,KeyEvent.VK_L);
			pressKey(rb,KeyEvent.VK_L);
			pressKey(rb,KeyEvent.VK_ENTER);
			Thread.sleep(4 * 1000);  
			 //线程使用示例一：  
	        t = new Thread() {  
	        	Robot rb = new Robot();
	            public void run() {  
	                while (true) {  
	                    try {
	                    	tabPressItem(rb);
	                    	Thread.sleep(second1 * 1000);  
	                    	tabPressShare(rb);
	                    	Thread.sleep(second1 * 1000);  
	                    	tabPressCopy(rb);
	                    	Thread.sleep(1 * 1000);  
	                    	tabPressClose(rb);
	                    	Thread.sleep(1 * 1000);  
	                    	tabPressLookBig(rb);
	                    	Thread.sleep(2 * 1000);  
	                    	tabPressSaveImg(rb);
	                    	Thread.sleep(4 * 1000);  
	                    	tabPressBack(rb);
	                    	Thread.sleep(1 * 1000);  
	                    	tabPressBack(rb);
	                    	Thread.sleep(1 * 1000);  
	                    	tabPressApk(rb);
	                    	Thread.sleep(3 * 1000);  
	                    	tabPressTextUpload(rb);
	                    	Thread.sleep(4 * 1000);  
	                    	tabPressPicUpload(rb);
	                    	Thread.sleep(5 * 1000);  
	                    	tabPressBack(rb);
	                    	Thread.sleep(4 * 1000);  
	                    	tabPressSwipe(rb);
	                        Thread.sleep(5 * 1000);  
	                    } catch (InterruptedException e) {  
	                        e.printStackTrace();  
	                    }  
	                }  
	            };  
	        }; 
	        t.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void ThreadStop(){
		//t.stop();
	}
}
