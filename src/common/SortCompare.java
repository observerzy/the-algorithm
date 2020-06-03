package common;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Random;
public class SortCompare {
    public static double time(String alg, Double [] a)
    {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion"))    Insertion.sort(a);
        if (alg.equals("Selection"))   Selection.sort(a);
        if (alg.equals("Shell"))    Shell.sort(a);
        return  timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T)
    { // 使用算法 alg 将T个长度为N的数组排序
        double total = 0.0;
        Double [] a = new Double[N];
        for (int t = 0 ; t < T ; t++)
        { // 进行一次测试（生成一个数组并排序）
            for (int i = 0; i < N ; i++)
            {
                a[i] = new Random().nextDouble();
            }
            total += time(alg, a);
        }
        return total;
    }
    public static void main(String[] args) {
        int N = 1000;   // 被排序的数组长度
        int T = 100;    // 排序次数
        double t1 = timeRandomInput("Insertion", N, T);
        double t2 = timeRandomInput("Selection", N, T);
        double t3 = timeRandomInput("Shell", N, T);
        System.out.println("Insertion:" + t1);
        System.out.println("Selection" + t2);
        System.out.println("Shell" + t3);
    }
}