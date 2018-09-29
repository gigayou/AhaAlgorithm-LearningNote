/**
 * 全排列 :
 */
public class Permutation{
    /**
     * 1，2，3三个数可以组成不同的三位数
     * @param args
     */
    public static void main(String[] args) {
        int max = 3, count = 0;
        for (int i = 1; i <= max; i++) {
            for(int j = 1; j <= max; j++){
                for(int k = 1; k <= max; k++){
                    if (i != j && i != k && j != k){
                        System.out.printf("%d%d%d\n",i,j,k);
                        count++;
                    }
                }
            }
        }

        System.out.println("一共可以组成" + count + "个全排列");
    }
    
}