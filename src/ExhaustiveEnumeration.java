

import java.util.ArrayList;
import java.util.Collections;

public class ExhaustiveEnumeration {
	
	public int numStates=0;
	private ArrayList<ArrayList<Integer>> states;
	
	/* Generates all possible states for a graph. Parameters
	 * m: number of links
	 * */
	public ArrayList<ArrayList<Integer>> generateStates(int m)
	{
		ArrayList<Integer> arr=new ArrayList<Integer>(Collections.nCopies(10, 1));
		this.states=new ArrayList<ArrayList<Integer>>();
		states.add(arr);
		for(int i=1;i<=m;i++)
		{
			//System.out.println("Generating states with "+i+" link failures...");
			getStatesWithKFails(i,arr);
			//System.out.println();
			}
		
		//System.out.println("Total States Generated: "+states.size());
		return this.states;
	}
	
	/* Generates states with k link failures */
	public void getStatesWithKFails(int k,ArrayList<Integer> arr)
	{
		for(int i=0;i<arr.size();i++)
		{
			getStates(arr,k,0,i);
		}
	}
	
	
	
	/* recursive function to generate states */
	public void getStates(ArrayList<Integer> arr, int maxFail,int curFail, int i)
	{
		arr.set(i,0);
		if(curFail+1==maxFail)
		{
			numStates++;
			ArrayList<Integer> a =new ArrayList<Integer>(arr);
			this.states.add(a);
			//Utils.printList(arr);
			arr.set(i, 1);
			return;
		}
		
		for(int j=i+1;j<arr.size();j++)
		{
			getStates(arr,maxFail,curFail+1,j);
			arr.set(j, 1);
		}
		arr.set(i, 1);
	}
	
	
	/* generates a complete graph with n nodes */
	public int[][] getCompleteGraph(int n)
	{
		int arr[][] = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i!=j)
				{
					arr[i][j]=1;
				}
			}
		}
		//Utils.printMatrix(arr, n, "input graph");
		return arr;
		
	}
}
