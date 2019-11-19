import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
/*
'X' - Empty
'W' = White
'B' = Black

X X X X X X
X X B B X X
B W B W W B X 
X X B B X X
X X X X X X
X X X X X X 


*/
    // Complete the isCapture function below.
    public static void main(String[] args){
       Character[][] raw= new Character[][]{
        {'X','X','X','X','X','X'},
        {'X','X','B','B','X','X'},
        {'X','B','W','W','B','X'},
        {'X','X','B','B','X','X'},
        {'X','X','X','X','X','X'},
        {'X','X','X','X','X','X'}}; 
        int row = raw.length;
        int col = raw[0].length;
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < row; i++){
            
            List<Character> tmp = new ArrayList<>();
            for(int j = 0; j < col; j++ ){
                tmp.add(raw[i][j]);
            }
            list.add(tmp);
       } 
       System.out.println(isCapture(list, 2, 2));
    }
    static boolean isCapture(List<List<Character>> board, int played_row, int played_col) {
        // valid null or size or 0 ;
        // skip
            
        List<List<Character>> visited = new ArrayList<>();
        //
        int row = board.size();
        int col = board.get(0).size();
        
        init(row, col);
        // int[] dir = new int {-1, 0 , 1, 0, -1};
        // for(int i = 0 ; i < row; i++){
        //     for (int j = 0 ; j < col; col++){
        //         if (visited == 'N'){
        //             expend(vis)
        //         }
        //     }
            
        // }
        
        //if (pool.contains(board.get(played_row).get(played_row)){
        return expend(visited,board,played_row,played_col, row,col, board.get(played_row).get(played_col));
        //    }else{
        //    return false;
        //}
        // return false;

    } 
    
    
    // N N N N N N
    // N B ? ->N N N
    // N N N N N N
    public static boolean expend (List<List<Character>> visited, List<List<Character>> board, int row, int col, int rowSize, int colSize, Character target){
        
        // check reach edge of board
        if (row >= rowSize || row <0 || col > colSize || col <0 ){
            return false;
        }

        // check vistied
        if (visited.get(row).get(col) == 'F'){
            return false;
        }
        if (visited.get(row).get(col) == 'B'){
                    // visited.get(row).get(col) = 'V';
            return true;            
        }
        
        // check board
        if (board.get(row).get(col) != target){
            visited.get(row).get(col) = new Character('B');
            return true;
        }
        
        boolean block = expend (vistied,board, row + 1, col,rowSize, colSize,target)

                    &&expend (vistied,board, row, col + 1,rowSize, colSize, target)  
                    &&expend (vistied,board, row -1 ,col,rowSize, colSize, target) 
                    &&expend (vistied,board, row,col -1,rowSize, colSize, target);
        if (!block){
             visited.get(row).get(col) = 'F';
        }else{
            visited.get(row).get(col) = 'B';
        }
        return block;
    }
    public static void init (int rowSize, int colSize){
        
        //create empty board;
        
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                visited.get(i).get(j) = 'N';
            }
        }
    }
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int boardRows = Integer.parseInt(bufferedReader.readLine().trim());
        int boardColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Character>> board = new ArrayList<>();

        IntStream.range(0, boardRows).forEach(i -> {
            try {
                board.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(e -> e.charAt(0))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int played_row = Integer.parseInt(bufferedReader.readLine().trim());

        int played_col = Integer.parseInt(bufferedReader.readLine().trim());

        boolean res = isCapture(board, played_row, played_col);

        bufferedWriter.write(String.valueOf(res ? 1 : 0));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
        return;
    }*/

}

