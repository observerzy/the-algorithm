import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//插入排序
public class Insertion {
    public static void sort(Comparable[] a){
        //将a[]按升序排列
        int N =a.length;
        for(int i=1;i<N;i++){
            //将a[i]插入到a[i-1],a[i-2],a[i-3]...之中
            for (int j = i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
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
