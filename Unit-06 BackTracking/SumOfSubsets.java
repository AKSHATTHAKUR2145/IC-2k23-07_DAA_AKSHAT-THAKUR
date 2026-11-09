import java.util.Arrays;
public class SumOfSubsets {
 static int[] a; static int target,count;
 static void backtrack(int i,int sum,String selected){if(sum==target){count++;System.out.println("Subset: "+selected);return;}if(i==a.length||sum>target)return;
 backtrack(i+1,sum+a[i],selected.isEmpty()?""+a[i]:selected+", "+a[i]);backtrack(i+1,sum,selected);}
 public static void main(String[] args){a=new int[]{5,10,12,13,15,18};target=30;Arrays.sort(a);backtrack(0,0,"");System.out.println("Solutions="+count);}
}
