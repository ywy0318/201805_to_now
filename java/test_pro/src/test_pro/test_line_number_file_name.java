package test_pro;

public class test_line_number_file_name {

	public test_line_number_file_name() {
		// TODO Auto-generated constructor stub
	}
	
	public static int getLineNumber() {
		return Thread.currentThread().getStackTrace()[2].getLineNumber();
	}
	public static String getFileName() {
		return Thread.currentThread().getStackTrace()[2].getFileName();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println(getFileName()+":"+"("+getLineNumber()+")");
	}

}
