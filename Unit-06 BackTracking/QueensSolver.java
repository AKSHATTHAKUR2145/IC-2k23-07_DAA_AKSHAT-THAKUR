public class QueensSolver {
 static int solutions; static long nodes;
 static boolean safe(int[] b,int r,int c){for(int i=0;i<r;i++)if(b[i]==c||Math.abs(b[i]-c)==r-i)return false;return true;}
 static void solve(int[] b,int r,boolean print){nodes++;if(r==b.length){solutions++;if(print){System.out.println("Solution "+solutions);for(int x:b){for(int c=0;c<b.length;c++)System.out.print(x==c?"Q ":". ");System.out.println();}System.out.println();}return;}
 for(int c=0;c<b.length;c++)if(safe(b,r,c)){b[r]=c;solve(b,r+1,print);b[r]=-1;}}
 static void run(int n,boolean print){solutions=0;nodes=0;int[] b=new int[n];java.util.Arrays.fill(b,-1);long t=System.nanoTime();solve(b,0,print);System.out.printf("N=%d solutions=%d nodes=%d time=%.3f ms%n",n,solutions,nodes,(System.nanoTime()-t)/1e6);}
 public static void main(String[] args){System.out.println("4-Queens");run(4,true);System.out.println("8-Queens");run(8,false);System.out.println("N-Queens N=10");run(10,false);}
}
