import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TransferBFS{
    public static void main(String[] args) {
        // 航班转机图
        int[][] map = new int[51][51];
        // 队列
        Note[] queue = new Note[2051];
        for (int i = 0; i < 2051; i++) {
            queue[i] = new Note(); 
        }
        // 记录数组
        int[] book = new int[51];
        int n,m,a,b,cur,flag=0,start,end,head=1,tail=1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入顶点数和边数");
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println("请输入起点城市和终点城市");
        start = scanner.nextInt();
        end = scanner.nextInt();
        // 初始化二维数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    map[i][j] = 0;
                }else{
                    map[i][j] = 99999999;
                }
            }
        }

        // 写入可以互相抵达的航班
        for (int i = 1; i <= m; i++) {
            System.out.println("请输入可以互相到达的城市a和b");
            a = scanner.nextInt();
            b = scanner.nextInt();
            map[a][b] = 1;
            map[b][a] = 1;
        }
        scanner.close();
        // 从城市start开始
        queue[tail].setCity(start);
        queue[tail].setCount(0);
        tail++;
        book[start] = 1;

        // 判断队列是否到达尾部
        while (head < tail) {
            cur = queue[head].getCity();
            for (int i = 1; i <= n; i++) {
                // 判断当前城市到i城市是否有航班且没飞过
                if (map[cur][i] != 99999999 && book[i] == 0) {
                    queue[tail].setCity(i);
                    queue[tail].setCount(queue[head].getCount() + 1);
                    tail++;
                    book[i] = 1;
                }
                // 判断是否抵达目标城市
                if (cur == end) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 1)
                break;
            head++;
        }

        System.out.printf("从城市%d到城市%d最少需要转机%d次",start,end,queue[tail-1].getCount());
    }
}