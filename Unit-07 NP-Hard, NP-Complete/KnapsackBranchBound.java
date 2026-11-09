import java.util.*;
public class KnapsackBranchBound {
 static class Item{int w,v;double ratio;Item(int w,int v){this.w=w;this.v=v;ratio=(double)v/w;}}
 static class Node{int level,weight,value;double bound;Node(int l,int w,int v){level=l;weight=w;value=v;}}
 static Item[] items;static int capacity;static long nodes;
 static double bound(Node n){if(n.weight>=capacity)return n.value;double b=n.value;int w=n.weight,i=n.level+1;while(i<items.length&&w+items[i].w<=capacity){w+=items[i].w;b+=items[i].v;i++;}if(i<items.length)b+=(capacity-w)*items[i].ratio;return b;}
 static int solve(Item[] input,int cap){items=input.clone();capacity=cap;Arrays.sort(items,(a,b)->Double.compare(b.ratio,a.ratio));nodes=0;PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->Double.compare(b.bound,a.bound));Node root=new Node(-1,0,0);root.bound=bound(root);pq.add(root);int best=0;
 while(!pq.isEmpty()){Node x=pq.poll();nodes++;if(x.bound<=best||x.level==items.length-1)continue;int k=x.level+1;
 Node take=new Node(k,x.weight+items[k].w,x.value+items[k].v);if(take.weight<=capacity){best=Math.max(best,take.value);take.bound=bound(take);if(take.bound>best)pq.add(take);}
 Node skip=new Node(k,x.weight,x.value);skip.bound=bound(skip);if(skip.bound>best)pq.add(skip);}
 return best;}
 public static void main(String[] args){Item[] a={new Item(2,40),new Item(3,50),new Item(5,100),new Item(4,60)};int cap=8;System.out.println("Best value="+solve(a,cap));System.out.println("Nodes explored="+nodes);}
}
