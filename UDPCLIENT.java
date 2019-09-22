import java.util.*;
import java.net.*;
public class UDPCLIENT 
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("CLIENT");
		System.out.println("RECEIVED MESSAGE IS : ");
		DatagramSocket ds =new DatagramSocket(3000);
		byte buf[]=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf,1024);
		while(true)
		{
			ds.receive(dp);
			String msg=new String(dp.getData(),0,dp.getLength());
			System.out.println(msg);
		}
	}
}
