import java.util.Arrays;
public class GraphColoring {
 static boolean safe(int v,int color,int[][] g,int[] colors){for(int i=0;i<g.length;i++)if(g[v][i]==1&&colors[i]==color)return false;return true;}
 static boolean color(int v,int[][] g,int[] colors,int m){if(v==g.length)return true;for(int c=1;c<=m;c++)if(safe(v,c,g,colors)){colors[v]=c;if(color(v+1,g,colors,m))return true;colors[v]=0;}return false;}
 public static void main(String[] args){int[][] g={{0,1,1,1},{1,0,1,0},{1,1,0,1},{1,0,1,0}};int[] colors=new int[g.length];if(color(0,g,colors,3))System.out.println(Arrays.toString(colors));else System.out.println("No coloring possible.");}
}
