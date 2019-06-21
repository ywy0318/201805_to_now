package test_pro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class test_filechooser extends JFrame implements ActionListener{

	

	 
	

		JButton open=null;
		public static void main(String[] args) {
			new test_filechooser();
		}
		public test_filechooser(){
			open=new JButton("open");
			this.add(open);
			this.setBounds(400, 200, 100, 100);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			open.addActionListener(this);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			test_filechooser jfc=new test_filechooser();
			jfc.setFileSelectionMode(test_filechooser.FILES_AND_DIRECTORIES );
			jfc.showDialog(new JLabel(), "选择");
			File file=jfc.getSelectedFile();
			if(file.isDirectory()){
				System.out.println("文件夹:"+file.getAbsolutePath());
			}else if(file.isFile()){
				System.out.println("文件:"+file.getAbsolutePath());
			}
			System.out.println(jfc.getSelectedFile().getName());
			
		}
	 
	

}
