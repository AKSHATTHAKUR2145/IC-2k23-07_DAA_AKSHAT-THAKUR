import java.util.*;
public class KnapsackComparison {
 static class Item{int w,v;double ratio;Item(int w,int v){this.w=w;this.v=v;ratio=(double)v/w;}}
 static int dp(Item[] a,int cap){int[] d=new int[cap+1];for(Item x:a)for(int w=cap;w>=x.w;w--)d[w]=Math.max(d[w],d[w-x.w]+x.v);return d[cap];}
 static class N{int i,w,v;double b;N(int i,int w,int v){this.i=i;this.w=w;this.v=v;}}
 static long nodes;static Item[] sorted;static int cap;
 static double bound(N x){double b=x.v;int w=x.w,i=x.i;while(i<sorted.length&&w+sorted[i].w<=cap){w+=sorted[i].w;b+=sorted[i].v;i++;}if(i<sorted.length)b+=(cap-w)*sorted[i].ratio;return b;}
 static int bb(Item[] input,int capacity){sorted=input.clone();Arrays.sort(sorted,(x,y)->Double.compare(y.ratio,x.ratio));cap=capacity;nodes=0;PriorityQueue<N> q=new PriorityQueue<>((x,y)->Double.compare(y.b,x.b));N root=new N(0,0,0);root.b=bound(root);q.add(root);int best=0;while(!q.isEmpty()){N x=q.poll();nodes++;if(x.b<=best||x.i==sorted.length)continue;Item it=sorted[x.i];N take=new N(x.i+1,x.w+it.w,x.v+it.v);if(take.w<=cap){best=Math.max(best,take.v);take.b=bound(take);if(take.b>best)q.add(take);}N skip=new N(x.i+1,x.w,x.v);skip.b=bound(skip);if(skip.b>best)q.add(skip);}return best;}
 public static void main(String[] args){Item[] a={new Item(2,40),new Item(3,50),new Item(5,100),new Item(4,60),new Item(1,20)};int cap=8;long t=System.nanoTime();int ansDP=dp(a,cap);long dpTime=System.nanoTime()-t;t=System.nanoTime();int ansBB=bb(a,cap);long bbTime=System.nanoTime()-t;System.out.println("DP value="+ansDP+" time(ms)="+dpTime/1e6);System.out.println("B&B value="+ansBB+" nodes="+nodes+" time(ms)="+bbTime/1e6);}
}
