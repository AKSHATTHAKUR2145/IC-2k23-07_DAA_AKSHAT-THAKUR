import java.util.*;
public class DPvsBranchBoundTSP {
 static int tspDP(int[][] c){int n=c.length,full=(1<<n)-1,INF=1_000_000_000;int[][] dp=new int[1<<n][n];for(int[] r:dp)Arrays.fill(r,INF);dp[1][0]=0;for(int m=1;m<(1<<n);m++)if((m&1)!=0)for(int u=0;u<n;u++)if((m&(1<<u))!=0&&dp[m][u]<INF)for(int v=0;v<n;v++)if((m&(1<<v))==0)dp[m|1<<v][v]=Math.min(dp[m|1<<v][v],dp[m][u]+c[u][v]);int ans=INF;for(int v=1;v<n;v++)ans=Math.min(ans,dp[full][v]+c[v][0]);return ans;}
 static int best;static long nodes;static boolean[] used;static int[][] cost;static int n;
 static void dfs(int u,int count,int val){nodes++;if(val>=best)return;if(count==n){best=Math.min(best,val+cost[u][0]);return;}for(int v=1;v<n;v++)if(!used[v]){used[v]=true;dfs(v,count+1,val+cost[u][v]);used[v]=false;}}
 public static void main(String[] args){cost=new int[][]{{0,10,15,20,12},{10,0,35,25,18},{15,35,0,30,11},{20,25,30,0,14},{12,18,11,14,0}};n=cost.length;long t=System.nanoTime();int d=tspDP(cost);long dpT=System.nanoTime()-t;best=Integer.MAX_VALUE;nodes=0;used=new boolean[n];used[0]=true;t=System.nanoTime();dfs(0,1,0);long bbT=System.nanoTime()-t;System.out.println("TSP DP cost="+d+" time(ms)="+dpT/1e6);System.out.println("TSP B&B (DFS with incumbent pruning) cost="+best+" nodes="+nodes+" time(ms)="+bbT/1e6);}
}
