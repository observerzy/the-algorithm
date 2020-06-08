package sort;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//希尔排序
public class Shell {
    public static void sort(Comparable[] a){
        //将a[]按升序排列
        int N =a.length;
        int h = 1;
        while (h<N/3) h=3*h+1; //此处根据tiny.txt文件字符串长度算出h为13
        while (h>=1){
            StdOut.println(h); // 13，4，1
            for (int i=h;i<N;i++){
                for (int j = i;j>=h&&less(a[j],a[j-h]);j-=h){
                    exch(a,j,j-h);
                }
            }
            h = h/3;
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
