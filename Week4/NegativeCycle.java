import java.util.*;
import java.io.*;
public class NegativeCycle
{
    
    /************************ SOLUTION STARTS HERE ***********************/

    static class Edge implements Comparable<Edge>
    {
	int v,cost;
	Edge(int v,int cost){
	    this.v = v;
	    this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
	    return Integer.compare(cost, o.cost);
	}
    }
    
    static boolean tempMark[];
    static boolean globalMark[];
    static int distTo[];
    static ArrayList<Edge>[] adj;
    
    static boolean dfs(int u, int dist)
    {
	tempMark[u]   = true;
	globalMark[u] = true;
	distTo[u] = dist;
	for(Edge adjacent : adj[u])
	{
	    if(tempMark[adjacent.v] && (distTo[u] + adjacent.cost < distTo[adjacent.v]))
		return true;
	    
	    if(!globalMark[adjacent.v])
		if(dfs(adjacent.v, dist + adjacent.cost))
		    return true;
	}
	tempMark[u] = false;
	return false;
    }
    
    static boolean findCycle(int V)
    {
	tempMark   = new boolean[V + 1];
	globalMark = new boolean[V + 1];
	
	for(int i=1;i<=V;i++)
	    if(!globalMark[i] && dfs(i, 0))
		return true;
	
	return false;
    }
    
    @SuppressWarnings("unchecked")
    private static void solve(FastScanner s1, PrintWriter out){

	int V = s1.nextInt();
	int E = s1.nextInt();
	distTo = new int[V+1];
	adj = (ArrayList<Edge>[]) new ArrayList[V+1];
	for(int i=1;i<=V;i++)
	    adj[i] = new ArrayList<>();
	
	while(E-->0)
	    adj[s1.nextInt()].add(new Edge(s1.nextInt(), s1.nextInt()));
	
	out.print(findCycle(V) ? "1" : "0");

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