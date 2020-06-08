给出n个数字 a_1,...,a_n，问最多有多少不重叠的非空区间，使得每个区间内数字的xor都等于0。
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int begin=0;
            int res=0;
            for(int i=0;i<n;i++){
                int j=i;
                int tmp=0;
                while(j>=begin){
                    tmp^=arr[j];
                    if(tmp==0){
                        res++;
                        begin=i+1;
                        break;
                    }
                    j--;
                }
            }
            
            System.out.println(res);
        }
    }
}

给定两个数R和n，输出R的n次方，其中0.0<R<99.999, 0<n<=25
import java.util.Scanner;
import java.math.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.next();
            BigDecimal a=new BigDecimal(s);
            int n=sc.nextInt();
            BigDecimal b=new BigDecimal(s);
            for(int i=1;i<n;i++){
                b=b.multiply(a);
            }
            System.out.println(b.stripTrailingZeros().toPlainString());
        }
    }
}


给定一个m行n列的二维地图, 初始化每个单元都是水.
操作addLand 把单元格(row,col)变成陆地.
岛屿定义为一系列相连的被水单元包围的陆地单元, 横向或纵向相邻的陆地称为相连(斜对角不算).
在一系列addLand的操作过程中, 给出每次addLand操作后岛屿的个数.
二维地图的每条边界外侧假定都是水.
import java.util.Scanner;
public class Main{
    //private static int count;
    private static void dfs(int[][] arr,int i,int j,int m,int n){
        if(i<0||j<0||i>=m||j>=n||arr[i][j]==0) return;
        arr[i][j]=0;
        dfs(arr,i+1,j,m,n);
        dfs(arr,i,j+1,m,n);
        dfs(arr,i-1,j,m,n);
        dfs(arr,i,j-1,m,n);
        
    }
    private static int find(int[][] arr,int m,int n){
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    dfs(arr,i,j,m,n);
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int m=sc.nextInt();
            int n=sc.nextInt();
            int[][] arr=new int[m][n];
            int k=sc.nextInt();
            int res=0;
            for(int i=0;i<k;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                if(x<0||y<0||x>=m||y>=n){
                    System.out.print(res+" ");
                    continue;
                } 
                arr[x][y]=1;
                int[][] grid=new int[m][n];
                for(int j=0;j<m;j++){
                    grid[j]=arr[j].clone();
                }
                res=find(grid,m,n);
                System.out.print(res+" ");
            }
        }
    }
}


