package test_pro;
import java.awt.BorderLayout;  
import java.awt.Container;  
import java.awt.Dimension;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
  
import javax.swing.JButton;  
import javax.swing.JFileChooser;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
import javax.swing.JScrollPane;  
import javax.swing.JTextArea;  

 
	  
	
	  
	public class s01 implements ActionListener {  
	    JFrame jf = null;  
	    JLabel jl = null;  
	    JTextArea jta = null;  
	    JFileChooser jfc = null;  
	    private Object Finally;  
	    public s01()  {  
	        jf = new JFrame("FileChooser Example");  
	        Container jcp = jf.getContentPane();  
	        jta = new JTextArea();  
	        JScrollPane jsp = new JScrollPane(jta);  
	        jsp.setPreferredSize(new Dimension(350, 300));  
	        JPanel jp = new JPanel();  
	        JButton jbt1 = new JButton("新建文件");  
	        JButton jbt2 = new JButton("存储文件");  
	        jbt1.addActionListener(this);  
	        jbt2.addActionListener(this);  
	        jp.add(jbt1);  
	        jp.add(jbt2);  
	        jl = new JLabel("", JLabel.CENTER);  
	        jfc = new JFileChooser("D:\\");  
	        jcp.add(jl, BorderLayout.NORTH);  
	        jcp.add(jsp, BorderLayout.CENTER);  
	        jcp.add(jp, BorderLayout.SOUTH);  
	        jf.pack();  
	        jf.setVisible(true);  
	        jf.addWindowListener(new WindowAdapter() {  
	            public void windowClosing(WindowEvent e) {  
	                System.exit(0);  
	            }  
	        });  
	    }  
	    public static void main(String[] args) {  
	        new s01();  
	    }  
	    public void actionPerformed(ActionEvent e) {  
	        File file = null;  
	        int result;  
	        FileInputStream fin = null;  
	        FileOutputStream fout = null;  
	        if(e.getActionCommand().equals("新建文件")) {  
	            jfc.setApproveButtonText("确定");  
	            jfc.setDialogTitle("打开文件");  
	            result = jfc.showOpenDialog(jf);  
	            jta.setText("");  
	            if(result==jfc.APPROVE_OPTION) {  
	                file = jfc.getSelectedFile();  
	                jl.setText("您选择打开的文件名称为： " + file.getName());  
	            } else if(result==jfc.CANCEL_OPTION) {  
	                jl.setText("您没有选择任何文件");  
	            }  
	        }  
	        if(file!=null) {  
	            try {  
	                fin = new FileInputStream(file);  
	            } catch (FileNotFoundException e1) {  
	                jl.setText("File not found");  
	                return;  
	            }  
	        }  
	        int readbyte;  
	        try {  
	            while((readbyte=fin.read())!=-1) {  
	                jta.append(String.valueOf((char)readbyte));  
	            }  
	        } catch (IOException e2) {  
	            jl.setText("读取文件错误");  
	        }  
	        finally {  
	            try {  
	                if(fin!=null) {   
	                    fin.close();  
	                }  
	            } catch (IOException e3) {}  
	        }  
	        if(e.getActionCommand().equals("存储文件")) {  
	            result = jfc.showSaveDialog(jf);  
	            file = null;  
	            String fileName;  
	            if(result==jfc.APPROVE_OPTION) {  
	                file = jfc.getSelectedFile();  
	                jl.setText("您选择存储的文件名称为： " + file.getName());  
	            } else if(result==jfc.CANCEL_OPTION) {  
	                jl.setText("您没有选择任何文件");  
	            }  
	        }  
	        if(file!=null) {  
	            try {  
	                fout = new FileOutputStream(file);  
	            } catch (FileNotFoundException e4) {  
	                jl.setText("File not found");  
	                return;  
	            }  
	            String content = jta.getText();  
	            try {  
	                fout.write(content.getBytes());  
	            } catch (IOException e5) {  
	                jl.setText("写入文件错误");  
	            }  
	            finally {  
	                if(fout!=null) {  
	                    try {  
	                        fout.close();  
	                    } catch (IOException e6) {}  
	                }  
	            }  
	        }  
	    }  
	}  

