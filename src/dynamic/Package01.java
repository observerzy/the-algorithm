package dynamic;

public class Package01 {
    public static void main(String[] args) {
        int[] weight = {6,1,5,2,1};
        int[] value = {48,7,40,12,8};
        int N = 5;
        int W = 8;
        Package01 pack = new Package01();
        pack.knapsack(weight,value,N,W);
    }
//    可装载N个物品和重量为W的背包
    public void knapsack( int[] weight, int[] value,int N,int W){
        int [][] dp = new int[N+1][W+1];
//        for(int j=0;j<9;j++) {  //初始化每一行
//            dp[0][j] = 0;
//        }
//        for(int i=1;i<6;i++) {  //背包的重量为0的时候，最大价值肯定是0
//            dp[i][0] = 0;
//        }
        for(int i=1;i<N+1;i++) {  //从第一个物品开始选，记录我选了前面出现的物品，背包重量从1-8的能选上的最大的值
            for(int j=1;j<W+1;j++) { //当i循环到最后一层5的时候，也就是得到了，我5件物品都选上的时候的最大的值
                if(weight[i-1]<=j) { //重量比这个状态小，那么就能放。 那么就只是放与不放，看是放重量大，还是不放重量大
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]]+value[i-1]);
                }else {
                    dp[i][j] = dp[i-1][j];//第i件物品不能放
                }
            }
        }
        for(int[] a:dp)
        {
            for(int b:a)
            {
                System.out.print(b+" ");
            }
            System.out.println();//换行
        }
    }
}
