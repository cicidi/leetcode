package dp;

import java.util.ArrayList;
import java.util.List;

public class IsCapture {
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
    public static void main(String[] args) {
        Character[][] raw = new Character[][]{
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'B', 'B', 'X', 'X'},
                {'X', 'B', 'W', 'W', 'B', 'X'},
                {'X', 'X', 'B', 'W', 'B', 'X'},
                {'X', 'X', 'X', 'W', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'}};
        int row = raw.length;
        int col = raw[0].length;
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {

            List<Character> tmp = new ArrayList<>();
            for (int j = 0; j < col; j++) {
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
        boolean[][] result = new boolean[row][col];
        init(visited, row, col);
        // int[] dir = new int {-1, 0 , 1, 0, -1};
        // for(int i = 0 ; i < row; i++){
        //     for (int j = 0 ; j < col; col++){
        //         if (visited == 'N'){
        //             expend(vis)
        //         }
        //     }

        // }

        //if (pool.contains(board.get(played_row).get(played_row)){
        return expend(visited, board, result, played_row, played_col, row, col);
        //    }else{
        //    return false;
        //}
        // return false;

    }


    // N N N N N N
    // N B ? ->N N N
    // N N N N N N
    public static boolean expend(List<List<Character>> visited, List<List<Character>> board, boolean[][] result, int row, int col, int rowSize, int colSize) {

        // check reach edge of board
        if (row >= rowSize || row < 0 || col > colSize || col < 0) {
            return false;
        }
//
//        if (visited.get(row).get(col) == 'Y') {
//            return result[row][col];
//        }

        // check vistied

        visited.get(row).set(col, 'V');
        if (result[row][col]) {
            return true;
        }
//        if (visited.get(row).get(col) == 'B') {
//            // visited.get(row).get(col) = 'V';
//            return true;
//        }

        // check board
        if (board.get(row).get(col) == 'B') {
            result[row][col] = true;
            return true;
        }


//        if (board.get(row).get(col) == 'W') {
//            visited.get(row).set(col, 'Y');
//        }

        System.out.println("row :" + row);
        System.out.println("col :" + col);
        System.out.println("vis : " + visited.get(row).get(col));
//        boolean allBlock = false;
        int total = 0;
        int block = 0;
        if (row == 5 && col == 3) {
            System.out.println("stop");
        }

        boolean b = expend(visited, board, result, row + 1, col, rowSize, colSize);
        if (b == true) {
            block++;
        } else {
//                allBlock = false;
        }
//            result[row][col] = result[row][col] || b;
//            visited.get(row).set(col, !result[row][col] ? 'F' : 'B');

        boolean b = expend(visited, board, result, row, col + 1, rowSize, colSize);
        if (b == true) {
            block++;
        } else {
//                allBlock = false;
        }
//            result[row][col] = result[row][col] || b;
//            visited.get(row).set(col, !result[row][col] ? 'F' : 'B');
        boolean b = expend(visited, board, result, row - 1, col, rowSize, colSize);
        if (b == true) {
            block++;
        } else {
//                allBlock = false;
        }
//            result[row][col] = result[row][col] || b;
//            visited.get(row).set(col, !result[row][col] ? 'F' : 'B');
        boolean b = expend(visited, board, result, row, col - 1, rowSize, colSize);
        if (b == true) {
            block++;
        } else {
//                allBlock = false;
        }
//            result[row][col] = result[row][col] || b;
//            visited.get(row).set(col, 'Y');
//        result[row][col] = expend(visited, board, result, row + 1, col, rowSize, colSize)
//                && expend(visited, board, result, row, col + 1, rowSize, colSize)
//                && expend(visited, board, result, row - 1, col, rowSize, colSize)
//                && expend(visited, board, result, row, col - 1, rowSize, colSize);
////        if (!block) {
////            visited.get(row).set(col, 'F');
////        } else {
////            visited.get(row).set(col, 'B');
////        }
        result[row][col] = total == block;
        return result[row][col];
    }

    public static void init(List<List<Character>> visited, int rowSize, int colSize) {

        //create empty board;

        for (int i = 0; i < rowSize; i++) {
            visited.add(new ArrayList<>());
            for (int j = 0; j < colSize; j++) {
                visited.get(i).add('N');
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

