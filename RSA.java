//write a java program for simple RSA algorithm o encrypt and decrypt the data

import java.util.*;
public class RSA {

	public static void main(String[] args) {
		
		int p,q,fi,n,e,d;
		Scanner s=new Scanner(System.in);
		System.out.println("ENTER TWO PRIME NO. : ");
		p=s.nextInt();
		q=s.nextInt();
		n=p*q;
		fi=(p-1)*(q-1);
		System.out.println("ENTER A VALUE FOR e : ");
		e=s.nextInt();
		while(true)
		{
			if(FindGCD(e,fi) != 1)
			{
				System.out.println("ENTER ANOTHER VALUE FOR e : ");
				e=s.nextInt();
			}
			else
			break;
		}
		d=FindD(e,fi);
		System.out.println("VALUE OF D : "+d);
		System.out.println("ENTER PLAIN TEXT (NUMBER) : ");
		int m=s.nextInt();
		int c=(int)Math.pow(m, e)%n;
		System.out.println("CIPHER TEXT IS : "+c);
		int x=(int)Math.pow(c, d)%n;
		System.out.println("DECRYPTED TEXT : "+x);
		if(x==m)
			System.out.println("TEXT MATCHED");
		else
			System.out.println("TEXT MISMATCH");
		s.close();
	}
	
	static int FindGCD(int m, int n)
	{
		if(n==0)
			return m;
		else
			return FindGCD(n,m%n);
	}
	
	static int FindD(int e,int fi)
	{
		for(int i=1;i<=fi;i++)
		{
			if((e*i)%fi == 1)
				return i;
		}
		return 0;
	}
}

/*
OUTPUT :
ENTER TWO PRIME NO. : 
3 11
ENTER A VALUE FOR e : 
3
VALUE OF D : 7
ENTER PLAIN TEXT (NUMBER) : 
9
CIPHER TEXT IS : 3
DECRYPTED TEXT : 9
TEXT MATCHED
*/