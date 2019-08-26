//write a java program for error detecting code using CRC-CCITT(16 bits)

import java.util.*;
public class CRC {

	public static void main(String[] args) 
	{
		
		int n,m,i,len;
		Scanner s=new Scanner(System.in);
		System.out.println("ENTER THE NO. OF DATA BITS : ");
		n=s.nextInt();
		int data[]=new int[n];
		System.out.println("ENTER THE DATA BITS : ");
		for(i=0;i<n;i++)
			data[i]=s.nextInt();
		System.out.println("ENTER THE NO. OF DIVISOR BITS : ");
		m=s.nextInt();
		int divisor[]=new int[m];
		System.out.println("ENTER THE DIVISOR BITS : ");
		for(i=0;i<m;i++)
			divisor[i]=s.nextInt();
		len=n+m-1;
		int dividend[]=new int[len],rem[]=new int[len],crc[]=new int[len];
		for(i=0;i<n;i++)
			rem[i]=dividend[i]=data[i];
		System.out.print("THE DIVIDEND AFTER APPENDING ZERO : ");
		for(i=0;i<len;i++)
			System.out.print(dividend[i]+" ");
		System.out.println();
		rem=divide(divisor,rem);
		for(i=0;i<len;i++)
			crc[i]=dividend[i]^rem[i];
		System.out.print("THE CRC CODE OF LENGTH "+len+" BITS IS : ");
		for(i=0;i<len;i++)
			System.out.print(crc[i]+" ");
		System.out.println();
		System.out.println("ENTER THE CRC CODE AT RECEIVER SIDE : ");
		for(i=0;i<len;i++)
			rem[i]=s.nextInt();
		rem=divide(divisor,rem);
		for(i=0;i<len;i++)
		{
			if(rem[i]!=0)
			{
				System.out.println("ERROR !!!");
				System.exit(0);
			}
		}
		System.out.println("NO ERROR...");	
		s.close();
	}
	
	static int[]  divide(int divisor[],int rem[])
	{
		int cur=0,i;
		while(true)
		{
			for(i=0;i<divisor.length;i++)
				rem[cur+i]=rem[cur+i]^divisor[i];
			while(rem[cur]==0 && cur != rem.length - 1)
				cur++;
			if((rem.length - cur) < divisor.length)
				break;
		}
		return rem;
	}
}

/*
OUTPUT:
ENTER THE NO. OF DATA BITS : 
4
ENTER THE DATA BITS : 
1 0 0 1
ENTER THE NO. OF DIVISOR BITS : 
4
ENTER THE DIVISOR BITS : 
1 0 1 1
THE DIVIDEND AFTER APPENDING ZERO : 1 0 0 1 0 0 0 
THE CRC CODE OF LENGTH 7 BITS IS : 1 0 0 1 1 1 0 
ENTER THE CRC CODE AT RECEIVER SIDE : 
1 0 0 1 1 1 0
NO ERROR...
*/

/*
OUTPUT:
ENTER THE NO. OF DATA BITS : 
4
ENTER THE DATA BITS : 
1 0 0 1
ENTER THE NO. OF DIVISOR BITS : 
4
ENTER THE DIVISOR BITS : 
1 0 1 1
THE DIVIDEND AFTER APPENDING ZERO : 1 0 0 1 0 0 0 
THE CRC CODE OF LENGTH 7 BITS IS : 1 0 0 1 1 1 0 
ENTER THE CRC CODE AT RECEIVER SIDE : 
1 0 0 1 1 1 1
ERROR !!!
*/