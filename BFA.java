//Write a java program to find the shortest path between vertices using bellman-ford
 
import java.util.*;
public class BFA 
{
	public static void main(String[] args) 
	{
		final int max=999;
		int i,j,k,n,d,b[]=new int[10],a[][]=new int[30][30];
		Scanner s=new Scanner(System.in);
		System.out.println("ENTER THE NO. OF NODES :");
		n=s.nextInt();
		System.out.println("ENTER THE ADJACENCY MATRIX :");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				if((a[i][j]=s.nextInt())== 0)
					a[i][j]=max;
			}
		}
		System.out.println("THE ENTERED MATRIX IS : ");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		System.out.println("ENTER THE DESTINATION NODE :");
		d=s.nextInt();
		for(i=1;i<=n;i++)
			b[i]=max;
		b[d]=0;
		for(i=1;i<=n-1;i++)
		{
			for(j=1;j<=n;j++)
			{
				for(k=1;k<=n;k++)
					if(a[j][k] != max)
					{
						if(b[k] > b[j] + a[j][k])
							b[k]=b[j] + a[j][k];
					}		
			}
		}
		for(j=1;j<=n;j++)
		{
			for(k=1;k<=n;k++)
				if(a[j][k] != max)
				{
					if(b[k] > b[j] + a[j][k])
						System.out.println("NEGATIVE EDGE CYCLE");
				}
		}
		for(i=1;i<=n;i++)
			System.out.println("MINIMUM DISTANCE FROM NODE "+i+" TO NODE "+d+" IS "+b[i]);
		s.close();
	}
}

/*
OUTPUT:
ENTER THE NO. OF NODES :
6
ENTER THE ADJACENCY MATRIX :
0 2 5 1 999 999
2 0 3 2 999 999
5 3 0 3 1 5
1 2 3 0 1 999
999 999 1 1 0 2
999 999 5 999 2 999
THE ENTERED MATRIX IS : 
999 2 5 1 999 999 
2 999 3 2 999 999 
5 3 999 3 1 5 
1 2 3 999 1 999 
999 999 1 1 999 2 
999 999 5 999 2 999 
ENTER THE DESTINATION NODE :
6
MINIMUM DISTANCE FROM NODE 1 TO NODE 6 IS 4
MINIMUM DISTANCE FROM NODE 2 TO NODE 6 IS 5
MINIMUM DISTANCE FROM NODE 3 TO NODE 6 IS 3
MINIMUM DISTANCE FROM NODE 4 TO NODE 6 IS 3
MINIMUM DISTANCE FROM NODE 5 TO NODE 6 IS 2
MINIMUM DISTANCE FROM NODE 6 TO NODE 6 IS 0
*/
