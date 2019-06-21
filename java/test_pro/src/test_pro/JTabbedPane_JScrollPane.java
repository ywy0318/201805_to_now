package test_pro;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;



	public class JTabbedPane_JScrollPane{
		JFrame frame;
		JTabbedPane_JScrollPane(){
		frame = new JFrame("TabbedPane");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 150);
		frame.setVisible(true);
		JTabbedPane tabbedPane = new JTabbedPane();
		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setLayout(arg0);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //水平滚动条不显示
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); //垂直滚动条总是显示
		tabbedPane.addTab("JScrollPane", scrollPane);
		JPanel panel = new JPanel();
		tabbedPane.addTab("JPanel", panel);
		frame.add(tabbedPane, BorderLayout.CENTER);
		}
	
	public static void main(String[] args){
		new JTabbedPane_JScrollPane();
		}
}