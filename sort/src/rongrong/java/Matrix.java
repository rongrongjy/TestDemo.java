package rongrong.java;

/**
 * @description������һ���� N �� N �����ʾ��ͼ������ÿ�����صĴ�СΪ 4 �ֽڡ��������һ���㷨����ͼ����ת 90 �ȡ�
 * ��ռ�ö����ڴ�ռ��ܷ�������
 * ���� matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * ԭ����ת�������ʹ���Ϊ:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * @auther lurongrong
 * @create 2021-06-13 13:23
 */
public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // ˮƽ��ת
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
//                swap(matrix[i][j], matrix[n - i - 1][j]);
            }
        }
        // ���Խ��߷�ת
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
//                swap(matrix[i][j], matrix[j][i]);
            }
        }
    }
    public static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }
}
