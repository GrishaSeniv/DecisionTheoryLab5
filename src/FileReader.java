import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader extends Matrix{
    PrintMatrix printMatrix = new PrintMatrix();

    int[][] matrix = new int[5][5];
    public ArrayList<String> arrayListWithMatrix = new ArrayList<>();

    public void fileRead() {
        try {
            File file = new File("C:\\Users\\Grisha\\Desktop\\Ну ЛП\\4 курс\\1 семестр\\Decision Theory\\Lab5\\Matrix games(My version)\\src\\resources\\seniv_23variant.txt");
            //Create Object FileReader for Object File
            java.io.FileReader fr = new java.io.FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            String[] words;

            while (line != null) {
                words = line.split(" ");
                for (String word : words) {
                    arrayListWithMatrix.add(word);
                }

                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void ListMatrixToArray() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0){
                    matrix[i][j] = Integer.parseInt(arrayListWithMatrix.get(j));
                }
                if(i == 1){
                    matrix[i][j] = Integer.parseInt(arrayListWithMatrix.get(j+5));
                }
                if(i == 2){
                    matrix[i][j] = Integer.parseInt(arrayListWithMatrix.get(j+10));
                }
                if(i == 3){
                    matrix[i][j] = Integer.parseInt(arrayListWithMatrix.get(j+15));
                }
                if(i == 4){
                    matrix[i][j] = Integer.parseInt(arrayListWithMatrix.get(j+20));
                }
            }

        }
        setMatrix(matrix);
    }
}
