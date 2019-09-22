import java.util.*;
import java.net.*;
public class UDPSERVER 
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("SERVER");
		Scanner s=new Scanner(System.in);
		DatagramSocket ds=new DatagramSocket();
		InetAddress ip=InetAddress.getByName("127.0.0.1");
		System.out.println("ENTER MESSAGE TO SEND : ");
		while(true)
		{
			String msg=s.nextLine();
			DatagramPacket dp=new DatagramPacket(msg.getBytes(),msg.length() , ip, 3000);
			ds.send(dp);
		}
	}
}
