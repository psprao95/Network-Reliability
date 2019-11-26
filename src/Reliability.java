

import java.util.ArrayList;

public class Reliability {
	
	/* storing the reference to the 10 edges in our graph */
	public static final int[] aSet={0,0,0,0,1,1,1,2,2,3};
	private static final int [] bSet={1,2,3,4,2,3,4,3,4,4};
	
	
	/* computes the reliability of a network with
	 * n : number of nodes
	 * m: number of edges:
	 * p: probability that a link does not fail
	 * k: number of states that must be flipped
	 */
	public double compute(int n,int m,double p, int k)
	{	
		ExhaustiveEnumeration e=new ExhaustiveEnumeration();
		
		ArrayList<ArrayList<Integer>>res=e.generateStates(10);
		int[][] graph;
		
		
		double reliability=0.00;
		int fail;
		
		/* select k random states to flip */
		ArrayList<Integer> flipSet=new ArrayList<Integer>();
		double range=Math.pow((int)2, (int)m);
		while(flipSet.size()!=k)
		{
			int v = (int)(Math.random() * (range-1));
			if(!flipSet.contains(v))
			{
				flipSet.add(v);
			}
		}
		
		//System.out.print("Flipset: ");
		//Utils.printList(flipSet);
		
		for(int i=0;i<res.size();i++)
		{
			
			fail=0;
			ArrayList<Integer> a =res.get(i);
			
			graph=e.getCompleteGraph(n);
			for(int j=0;j<m;j++)
			{
				if(a.get(j)==0)
				{
					graph[aSet[j]][bSet[j]]=0;
					graph[bSet[j]][aSet[j]]=0;
					fail++;
				}
			}
			
			
			if(isConnected(graph,n) && !flipSet.contains(i) || 
					!isConnected(graph,n) && flipSet.contains(i))
			{
				//System.out.println("Connected");
				reliability+=Math.pow(p, m-fail)*Math.pow(1-p, fail);
				continue;
			}
			
		}
	
		return reliability;	
	}
	
	
	/* checks if a graph is connected */
	public static boolean isConnected(int graph[][],int n) {
        ArrayList<Integer>nodes = new ArrayList < Integer > ();
        
        
        DFS(0,graph,n,nodes);
        if (nodes.size() != n) {
            return false;
        }
        return true;

    }
	
	
	/* runs a recursive dfs traversal on a graph */
	public static void DFS(int v,int[][] graph, int n,ArrayList<Integer> nodes) {
        nodes.add(v);
        for (int i = 0; i < n; i++) {
            if (graph[v][i] != 0 && !nodes.contains(i)) {
                DFS(i,graph,n,nodes);
            }
        }
	}
}
