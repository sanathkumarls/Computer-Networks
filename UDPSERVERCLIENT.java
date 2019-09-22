import java.util.*;
import java.net.*;
class SENDER extends Thread
{
	public void run()
	{
		try
		{
			System.out.println("Enter Message And Press Enter : ");
			Scanner s=new Scanner(System.in);
			DatagramSocket ds_sender=new DatagramSocket();
			while(true)
			{
				String msg_sender=s.nextLine();
				InetAddress ip=InetAddress.getByName("127.0.0.1");
				DatagramPacket dp_sender=new DatagramPacket(msg_sender.getBytes(),msg_sender.length(),ip,3000);
				ds_sender.send(dp_sender);
			}	
		}
		catch(Exception e)
		{
		
		}

		
	}
}
class RECEIVER extends Thread
{
	public void run()
	{

		try
		{
			Scanner s=new Scanner(System.in);
			DatagramSocket ds_receiver=new DatagramSocket(3000);
			while(true)
			{
				byte[] buf=new byte[1024];
				DatagramPacket dp_receiver=new DatagramPacket(buf,1024);
				ds_receiver.receive(dp_receiver);
				String msg_receiver=new String(dp_receiver.getData(),0,dp_receiver.getLength());
				System.out.println("				"+msg_receiver);
			}	
		}
		catch(Exception e)
		{
		
		}
		
	}
}
class UDPSERVERCLIENT
{
	public static void main(String[] a) throws Exception
	{
		SENDER s=new SENDER();
		s.start();
		RECEIVER r=new RECEIVER();
		r.start();
	}
}
