package 基础学习;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SparseArr {
    public static void main(String[] args) throws Exception {
        String filePath = "E:\\map.data";
        //创建一个原始的二维数组 11*11
        //0：表示没有棋子，1表示黑子，2表示蓝子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[3][4] = 3;//test
        //输出原始二维数组
        System.out.println("原始二维数组:");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //调用函数将原始二维数组转为稀疏数组
        int[][] sparseArr = C2S(chessArr);
        //将稀疏数组存储进磁盘E:\map.data
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(sparseArr);
        //读取磁盘数据
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        int[][] sparseArr1 = (int[][]) ois.readObject();
        int[][] chessArred = S2C(sparseArr);
    }

    public static int[][] C2S(int[][] chessArr){
        //转成稀疏数组
        int cnt = 0;
        for (int[] row1 : chessArr) {
            for (int data1 : row1) {
                if (data1 != 0){
                    cnt ++;
                }
            }
        }
        int[][] sparseArr = new int[cnt + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = cnt;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0){
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        System.out.println("转换后的稀疏数组:");
        //输出转换后的稀疏数组
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        return sparseArr;
    }

    public static int[][] S2C(int[][] sparseArr){
        //稀疏数组转原始二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr[0][2] + 1; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //输出转换后的二维数组
        System.out.println("转换后的二维数组:");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        return chessArr2;
    }
}
