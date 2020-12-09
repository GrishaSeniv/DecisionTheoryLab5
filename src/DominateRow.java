import com.seniv.simplex.SimplexMethod;

public class DominateRow extends FileReader{

    PrintMatrix printMatrix = new PrintMatrix();

    private int count;

    public DominateRow dominateSecondRowTest() {
        fileRead();
        ListMatrixToArray();
        int[][] arr = getMatrix();

        System.out.println("Current matrix ");
        printMatrix.print(getMatrix()); //Вивести на екран початкову матрицю

        for (int j = 1; j < arr.length; j++) {
            count = 0;

            if (j != 1) {
                for (int k = 0; k <= 4; k++) {
                    if (arr[1][k] >= arr[j][k]) {
                        count++;
                    }
                }
            }

            if (count == 5) {
                int[][] newMatrix = new int[4][5];
                System.out.println(2 + " row bigger then " + (j + 1) + " row. Delete " + (j + 1) + " row");
                for (int i = 0; i < j; i++) {
                    for (int kj = 0; kj < 5; kj++) {
                        newMatrix[i][kj] = arr[i][kj];
                    }
                }

                setMatrix(newMatrix);
                System.out.println("Matrix after remove ");
                printMatrix.print(getMatrix());
            }
        }
        return this;
    }



    public DominateRow dominateSecondColumn(){
        int[][] arr = getMatrix();
        int[][] newMatrix = new int[4][4];
        System.out.println("Delete 2 column");


        for (int i = 0; i < 4; i++) {
            for (int kj = 0; kj < 5; kj++) {
                if(kj == 0){
                    newMatrix[i][kj] = arr[i][kj];
                }
                if(kj > 1){
                    newMatrix[i][kj-1] = arr[i][kj];
                }

            }
        }
        setMatrix(newMatrix);
        System.out.println("Matrix after remove ");
        printMatrix.print(getMatrix());
        return this;
    }

    public DominateRow dominateFourthColumn(){
        int[][] arr = getMatrix();
        int[][] newMatrix = new int[4][3];
        System.out.println("Delete 3 column");


        for (int i = 0; i < 4; i++) {
            for (int kj = 0; kj < 4; kj++) {
                if(kj == 0 || kj == 1){
                    newMatrix[i][kj] = arr[i][kj];
                }
                if(kj > 2){
                    newMatrix[i][kj-1] = arr[i][kj];
                }

            }
        }
        setMatrix(newMatrix);
        System.out.println("Matrix after remove ");
        printMatrix.print(getMatrix());
        return this;
    }

    public DominateRow dominateFirstRow(){
        int[][] arr = getMatrix();
        int[][] newMatrix = new int[3][3];
        System.out.println("Delete 2 row");


        for (int i = 0; i < 4; i++) {
            for (int kj = 0; kj < 3; kj++) {
                if(i > 0){
                    newMatrix[i-1][kj] = arr[i][kj];
                }

            }
        }
        setMatrix(newMatrix);
        System.out.println("Matrix after remove ");
        printMatrix.print(getMatrix());

        System.out.println("FINAL MATRIX:");
        printMatrix.print(getMatrix());

        return this;
    }

    public DominateRow simplex(){
        boolean quit = false;

        float[][] standardized =  {
                { 4,   3,  5,  1,  0, 0,  1},
                { 5,   3,  2,  0,  1, 0,  1},
                { 3,   10,  11,  0,  0, 1,  1},
                {-1,  -1, -1,   0,  0, 0,  0}
        };

        // row and column do not include
        // right hand side values
        // and objective row
        SimplexMethod simplex = new SimplexMethod(3, 6);

        simplex.fillTable(standardized);

        // print it out
        System.out.println("---Starting set---");
        simplex.print();

        // if table is not optimal re-iterate
        while(!quit){
            SimplexMethod.ERROR err = simplex.compute();

            if(err == SimplexMethod.ERROR.IS_OPTIMAL){
                simplex.print();
                quit = true;
            }
            else if(err == SimplexMethod.ERROR.UNBOUNDED){
                System.out.println("---Solution is unbounded---");
                quit = true;
            }
        }
        return this;
    }

}
