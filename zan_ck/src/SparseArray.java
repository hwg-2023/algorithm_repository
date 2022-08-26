
public class SparseArray {
    public static void main(String[] args) {
        //稀疏数组的实现
        //原始数组就设置一个11×11的二维数组，与视频中保持一致，有效值val设置个数为6个
        int oriArr [] [] = new int [11] [11];
        //填入有效值
        oriArr[0][3] = 11;
        oriArr[5][8] = 8;
        oriArr[2][8] = 10;
        oriArr[10][9] = 89;
        oriArr[10][10] = 30;
        oriArr[8][2] = 100;
        //先遍历一遍原始二维数组，看看效果

       for (int i = 0; i< oriArr.length; i++){
            System.out.println();
            for (int j = 0; j< oriArr[i].length; j++){

                System.out.print("\t"+oriArr[i][j]);
            }
        }
        System.out.println();
        System.out.println("-----------------------------------------");

        //获取有效个数
        int sum = 0;
        int i ;
        int j = 0;
        for ( i = 0; i< oriArr.length; i++){
            for ( j = 0 ; j<oriArr[i].length;j++){
                if (oriArr[i][j] != 0){
                    sum++;
                }
            }
        }
        //System.out.println(sum);   成功获取sum个数
        //创建稀疏数组
        int sparseArr [] [] = new int [sum+1][3];
        //将元素填入，第一行为总行数，列数，有效值个数，后面为索引，有效值
        sparseArr[0][0] = i;
        sparseArr[0][1] = j;
        sparseArr[0][2] = sum;
//        for (int a = 0; a< sparseArr.length; a++){
//            System.out.println();
//            for (int b = 0; b<sparseArr[a].length;b++){
//                System.out.print("   "+sparseArr[a][b]);
//            }
//        }
        //没有问题,然后是接下来几行代码
        int row = 1;
        for ( i = 0; i< oriArr.length; i++){
            for ( j = 0 ; j<oriArr[i].length;j++){
                if (oriArr[i][j] != 0){
                    sparseArr[row][0] = i;
                    sparseArr[row][1] = j;
                    sparseArr[row][2] = oriArr[i][j];
                    row++;
                }
            }
        }
//        for (int a = 0; a< sparseArr.length; a++){
//            System.out.println();
//            for (int b = 0; b<sparseArr[a].length;b++){
//                System.out.print("\t"+sparseArr[a][b]);
//            }
//        }
        //将稀疏数组复原成原数组
        int[][] finalArr = new int [sparseArr[0][0]][sparseArr[0][1]];
        for (int a = 1; a<sparseArr.length; a++){
            int hang = sparseArr[a][0];
            int lie = sparseArr[a][1];
            int val = sparseArr[a][2];
            finalArr[hang][lie] = val;
        }
        for (int c = 0; c<finalArr.length;c++){
            System.out.println();
            for (int d = 0;d<finalArr[c].length;d++){
                System.out.print("\t"+finalArr[c][d]);
            }
        }
    }
}
