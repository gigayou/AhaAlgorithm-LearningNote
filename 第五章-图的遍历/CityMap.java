import java.util.Scanner;

public class CityMap{
    /** 城市二维图 */
    public static int[][] map = new int[51][51];
    /** 图的边距 | 终点城市的编号 */
    public static int n;
    /** 记录已走顶点数组 */
    public static int[] book = new int[51];
    /** 暂定的最短路径距离 */
    public static int min = 99999999;

    /**
     * 递归算出最短路径
     * 
     * @param cur 当前所在的顶点(城市)
     * @param dis 已走过的路径距离
     */
    public static void dfs(int cur, int dis){
        // 判断length是否大于min,如果是，则不再执行
        if (dis > min) {
            return ;
        }
        // 判断是否到达终点
        if (cur == n) {
            // 判断当前的走法是否比上词的走法所花距离更短，如果是，则更新最短路径距离
            if (dis < min) {
                min = dis;
            }
            return ;
        }
        // 开始遍历
        for (int i = 1; i <= n; i++) {
            // 判断cur城市到i城市是否有路可走并且没走过
            if (map[cur][i] != 99999999 && book[i] ==0) {
                // 记录i城市
                book[i] = 1;
                // 开始i城市到终点的路径规划
                dfs(i, dis + map[cur][i]);
                // 当上部递归完成，需要去除book[i]标记，这样才能回溯
                book[i] = 0;
            }
        }
        return ;
    }

    public static void main(String[] args) {
        int source, arrive, dis, road;
        System.out.println("请输入n road:");
        Scanner scannner = new Scanner(System.in);
        n = scannner.nextInt();
        road = scannner.nextInt();
        // 初始化图
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    map[i][j] = 0;
                }else{
                    map[i][j] = 99999999;
                }
            }
        }
        // 输入城市的图
        for (int i = 1; i <= road; i++) {
            System.out.println("请输入source arrive dis");
            source = scannner.nextInt();
            arrive = scannner.nextInt();
            dis = scannner.nextInt();
            map[source][arrive] = dis;
        }
        scannner.close();

        // 从城市1开始
        book[1] = 1;
        dfs(1, 0);
        
        System.out.println("最短路径为:" + min);
    }
}