import java.util.*;
public class TSPBranchBound {
 static int n;static int[][] cost;static boolean[] used;static int best=Integer.MAX_VALUE;static long nodes;static int[] path,bestPath;
 static void dfs(int current,int count,int total){nodes++;if(total>=best)return;if(count==n){if(cost[current][0]>0&&total+cost[current][0]<best){best=total+cost[current][0];bestPath=path.clone();}return;}
 for(int next=1;next<n;next++)if(!used[next]&&cost[current][next]>0){used[next]=true;path[count]=next;dfs(next,count+1,total+cost[current][next]);used[next]=false;}}
 public static void main(String[] args){cost=new int[][]{{0,10,15,20},{10,0,35,25},{15,35,0,30},{20,25,30,0}};n=cost.length;used=new boolean[n];path=new int[n];used[0]=true;path[0]=0;long t=System.nanoTime();dfs(0,1,0);System.out.println("Minimum tour cost="+best);System.out.print("Tour: ");if(bestPath!=null){for(int v:bestPath)System.out.print(v+" -> ");System.out.println("0");}System.out.println("Nodes explored="+nodes);System.out.printf("Time=%.3f ms%n",(System.nanoTime()-t)/1e6);}
}
