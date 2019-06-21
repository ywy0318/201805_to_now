package OCC_TPA_TOOL;

import java.util.Calendar;

import OCC_TPA_TOOL.Audio;
import OCC_TPA_TOOL.IAudio;


/**
 * 生产音频时序
 * @author Administrator
 *
 */
public class AudioFrequencyProducer 
{
	public static final int MaxSerialNumber = 100000000; //要小于 Integer.MAX_VALUE / 2
	public static int SerialNumber = 0;
	
	static AudioFrequencyProduceThreadClass AudioFrequencyProduceThread = null;
	
	public static void Start()
	{
		if (AudioFrequencyProduceThread == null)
		{
			AudioFrequencyProduceThread = new AudioFrequencyProduceThreadClass();
			AudioFrequencyProduceThread.runFlag = true;
			AudioFrequencyProduceThread.start();
		}
	}
	
	public static void Stop()
	{
		if (AudioFrequencyProduceThread != null)
		{
			AudioFrequencyProduceThread.runFlag = false;
			try 
			{
				AudioFrequencyProduceThread.join();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			} 
			AudioFrequencyProduceThread = null;
		}
	}
}

class AudioFrequencyProduceThreadClass extends Thread
{
	public boolean runFlag = true;
	//public boolean runFlag = false;
	  public void run() 
	{
		IAudio audio = new Audio();
		boolean ret = audio.open(44100, 1, 1024);
		byte[] b = new byte[1024];
		while(runFlag == true && ret == true)
		{
			audio.write(b, 0, 1024);
			
			if (AudioFrequencyProducer.SerialNumber + 1 >= AudioFrequencyProducer.MaxSerialNumber)
			{
				AudioFrequencyProducer.SerialNumber = 0;
			}
			else 
			{
				AudioFrequencyProducer.SerialNumber++;
			}
			//System.out.println(AudioFrequencyProducer.SerialNumber);
			
			//Calendar c = Calendar.getInstance();
			//System.out.println("AudioFrequencyProducer.SerialNumber : " + AudioFrequencyProducer.SerialNumber + "[" + c.get(Calendar.MILLISECOND) + "]");
		}
		audio.close();
	}
}
