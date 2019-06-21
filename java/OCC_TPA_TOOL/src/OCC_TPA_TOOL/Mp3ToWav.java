/*
 * Mp3ToWav.java -- mp3解码后存wav
 */
package OCC_TPA_TOOL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import OCC_TPA_TOOL.PublicMethod;

public class Mp3ToWav {
	
	public final int onePacketAudioLength = 1024;
	
	public List<byte[]> audioList = new ArrayList<byte[]>();
	
	private byte[] leftAudioData = null;
	
	private boolean isOpened = false;
	
	private String path = null;
	
	private FileOutputStream writer = null;
	
	private long totalSize = 0;
	
	private byte[] wavHeader = new byte[44];
	
	/**
	 * 
	 * @param path 为null时，不写wav文件
	 */
	public Mp3ToWav(String path)
	{
		this.path = path;
		
		this.isOpened = open();

	}

	public boolean open()
	{
		if (this.path != null)
		{
			try 
			{
				writer = new FileOutputStream(this.path, true);
				writer.write(wavHeader);
				return true;
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				return false;
			}
		}
		else 
		{
			return true;
		}
	}
	
	/**
	 * 
	 * @param b
	 * @param off
	 * @param size  保证大于0
	 */
	private void writeToList(byte[] b, int off, int size) 
	{
		if (size == 0) System.err.println("size == 0");
		
		byte[] audio_data = null;
		byte[] audio_data_tmp = Arrays.copyOfRange(b, off, off + size);
		if (leftAudioData != null)
		{
			audio_data = PublicMethod.byteMerger(leftAudioData, audio_data_tmp);
		}
		else 
		{
			audio_data = audio_data_tmp;
		}
		if (audio_data.length >= onePacketAudioLength)
		{
			int packet_count = audio_data.length / onePacketAudioLength;
			int left_len = audio_data.length % onePacketAudioLength;
			
			for (int i = 0; i < packet_count; i++)
			{
				byte[] audioData = Arrays.copyOfRange(audio_data, i * onePacketAudioLength, (i + 1) * onePacketAudioLength);
				audioList.add(audioData);
			}
			
			if (left_len > 0)
			{
				leftAudioData = Arrays.copyOfRange(audio_data, packet_count * onePacketAudioLength, audio_data.length);
			}
			else 
			{
				leftAudioData = null;
			}
		}
		else 
		{
			leftAudioData = audio_data;
		}
	}

	public int write(byte[] b, int off, int size)
	{
		if (isOpened)
		{
			int w = 0;
			
			try 
			{
				if (writer != null)
				{
					writer.write(b, off, size);
				}
				writeToList(b, off, size);
				w = size;
				//System.out.println("-------" + size);
			} 
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			totalSize += w;
			return w;
		}
		else
		{
			return 0;
		}
	}

	public void close()
	{
		if (isOpened)
		{
			if (writer != null)
			{
				try 
				{
					writer.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}

			if (totalSize > 0)
			{
				if (this.path != null)
				{
					File file = new File(this.path);
					//写入wav头数据
					wavHeader = PublicMethod.createWavHeader(44100, 1, 16, totalSize + 44);
					try 
					{
						RandomAccessFile raw = new RandomAccessFile(file, "rw");
						raw.seek(0l);
						raw.write(wavHeader);
						raw.close();
						
						System.out.println("mp3 to wav done!");
					} 
					catch (FileNotFoundException e)
					{
						e.printStackTrace();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					file = null;
				}
				
				//最后剩余的数据补0放入list
				if (leftAudioData != null)
				{
					byte[] b = new byte[onePacketAudioLength];
					for (int i = 0; i < leftAudioData.length; i++)
					{
						b[i] = leftAudioData[i];
					}
					audioList.add(b);
					leftAudioData = null;
				}
			}
			else 
			{
				if (this.path != null)
				{
					File file = new File(this.path);
					//删除wav
					file.delete(); 
					
					file = null;
				}
			}
		}
	}
}
