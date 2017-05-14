import java.util.*;
import java.io.*;
public class BuildingRoadstoConnectCities
{


    /************************ SOLUTION STARTS HERE ***********************/


    static class Edge implements Comparable<Edge>
    {
	int u , v , dist;
	Edge(int u,int v,int dist)
	{
	    this.u = u;
	    this.v = v;
	    this.dist = dist;
	}
	@Override
	public int compareTo(Edge o) {
	    return Integer.compare(dist, o.dist);
	}
    }
    static class DSU {
	private int parent[];
	private int size[];
	private int cnt;

	DSU(int length) {
	    this.cnt = length;
	    parent = new int[length + 10];
	    size = new int[length + 10];
	    Arrays.fill(size, 1);
	    for (int i = 0; i < parent.length; i++)
		parent[i] = i;
	}

	int root(int p) {
	    return (parent[p] == p) ? p : (parent[p] = root(parent[p]));
	}

	int sizeOf(int p) {
	    return size[root(p)];
	}

	boolean connected(int u, int v) {
	    return root(u) == root(v);
	}

	int components() {
	    return cnt;
	}

	void union(int u, int v) {
	    if (!connected(u, v)) {
		cnt--;
		int rootU = root(u);
		int rootV = root(v);
		if (size[rootU] < size[rootV]) {
		    parent[rootU] = rootV;
		    size[rootV] += size[rootU];
		} else {
		    parent[rootV] = rootU;
		    size[rootU] += size[rootV];
		}
	    }
	}
    }
    static int square(int a){ return a * a; }

    
    static double KruskalMST(Edge arr[], int V)
    {
	DSU dsu = new DSU(V + 10);
	Arrays.sort(arr);
	double total = 0.0;
	
	for(Edge e:arr)
	    if(!dsu.connected(e.u, e.v)){
		total += Math.sqrt(e.dist);
		dsu.union(e.u, e.v);
	    }
	
	return total;
    }
    
    private static void solve(FastScanner s1, PrintWriter out){

	int V = s1.nextInt();
	if(V == 1) { out.print("0.000000000"); return; }
	
	int X[] = new int[V];
	int Y[] = new int[V];
	for(int i=0;i<V;i++){
	    X[i] = s1.nextInt();
	    Y[i] = s1.nextInt();
	}
	
	Edge arr[] = new Edge[(V * (V-1)) / 2];
	int ptr = 0;
	for(int i=0;i<V;i++)
	    for(int j=i+1;j<V;j++)
		arr[ptr++] = new Edge(i, j, square(X[i] - X[j]) + square(Y[i] - Y[j]));

	out.printf("%.9f", KruskalMST(arr, V));

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