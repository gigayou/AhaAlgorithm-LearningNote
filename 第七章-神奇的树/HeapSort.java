import java.util.Scanner;

public class HeapSort{
    /** 存放堆的一维数组 */
    public static int[] heap = new int[101];
    /** 堆的元素数量 */
    public static int num;

    /**
     * 交换函数
     * 
     * @param x No.x node
     * @param y No.y node
     */
    public static void swap(int x, int y){
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }

    /**
     * 最小堆排序
     * 
     * @param node 
     */
    public static void siftDown(int node){
        int temp, flag=1;
        // 判断当前节点是否还有左子节点并判断是否可排序
        while (node*2 <= num && flag == 1) {
            // 判断左节点的值是否比父节点小
            if (heap[node] > heap[node*2]) {
                temp = node * 2;
            }else{
                temp = node;
            }

            // 判断当前父节点是否有右子树
            if (node*2+1 <= num) {
                // 判断右子树是否比父节点小
                if (heap[temp] > heap[node*2+1]) {
                    temp = node*2+1;
                }
            }

            // 判断临时节点标记是否还是父节点本身
            if (temp != node) {
                swap(temp, node);
                node = temp;
            }else{
                flag = 0;
            }
        }
    }

    /**
     * create heap
     */
    public static void creatHeap(){
         for (int i = num/2; i >= 1; i--) {
             siftDown(i);
         }
    }

    public static int deleteMax(){
        int temp = heap[1];
        heap[1] = heap[num];
        num--;
        siftDown(1);
        return temp;
    }

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("heap size:");
        n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            heap[i] = scanner.nextInt();
        }
        num = n;
        scanner.close();

        creatHeap();

        for (int i = 1; i <= n; i++) {
            System.out.printf("%d ", deleteMax());
        }
    }
}