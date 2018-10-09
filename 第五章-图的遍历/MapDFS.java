import java.util.Scanner;

public class MapDFS{
    /** 图的定义 */
    public static int[][] map = new int[50][50];
    /** 记录数组 */
    public static int[] book = new int[50];
    /** 总数汇总 */
    public static int sum;
    /** 所有顶点数 */
    public static int n;

    /**
     * 深度优先遍历函数
     * 
     * @param cur 当前所在的顶点
     */
    public static void dfs(int cur){
        int i;
        // 打印当前顶点
        System.out.print(cur + " ");
        sum++;
        // 判断所有顶点是否全部遍历完成
        if (sum == n) {
            return ;
        }
        // 遍历1-n号顶点
        for (i = 1; i <= n; i++) {
            if (map[cur][i] == 1 && book[i] == 0) {
                book[i] = 1;
                dfs(i);
            }
        }

        return ;
    }

    public static void main(String[] args) {

        int x,y;

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入n");
        n = scanner.nextInt();

        // 初始化矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    map[i][j] = 0;
                else
                    map[i][j] = -1;
            }
        }

        // 设置顶点之间的边
        for (int i = 1; i <= n; i++) {
            System.out.println("请输入边");
            x = scanner.nextInt();
            y = scanner.nextInt();
            map[x][y] = 1;
            map[y][x] = 1;
        }
        scanner.close();

        // 从1号顶点出发
        book[1] = 1;
        dfs(1);
    }


}