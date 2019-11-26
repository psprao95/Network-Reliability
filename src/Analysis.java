

import java.text.DecimalFormat;

public class Analysis {

	private static DecimalFormat df=new DecimalFormat("#.####");
	public static void main (String[] args)
	{
		Reliability r= new Reliability();
		
		/* Values of graph parameters:
		 * Number of nodes n=10
		 * Topology: complete graph so m=10
		 */
		int n=5;
		int m=10;
		double p,h;
		int k;
		
		/* Compute reliability for a random value of component reliability p
		 * we set p=0.56 and k=0
		 */
		p=0.56;
		k=0;
		h=r.compute(5, 10, p,0);
		System.out.println("p= "+df.format(p)+"  Reliability: "+df.format(h));
		
		
		
		/* Task 1: Vary p and observing how the reliability changes 
		 * p: Reliability of an individual component
		 * Range of p values is [0,1]
		 * Step size: 0.04
		 * we set k=0 since we are not flipping any states
		 * */
		System.out.println("Vary p and observing how the reliability changes...");
		for(p=0;p<1.01;p=p+0.04)
		{
			h=r.compute(n,m,p,k);
			System.out.println("p= "+df.format(p)+"  Reliability: "+df.format(h));
			//System.out.println(df.format(p)+", "+df.format(h));
		}
		
		
		/* Task 2: Fix p and vary k and observe how reliability changes. Parameters:
		 * k: number of flipped states
		 * b: Number of trials for a given value of k to minimize randomness
		 * Fixing the value of p to 0.87
		 * Range of k is [0,25]
		 * Step size=1
		 */
		System.out.println("Fix p and vary k and observe how reliability changes...");
		p=0.87;
		int b=5;
		for(k=0;k<=25;k++)
		{
			double sum=0;
			for(int i=0;i<b;i++) {
			sum+=r.compute(n, m, p, k);
			
			}
			System.out.println("p = "+df.format(p)+"   k= "+k+"  reliability = "+df.format(sum/b));
			//System.out.println(k+","+df.format(sum/b));
		}
	}
}
