import java.util.Scanner;

/**
 * 求解炸弹人游戏炸弹安置位置最优解
 * 思路：
 *  1. 定义一个字符的二维数组 
 *  2. 输入内容 - '#'代表墙 、 '.'代表炸弹可安放位置、 'G'代表怪物
 *  3. 循环遍历二维数组的每一个点，判断是否是平地，如果是平地则算出如果这个
 *     点放置炸弹的话，可以清除多少个怪物，并将这个点的最大清除数、坐标数据记录
 *  4. 如果在第三步后还有点可以遍历，则重复第三部的判断和后续操作，如果这个
 *     点放置炸弹的最大清除数大于前面的点，则将上个点的数据覆盖
 */
public class Map{
    public static void main(String[] args) {
        // 1. 定义一个字符的二维数组 
        char[][] map = new char[20][20];
        int i,j,temp,max = 0,p,q,x = 0,y = 0,n;

        // 2. 输入内容
        Scanner in = new Scanner(System.in);
        for(n = 0; n < map.length; n++){
            map[n] = in.next().toCharArray();
        }
        in.close();

        // 3.循环遍历二维数组的每一个点
        for(i = 0; i < map.length; i++){
            for(j = 0; j < map[i].length; j++){
                // 初始化当前位置可清楚怪物总数
                temp = 0;
                // 3.1.判断是否是平地
                if (map[i][j] == '.') {
                    // 3.2 算出如果这个点放置炸弹的话，可以清除多少个怪物
                    
                    // 向上查找可消除的怪物数
                    p = i; q = j;
                    while(map[p][--q] != '#'){
                        if(map[p][q] == 'G')
                            temp++;
                    }

                    // 向下查找可消除的怪物数
                    p = i; q = j;
                    while(map[p][++q] != '#'){
                        if(map[p][q] == 'G')
                            temp++;
                    }

                    // 向左查找可消除的怪物数
                    p = i; q = j;
                    while(map[--p][q] != '#'){
                        if(map[p][q] == 'G')
                            temp++;
                    }

                    // 向右查找可消除的怪物数
                    p = i; q = j;
                    while(map[p++][q] != '#'){
                        if(map[p][q] == 'G')
                            temp++;
                    }
                }

                if(temp > max){
                    max = temp;
                    // 此处x,y不是数学中的x,y;x代表行，y代表列
                    x = i;
                    y = j;
                }
            }
        }

        // 4.输出结果
        System.out.printf("将炸弹位置放在(%d,%d),最多可以消灭%d个敌人",x,y,max);
    }

}