
public class Matrix {
    public int row;
    public int col;
    public int[][] matr;

    public Matrix(int[][] matr) {
        this.row = matr.length;
        this.col = matr[0].length;
        this.matr = matr;
    }

    public Matrix sum(Matrix matrix1) {
        if (this.row == matrix1.row && this.col == matrix1.col) {
            int[][] a = new int[row][col];
            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++) {
                    a[i][j] = this.matr[i][j] + matrix1.matr[i][j];
                }
            return new Matrix(a);
        } else {
            System.out.println("row1 != row2");
            int[][] pop = new int[1][1];
            return new Matrix(pop);
        }
    }

    public Matrix matrixMult(Matrix matrix1) {
        int[][] res = new int[row][col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < matrix1.col; j++) {
                for (int k = 0; k < col; k++) {
                    res[i][j] += this.matr[i][k] * matrix1.matr[k][j];
                }
            }
        }
        return new Matrix(res);
    }

    public Matrix digitMult(int x) {
        int[][] m = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m[i][j] = this.matr[i][j] * x;
            }
        }
        return new Matrix(m);

    }

    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matr[i][j] + ", ");
            }
            System.out.println("  ");
        }
        System.out.println("\n");
    }
}

class Lonch {
    public static void main(String[] args) {
        Matrix matr1 = new Matrix(
                new int[][]{
                        {1, 2, 3},
                        {5, 6, 7}
                }
        );

        Matrix matr2 = new Matrix(
                new int[][]{
                        {1, 2},
                        {3, 4},
                        {4, 4}
                }
        );
        matr1.sum(matr2).print();
        matr1.digitMult(5).print();
        matr1.print();
        matr1.matrixMult(matr2).print();
    }
}