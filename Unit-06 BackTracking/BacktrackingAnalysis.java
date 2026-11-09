public class BacktrackingAnalysis {
 static long nodes,solutions;
 static boolean safe(int[] b,int r,int c){for(int i=0;i<r;i++)if(b[i]==c||Math.abs(b[i]-c)==r-i)return false;return true;}
 static void bt(int[] b,int r){nodes++;if(r==b.length){solutions++;return;}for(int c=0;c<b.length;c++)if(safe(b,r,c)){b[r]=c;bt(b,r+1);}}
 static void brute(int[] b,int r){nodes++;if(r==b.length){for(int i=0;i<b.length;i++)for(int j=i+1;j<b.length;j++)if(b[i]==b[j]||Math.abs(b[i]-b[j])==j-i)return;solutions++;return;}for(int c=0;c<b.length;c++){b[r]=c;brute(b,r+1);}}
 public static void main(String[] args){System.out.println("N | algorithm | solutions | nodes | ms");for(int n=4;n<=8;n++){nodes=solutions=0;long t=System.nanoTime();bt(new int[n],0);System.out.printf("%d | backtracking | %d | %d | %.3f%n",n,solutions,nodes,(System.nanoTime()-t)/1e6);if(n<=7){nodes=solutions=0;t=System.nanoTime();brute(new int[n],0);System.out.printf("%d | exhaustive | %d | %d | %.3f%n",n,solutions,nodes,(System.nanoTime()-t)/1e6);}}}
}
