import java.util.*;
import java.io.*;
public class BipartiteCheck
{


	/************************ SOLUTION STARTS HERE ***********************/

	private static ArrayList<Integer>[] adj;

	private static boolean isBipartite(int V)
	{

		boolean marked[] = new boolean[V+1];
		boolean color[]  = new boolean[V+1];
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		marked[1] = true;
		queue.add(1);

		while(!queue.isEmpty())
		{
			int u = queue.remove();
			for(int v:adj[u])
			{
				if(marked[v]){
					if(color[u] == color[v])
						return false;
				}
				else{
					marked[v] = true;
					color[v] = !color[u];
					queue.add(v);
				}

			}
		}
		return true;

	}


	@SuppressWarnings("unchecked")
	private static void solve(FastScanner s1, PrintWriter out){

		int V = s1.nextInt();
		int E = s1.nextInt();

		adj = (ArrayList<Integer>[]) new ArrayList[V+1];
		for(int i=1;i<=V;i++)
			adj[i] = new ArrayList<>();

		while(E-->0){
			int u = s1.nextInt();
			int v = s1.nextInt();
			adj[u].add(v);
			adj[v].add(u);
		}

		out.print(isBipartite(V) ? "1" : "0");
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