package sort;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//自顶向下归并排序
public class Merge {
    private static  Comparable[] aux;
    public static void merge(Comparable[] a,int lo,int mid,int hi){
        int i = lo; //左
        int j=mid+1; //右
        for (int k=lo;k<=hi;k++){
            aux[k] = a[k];
        }
        for (int k=lo;k<=hi;k++){
            if(i>mid) a[k] = aux[j++];
            else if(j>hi) a[k] =aux[i++];
            else if(less(aux[j],aux[i])) a[k]=aux[j++];
            else a[k]=aux[i++];
        }
    }
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    public static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    //公共方法
    //=======
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
