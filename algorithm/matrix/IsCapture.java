package matrix;

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
                {'X', 'X', 'X', 'B', 'X', 'X'},
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
        int row = board.size();
        int col = board.get(0).size();
        boolean[][] result = new boolean[row][col];
        return !excape(board, result, played_row, played_col, row, col);

    }

    public static boolean excape(List<List<Character>> board, boolean[][] result, int row, int col, int rowSize, int colSize) {

        // check reach edge of board
        if (row >= rowSize || row < 0 || col > colSize || col < 0) {
            return true;
        }
        if (board.get(row).get(col) == 'B') {
            return false;
        }

        // check boar
        System.out.println("row :" + row);
        System.out.println("col :" + col);
        System.out.println("vis : " + board.get(row).get(col));
//        boolean allBlock = false;
        if (row == 5 && col == 3) {
            System.out.println("stop");
        }
        board.get(row).set(col, 'B');
        int[] dir = new int[]{1, 0, -1, 0, 1};
        boolean b = false;
        for (int i = 0; i < 4; i++) {
            b = b || excape(board, result, row + dir[i], col + dir[i + 1], rowSize, colSize);
        }
        return b;
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

