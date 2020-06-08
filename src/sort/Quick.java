package sort;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

//希尔排序
public class Quick {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a); //消除对输入的依赖
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int j = partition(a,lo,hi); //切分
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    //切分
    private static int partition(Comparable[] a,int lo,int hi){
        int i =lo,j=hi+1;
        Comparable v = a[lo];
        while (true){
            while (less(a[++i],v)) if (i==hi) break;
            while (less(v,a[--j])) if(j==lo) break;
            if(i>=j) break;
            exch(a,i,j);//左大与右小交换
        }
        exch(a,lo,j);//基准值位置放置
        return j;
    }
    private static boolean less(Comparable v,Comparable w){
        //比较大小
        return v.compareTo(w)<0;
    }
    public static void exch(Comparable[] a,int i, int j){
        //交换位置
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    private static void show(Comparable[] a){
        //打印数组
        for (int i=0;i<a.length;i++)
            StdOut.print(a[i]+" ");
    }
    public static boolean isSorted(Comparable[] a){
        //测试元素数组是否有序
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }
    public static void main(String[] args){
        String[] a= StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
