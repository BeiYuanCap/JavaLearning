/*     螺旋矩阵

给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]

*/

/* 
 * 模拟题，重点在于要一直坚持同一个边界原则（左闭右开）
 * 
 */

 public class SpiralMatrix {
    public static void main(String[] args) {
        int s1 = 3;
        int [][] result = generateMatrix(s1);
        for(int i=0;i<s1;i++){
            for(int j=0;j<s1;j++){
                System.out.print(result[i][j]+",");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n){
        int [][] result = new int[n][n];
        int startX = 0,startY=0;
        int loop = 1;
        int count = 1;
        while(loop <= n / 2){

            for(int i=startX, j=startY;j<n-startY-1;j++){
                result[i][j] = count++;
            }

            for(int i=startX, j=n-startY-1;i<n-startX-1;i++){
                result[i][j] = count++;
            }

            for(int i=n-startX-1, j=n-startY-1;j>startY;j--){
                result[i][j] = count++;
            }

            for(int i=n-startX-1, j=startY;i>startX;i--){
                result[i][j] = count++;
            }
            
            startX++;
            startY++;
            loop++;
        }

        if(n%2==1){
            result[startX][startY] = count;
        }
        
        return result;
    }
}
