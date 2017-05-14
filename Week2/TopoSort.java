import java.util.*;
import java.io.*;
public class TopoSort
{

    
    /************************ SOLUTION STARTS HERE ***********************/

    private static ArrayList<Integer>[] adj;
    private static ArrayDeque<Integer> order;
    private static boolean marked[];
    private static void topoSort(int u){
	
	marked[u] = true;
	for(int v:adj[u])
	    if(!marked[v])
		topoSort(v);
	
	order.push(u);
	
    }
    
    
    @SuppressWarnings("unchecked")
    private static void solve(FastScanner s1, PrintWriter out){

	int V = s1.nextInt();
	int E = s1.nextInt();
	adj = (ArrayList<Integer>[]) new ArrayList[V+1];
	marked = new boolean[V+1];
	order  = new ArrayDeque<>(V);
	for(int i=1;i<=V;i++)
	    adj[i] = new ArrayList<>();
	
	while(E-->0)
	    adj[s1.nextInt()].add(s1.nextInt());
	
	for(int i=1;i<=V;i++)
	    if(!marked[i])
		topoSort(i);
	
	for(int a:order)
	    out.print(a + " ");

    }


    
    /************************ SOLUTION ENDS HERE ************************/
    
    
    
    
    
    /************************ TEMPLATE STARTS HERE *********************/

    public static void main(String[] args) throws IOException {
	new Thread(null, new Runnable() {
	    public void run() {
		new TopoSort().run();
	    }
	}, "Increase Stack", 1L << 25).start();

    }

    void run(){	
	
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