package company.Cruise;

import java.util.*;

/**
 * @author walter on 2019-10-22
 * Lintcode
 * url
 * [0,1,0]
 * [1,5,0]
 * [6,5,0]
 */


public class SpacseMatrix {
    List<List<Element>> list = null;

    public static void main(String[] args) {
        int[][] matrix = new int[10][10];
        int val = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (val % 3 != 0)
                    matrix[i][j] = val;
                else {
                    matrix[i][j] = 0;
                }
                val++;
            }
        }
        SpacseMatrix spacseMatrix = new SpacseMatrix();
        spacseMatrix.init(matrix);
        spacseMatrix.printMatrix();
        spacseMatrix.put(4, 0, 100);
        spacseMatrix.printMatrix();
        spacseMatrix.remove(4, 0);
        spacseMatrix.printMatrix();
    }


    public void init(int[][] matrix) {
        List<Element> rows = new LinkedList<>();
        list = new LinkedList<>();
        list.add(rows);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] != 0) {
                    this.put(row, col, matrix[row][col]);
                }
            }
        }
    }

    public List<Element> getRows(int row) {
        Iterator<List<Element>> iterator = list.iterator();
        List<Element> rows = new LinkedList<>();
        while (iterator.hasNext()) {
            List<Element> tmp = iterator.next();
            if (tmp.size() > 0 && tmp.get(0).row == row) {
                return tmp;
            }
        }
        return rows;
    }

    public Element getElement(List<Element> rows, int col) {
        Iterator<Element> iterator = rows.iterator();
        while (iterator.hasNext()) {
            Element tmp = iterator.next();
            if (tmp.col == col) {
                return tmp;
            }
        }
        return null;
    }

    public void put(int row, int col, int val) {
        List<Element> rows = getRows(row);
        if (rows.size() == 0) {
            this.list.add(rows);
        }
        Element e = getElement(rows, col);
        if (e == null) {
            rows.add(new Element(row, col, val));
        } else {
            e.val = val;
        }
    }

    public void remove(int row, int col) {
        List<Element> rows = getRows(row);
        Iterator<Element> iterator = rows.iterator();
        while (iterator.hasNext()) {
            Element tmp = iterator.next();
            if (tmp.row == row || tmp.col == col) {
                rows.remove(tmp);
            }
        }
    }

    public void printMatrix() {
        Iterator<List<Element>> iteratorRows = list.iterator();

        while (iteratorRows.hasNext()) {
            List<Element> rows = iteratorRows.next();
            Iterator<Element> iteratorElement = rows.iterator();
            while (iteratorElement.hasNext()) {
                Element e = iteratorElement.next();
                System.out.print(e.val);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}

class Element {
    public int row;
    public int col;
    public int val;
    public Element right;
    public Element down;

    public Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}