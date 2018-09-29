import java.util.Scanner;

/**
 * 火柴棍游戏
 */
public class Match{

    public static int calcMatch(int num){
        int result = 0;
        // 数字与之对应拼起来所需火柴棍数量的映射数组
        int[] numMap = {6,2,5,5,4,5,6,3,7,6};

        while(num / 10 != 0){
            result += numMap[num % 10];
            num /= 10;
        }
        result += numMap[num];
        
        return result;
    }

    public static void main(String[] args) {
        int a,b,c,num,sum=0;
        Scanner scanner = new Scanner(System.in);
        // 火柴棍个数
        num = scanner.nextInt();
        scanner.close();
        
        for (a = 0; a <= 1111; a++) {
            for (b = 0; b <= 1111; b++) {
                c = a + b;

                if (calcMatch(a) + calcMatch(b) + calcMatch(c) == num - 4){
                    System.out.printf("%d+%d=%d\n",a,b,c);
                    sum++;
                }
            }
        }

        System.out.println("一共可以组成" + sum + "个不同的等式");
    }

}