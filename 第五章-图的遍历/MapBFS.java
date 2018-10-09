import java.util.Scanner;

public class MapBFS{

    public static void main(String[] args) {
        // 图的二维数组
        int[][] map = new int[50][50];
        // 定义队列
        int[] queue = new int[50];
        // 定义记录数组
        int[] book = new int[50];
        /**
         * maxX - 所需矩阵的最大行数
         * maxY - 所需矩阵的最大列数
         * x -  图的一个顶点
         * y -  图的下一个顶点
         * head - 队列的头部游标
         * tail - 队列的尾部游标
         * cur - 当前图的顶点
         */
        int maxX,maxY,x,y,cur,head = 1,tail = 1;

        // 输入所需图的大小
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入所需图的大小:");
        maxX = scanner.nextInt();
        maxY = scanner.nextInt();

        // 所需图的初始化
        for (int i = 1; i <= maxX; i++) {
            for (int j = 1; j <= maxY; j++) {
                if(i == j)
                    map[i][j] = 0;
                else
                    map[i][j] = -1;
            }
        }

        // 边的定义
        for (int i = 1; i <= maxX; i++) {
            System.out.println("请输入边:");
            x = scanner.nextInt();
            y = scanner.nextInt();
            // 无向图对称
            map[x][y] = 1;
            map[y][x] = 1;
        }

        // 从顶点1开始并将1放入队列
        queue[tail++] = 1;
        book[1] = 1;

        // 判断队列是否还未到达尾部
        while (head < tail) {
            // 队列的头部对应当前图的顶点
            cur = queue[head];
            for (int i = 1; i <= maxX; i++) {
                // 判断顶点cur与顶点i是否相连且顶点i是否没遍历过
                if (map[cur][i] == 1 && book[i] == 0) {
                    queue[tail++] = i;
                    book[i] = 1;
                }
                // 判断队列是否达到尾部
                if (tail > maxX) {
                    break;
                }
            }
            // 队列头部往底部走
            head++;
        }

        // 打印结果
        for (int i = 1; i < tail; i++) {
            System.out.print(queue[i] + " ");
        }
    }
}