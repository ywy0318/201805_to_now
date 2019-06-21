package test_pro;

public class byte_array {
	byte[] by=new byte[10];
	byte [] byt=new byte[15];
	
	
	public void test()
	{
		int i=0;
		
		byt[0]=(byte)0x0f;
		byt[1]=(byte)0x0f;
		byt[2]=(byte)0x0f;
		byt[3]=(byte)0x0f;
		byt[4]=(byte)0x0f;
		
	for( i=0;i<by.length;i++)
	{
		by[i]=(byte)(i);
		System.out.println(by[i]);
	}
	System.out.println("---");
	System.arraycopy(by, 0, byt, 5, by.length);
	//System.arraycopy(src, srcSeq, Des, DesSeq, SrcLen);
	for(i=0;i<byt.length;i++)
	{
		System.out.println(byt[i]);
	}
	
	}
	
	public static void main(String[] args) throws Exception 
	{
		byte_array b=new byte_array();
		b.test();
	}
}
