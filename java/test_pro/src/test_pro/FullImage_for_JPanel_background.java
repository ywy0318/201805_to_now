package test_pro;

import java.awt.Graphics;

import javax.swing.*;

public class FullImage_for_JPanel_background extends JFrame {
    public FullImage_for_JPanel_background() {
    	this.setLayout(null);
    	
        JPanel p = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                //ImageIcon icon = new ImageIcon(MyImageIcon.class.getResource("1.jpg"));
                ImageIcon ii = new ImageIcon(MyImageIcon.class.getResource("1.jpg"));
                //ImageIcon ii = new ImageIcon("1.jpg");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
            }
        };
        p.add(new JButton("按钮0"));//如果覆盖的是pain()方法，按钮会被挡住
        //p.setSize(100, 100);
        p.setBounds(0, 0, 200, 200);
        
        
        JPanel p1 = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                //ImageIcon icon = new ImageIcon(MyImageIcon.class.getResource("1.jpg"));
                ImageIcon ii = new ImageIcon(MyImageIcon.class.getResource("2.jpg"));
                //ImageIcon ii = new ImageIcon("1.jpg");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
            }
        };
        p1.add(new JButton("按钮1"));//如果覆盖的是pain()方法，按钮会被挡住
        //p.setSize(100, 100);
        p1.setBounds(200, 200, 200, 200);
        
        add(p);
        add(p1);
        this.setBounds(400, 400, 800, 800);
        //setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FullImage_for_JPanel_background();
    }
}

