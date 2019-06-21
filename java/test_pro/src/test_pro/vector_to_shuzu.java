package test_pro;

import java.util.Vector;

public class vector_to_shuzu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hex[]={0x80,0x40,0x20,0x10,0x08,0x04,0x02,0x01};
		byte a=(byte) 0xff;
		//System.out.println((Integer.toBinaryString((byte)a&0x80)));
		
		for(int i=0;i<8;i++)
		{
			if((hex[i]&a)>0)
			{
				System.out.print(1);
				System.out.print("\t");
			}
			else
			{
				System.out.print(0);
				System.out.print("\t");
			}
			
		}
		System.out.println("endl");
		System.out.println(a&0x80);
//		byte[] by_for_recv =new byte[4];//过程数据
//		Vector array=new Vector(2,2);
//		by_for_recv[0]=(byte) 0xff;
//		by_for_recv[1]=(byte) 0xff;
//		by_for_recv[2]=(byte) 0xff;
//		by_for_recv[3]=(byte) 0xff;
//		System.out.println(by_for_recv[0]);
//		System.out.println(by_for_recv[1]);
//		System.out.println(by_for_recv[2]);
//		System.out.println(by_for_recv[3]);
//		by_for_recv[0]=(byte) 0x0f;
//		by_for_recv[1]=(byte) 0x0f;
//		by_for_recv[2]=(byte) 0x0f;
//		by_for_recv[3]=(byte) 0x0f;
//		System.out.println(by_for_recv[0]);
//		System.out.println(by_for_recv[1]);
//		System.out.println(by_for_recv[2]);
//		System.out.println(by_for_recv[3]);
	}

}
