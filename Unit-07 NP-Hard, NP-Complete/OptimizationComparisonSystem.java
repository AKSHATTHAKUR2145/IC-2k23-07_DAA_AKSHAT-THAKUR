import java.util.*;
public class OptimizationComparisonSystem {
 static long factorial(int n){long x=1;for(int i=2;i<=n;i++)x*=i;return x;}
 static void exhaustiveSubset(int[] a,int i,int sum,int target,long[] count){count[0]++;if(i==a.length){if(sum==target)count[1]++;return;}exhaustiveSubset(a,i+1,sum+a[i],target,count);exhaustiveSubset(a,i+1,sum,target,count);}
 public static void main(String[] args){int[] a={2,4,6,8,10,12,14,16};long[] stats={0,0};long start=System.nanoTime();exhaustiveSubset(a,0,0,18,stats);long elapsed=System.nanoTime()-start;System.out.println("Optimization Algorithm Comparison System");System.out.println("Subset-sum exhaustive states="+stats[0]+" solutions="+stats[1]+" time(ms)="+elapsed/1e6);System.out.println("TSP exhaustive tours (n=8)=(n-1)! = "+factorial(7));System.out.println("Complexity note: exhaustive search grows exponentially/factorially; DP and B&B reduce work in suitable cases.");}
}
