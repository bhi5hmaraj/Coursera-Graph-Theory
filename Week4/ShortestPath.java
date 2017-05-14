import java.util.*;
import java.io.*;
public class ShortestPath
{

    
    /************************ SOLUTION STARTS HERE ***********************/

    
    
    static class Edge implements Comparable<Edge>
    {
	int v,cost;
	Edge(int... params)
	{
	    v = params[0];
	    cost = params[1];
	}
	@Override
	public int compareTo(Edge o) {
	    return Integer.compare(cost, o.cost);
	}
    }
    
    static int[] shortestDist(int start,int V)
    {
	int distTo[] = new int[V+1];
	Arrays.fill(distTo, -1);
	
	PriorityQueue<Edge> pq = new PriorityQueue<>();
	pq.add(new Edge(start,0));
	
	boolean marked[] = new boolean[V+1];
	
	while(!pq.isEmpty())
	{
	    Edge curr = pq.remove();
	    if(!marked[curr.v])
	    {
		marked[curr.v] = true;
		distTo[curr.v] = curr.cost;
		for(Edge adjacent:adj[curr.v])
		    if(!marked[adjacent.v])
			pq.add(new Edge(adjacent.v, distTo[curr.v] + adjacent.cost));
	    }
	}
	
	return distTo;
    }
    
    static ArrayList<Edge>[] adj;
    
    @SuppressWarnings("unchecked")
    private static void solve(FastScanner s1, PrintWriter out){

	int V = s1.nextInt();
	int E = s1.nextInt();
	adj = (ArrayList<Edge>[]) new ArrayList[V + 1];
	for(int i=1;i<=V;i++)
	    adj[i] = new ArrayList<>();
	
	while(E-->0)
	    adj[s1.nextInt()].add(new Edge(s1.nextInt(),s1.nextInt()));
	
	out.print(shortestDist(s1.nextInt(), V)[s1.nextInt()]);

    }


    
    /************************ SOLUTION ENDS HERE ************************/
    
    
    
    
    
    /************************ TEMPLATE STARTS HERE *********************/

    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	PrintWriter out = 
		new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), false); 
	solve(in, out);
	in.close();
	out.close();
    }    

    static class FastScanner{
	BufferedReader reader;
	StringTokenizer st;
	FastScanner(InputStream stream){reader=new BufferedReader(new InputStreamReader(stream));st=null;}	
	String next()
	    {while(st == null || !st.hasMoreTokens()){try{String line = reader.readLine();if(line == null){return null;}		    
	     st = new StringTokenizer(line);}catch (Exception e){throw new RuntimeException();}}return st.nextToken();}
	String nextLine()  {String s=null;try{s=reader.readLine();}catch(IOException e){e.printStackTrace();}return s;}	    	  	
	int    nextInt()   {return Integer.parseInt(next());}
	long   nextLong()  {return Long.parseLong(next());}		
	double nextDouble(){return Double.parseDouble(next());}
	char   nextChar()  {return next().charAt(0);}
	int[]  nextIntArray(int n)         {int[] arr= new int[n];   int i=0;while(i<n){arr[i++]=nextInt();}  return arr;}
	long[] nextLongArray(int n)        {long[]arr= new long[n];  int i=0;while(i<n){arr[i++]=nextLong();} return arr;}	
	int[]  nextIntArrayOneBased(int n) {int[] arr= new int[n+1]; int i=1;while(i<=n){arr[i++]=nextInt();} return arr;}	    	
	long[] nextLongArrayOneBased(int n){long[]arr= new long[n+1];int i=1;while(i<=n){arr[i++]=nextLong();}return arr;}	    	
	void   close(){try{reader.close();}catch(IOException e){e.printStackTrace();}}				
    }

    /************************ TEMPLATE ENDS HERE ************************/
}