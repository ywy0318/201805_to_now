package OCC_TPA_TOOL;

public class PublicMethod 
{
    
	/**
	 * 创建wav头结构
	 * @param sampleRate 采样率
	 * @param channels 声道数量
	 * @param bitsPerSample 位速
	 * @param fileLenIncludeHeader 数据长度 + 44
	 * @return 44字节wav头
	 */
	public static byte[] createWavHeader(int sampleRate, int channels, int bitsPerSample, long fileLenIncludeHeader) 
	{
        byte[] wavHeader = new byte[44];
        long totalDataLen = fileLenIncludeHeader - 8;
        long audioDataLen = totalDataLen - 36;

        wavHeader[0]  = 'R';
        wavHeader[1]  = 'I';
        wavHeader[2]  = 'F';
        wavHeader[3]  = 'F';
 
        wavHeader[4]  = (byte)(totalDataLen & 0xff);
        wavHeader[5]  = (byte)((totalDataLen >> 8) & 0xff);
        wavHeader[6]  = (byte)((totalDataLen >> 16) & 0xff);
        wavHeader[7]  = (byte)((totalDataLen >> 24) & 0xff);
 
        wavHeader[8]  = 'W';
        wavHeader[9]  = 'A';
        wavHeader[10] = 'V';
        wavHeader[11] = 'E';
 
        wavHeader[12] = 'f';
        wavHeader[13] = 'm';
        wavHeader[14] = 't';
        wavHeader[15] = ' ';
 
        wavHeader[16] = 0x10;
        wavHeader[17] = 0;
        wavHeader[18] = 0;
        wavHeader[19] = 0;
 
        wavHeader[20] = 1;
        wavHeader[21] = 0;
 
        wavHeader[22] = (byte) channels;
        wavHeader[23] = 0;
 
        wavHeader[24] = (byte)(sampleRate & 0xff);
        wavHeader[25] = (byte)((sampleRate >> 8) & 0xff);
        wavHeader[26] = (byte)((sampleRate >> 16) & 0xff);
        wavHeader[27] = (byte)((sampleRate >> 24) & 0xff);
 
        int bytePerSecond = sampleRate * (bitsPerSample / 8) * channels;
        wavHeader[28] = (byte)(bytePerSecond & 0xff);
        wavHeader[29] = (byte)((bytePerSecond >> 8) & 0xff);
        wavHeader[30] = (byte)((bytePerSecond >> 16) & 0xff);
        wavHeader[31] = (byte)((bytePerSecond >> 24) & 0xff);
 
        wavHeader[32] = (byte)(bitsPerSample * channels / 8);
        wavHeader[33] = 0;
 
        wavHeader[34] = (byte) bitsPerSample;
        wavHeader[35] = 0;
 
        wavHeader[36] = 'd';
        wavHeader[37] = 'a';
        wavHeader[38] = 't';
        wavHeader[39] = 'a';
 
        wavHeader[40] = (byte)(audioDataLen & 0xff);
        wavHeader[41] = (byte)((audioDataLen >> 8) & 0xff);
        wavHeader[42] = (byte)((audioDataLen >> 16) & 0xff);
        wavHeader[43] = (byte)((audioDataLen >> 24) & 0xff);
    	
        return wavHeader;
    }
	
	/**
	 * 合并2个byte数组
	 * @param bt1
	 * @param bt2
	 * @return 合并后的byte数组
	 */
	public static byte[] byteMerger(byte[] bt1, byte[] bt2)
	{  
        byte[] bt3 = new byte[bt1.length + bt2.length];  
        System.arraycopy(bt1, 0, bt3, 0, bt1.length);  
        System.arraycopy(bt2, 0, bt3, bt1.length, bt2.length);  
        return bt3;  
    }
}
