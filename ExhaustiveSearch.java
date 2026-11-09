public class ExhaustiveSearch {
 // Exhaustively find a pair with target sum.
 public static void main(String[] args){int[] a={4,7,1,9,3,6};int target=10;long checks=0;boolean found=false;long start=System.nanoTime();
 for(int i=0;i<a.length;i++)for(int j=i+1;j<a.length;j++){checks++;if(a[i]+a[j]==target){System.out.println("Pair: "+a[i]+" + "+a[j]+" = "+target);found=true;}}
 System.out.printf("found=%s comparisons=%d time=%.3f ms%n",found,checks,(System.nanoTime()-start)/1e6);}
}
