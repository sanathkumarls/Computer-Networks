//write a java program for congestion control using leaky bucket algorithm

import java.util.*;
public class LBC 
{
	public static void main(String[] args) 
	{
		int bktcap,remain=0,n,dr,i,total,op;
		Scanner s=new Scanner(System.in);
		System.out.println("ENTER THE BUCKET CAPACITY : ");
		bktcap=s.nextInt();
		System.out.println("ENTER THE NO. OF PACKETS ; ");
		n=s.nextInt();
		int pkt[]=new int[n+1];
		System.out.println("ENTER THE OUTPUT DATARATE :");
		dr=s.nextInt();
		System.out.println("ENTER THE INPUT VALUES :");
		for(i=0;i<n;i++)
			pkt[i]=s.nextInt();
		for(i=0;i<=n;i++)
		{
			total=pkt[i]+remain;
			if(total > bktcap)
			{
				if(pkt[i] > bktcap)
				{
					System.out.println("INCOMING PACKET SIZE IS "+pkt[i]+" BYTES IS GREATER THAN BUCKET SIZE OF "+bktcap+" BYTES");
					System.out.println("BUCKET SIZE EXCEEDED PACKET IS REJECTED");
				}
				else
					System.out.println("BUCKET SIZE EXCEEDED PACKET IS REJECTED");
			}
			else
			{
				remain+=pkt[i];
				System.out.println("INCOMING PACKET SIZE IS : "+pkt[i]);
				if(remain <= dr)
				{
					op=remain;
					remain=0;
				}
				else
				{
					op=dr;
					remain-=dr;
				}
				System.out.println("PACKET OF SIZE "+op+" IS TRANSMITTED");
				System.out.println("REMAINING CAPACITY IS : "+remain);
			}
		}
		s.close();	
	}
}

/*
OUTPUT :
ENTER THE BUCKET CAPACITY : 
50
ENTER THE NO. OF PACKETS ; 
5
ENTER THE OUTPUT DATARATE :
30
ENTER THE INPUT VALUES :
60 40 20 10 50
INCOMING PACKET SIZE IS 60 BYTES IS GREATER THAN BUCKET SIZE OF 50 BYTES
BUCKET SIZE EXCEEDED PACKET IS REJECTED
INCOMING PACKET SIZE IS : 40
PACKET OF SIZE 30 IS TRANSMITTED
REMAINING CAPACITY IS : 10
INCOMING PACKET SIZE IS : 20
PACKET OF SIZE 30 IS TRANSMITTED
REMAINING CAPACITY IS : 0
INCOMING PACKET SIZE IS : 10
PACKET OF SIZE 10 IS TRANSMITTED
REMAINING CAPACITY IS : 0
INCOMING PACKET SIZE IS : 50
PACKET OF SIZE 30 IS TRANSMITTED
REMAINING CAPACITY IS : 20
INCOMING PACKET SIZE IS : 0
PACKET OF SIZE 20 IS TRANSMITTED
REMAINING CAPACITY IS : 0
*/