import java.util.Arrays;

public class MinMax extends FileReader{
    private int[] arrWithMinAndMaxElements = new int[2];

    public void minMax(){
        fileRead();
        ListMatrixToArray();
        int[][] arr = getMatrix();
        int[] arrayWithMinElRow = new int[5];

        for (int i = 0; i < arr.length; i++){
            int[] testArr = new int[5];
            for (int j = 0; j < arr[i].length; j++){
                testArr[j] = arr[i][j];
                System.out.print(arr[i][j] + " ");
            }
            Arrays.sort(testArr);
            arrayWithMinElRow[i] = testArr[0];
            System.out.println(" Min element in this row = " + testArr[0]);
        }

        Arrays.sort(arrayWithMinElRow);
        System.out.println("Max element of min rows element(MaxMin) = " + arrayWithMinElRow[4]);

        arrWithMinAndMaxElements[0] = arrayWithMinElRow[4];
    }

    public void maxMin(){
        fileRead();
        ListMatrixToArray();
        int[][] arr = getMatrix();
        int[] arrayWithMaxElRow = new int[5];

        for (int i = 0; i < arr.length; i++){
            int[] testArr = new int[5];
            for (int j = 0; j < arr[i].length; j++){
                testArr[j] = arr[j][i];
                System.out.print(arr[i][j] + " ");
            }
            Arrays.sort(testArr);
            arrayWithMaxElRow[i] = testArr[4];
            System.out.println(" Max element in " + (i+1) +" column = " + testArr[4]);
        }

        Arrays.sort(arrayWithMaxElRow);
        System.out.println("Min element of max rows element(MinMax) = " + arrayWithMaxElRow[0]);

        arrWithMinAndMaxElements[1] = arrayWithMaxElRow[0];
    }

    public void checkForSaddlePoint(){
        if(arrWithMinAndMaxElements[0] == arrWithMinAndMaxElements[1]){
            System.out.println("Is a saddle point, because " + arrWithMinAndMaxElements[0] + " el = " +
                    arrWithMinAndMaxElements[1] + " el");
        }else {
            System.out.println("No saddle point, because "  + arrWithMinAndMaxElements[0] + " element != " +
                    arrWithMinAndMaxElements[1] + " element");
        }
    }

}
