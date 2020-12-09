public class Main {
    public static void main(String[] args) {
        System.out.println("1) MAXMIN AND MIXMAN ELEMENTS");
        MinMax minMax = new MinMax();
        minMax.minMax();
        minMax.maxMin();
        minMax.checkForSaddlePoint();

        System.out.println("\n\n2) Matrix optimization");
        DominateRow dominateRow = new DominateRow();
        dominateRow.dominateSecondRowTest()
                .dominateSecondColumn()
                .dominateFourthColumn()
                .dominateFirstRow();

        System.out.println("Simplex method for this matrix:");
        dominateRow.simplex();

    }
}
