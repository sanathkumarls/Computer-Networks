import java.util.*;
public class LBC {

	public static void main(String[] args) {
		
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
		
		
	}

}
