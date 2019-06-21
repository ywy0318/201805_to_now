package test_pro;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TestThread extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel jPanel1 = new JPanel();
	JButton startButton = new JButton();
	JButton stopButton = new JButton();
	MyThread thread = null;
	private boolean isContinue;
	public TestThread() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startButton.setText("start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startButton_actionPerformed(e);
			}
		});
		stopButton.setText("stop");
		stopButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopButton_actionPerformed(e);
			}
		});
		this.getContentPane().add(jPanel1, BorderLayout.CENTER);
		jPanel1.add(startButton);
		startButton.setBounds(36, 105, 82, 30);
		jPanel1.add(stopButton);
		stopButton.setBounds(160, 108, 100, 31);
		//jPanel1.setBounds(400, 400, 400, 400);
	}
	
	void startButton_actionPerformed(ActionEvent e) {
		if (thread != null)
			isContinue=false;
		thread = new MyThread();
		thread.start();
	}
	
	void stopButton_actionPerformed(ActionEvent e) {
		if (thread != null)
			isContinue=false;
		thread = null;
	}
	
	public static void main(String[] args) {
		TestThread test = new TestThread();
		test.setBounds(400,400,400, 400);
		test.setVisible(true);
	}
	
	private class MyThread extends Thread {
		public MyThread() {
			isContinue=true;
		}
		
		public void run() {
			System.out.println("\n\n");
			//while (true) {
			while (true && isContinue) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Java 编程词典\thttp://www.mrbccd.com");
			}
		}
	}
}
