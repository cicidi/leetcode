package binary_search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author walter on 2020-01-31
 * Lintcode
 * url
 */
public class Test {


    public static void main(String[] args) {
        //  ArrayList<String> strings = new ArrayList<String>();
        //  strings.add("Hello, World!");
        //  strings.add("Welcome to CoderPad.");
        //  .add("This pad is running Java " + Runtime.version().feature());

        // for (String string : strings) {
        //   System.out.println("Sring");
        // }

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        l1.add(1);
        l1.add(3);
        l1.add(5);
        l1.add(7);

        l2.add(2);
        l2.add(4);
        l2.add(6);
        l2.add(8);
        // int[] arr1 = new int[]{1,2,3,4};
        // int[] arr2 = new int[]{1};/
        // l1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        // l2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());


        List<Integer> result = union(l1, l2);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    public static List<Integer> union(List<Integer> l1, List<Integer> l2) {

        //check null and size 0

        List<Integer> result = new ArrayList<>();

        int len1 = l1.size();
        int len2 = l2.size();


        int p1 = 0;
        int p2 = 0;

        for (; p1 < len1 && p2 < len2; ) {
            if (l1.get(p1) == l2.get(p2)) {
                result.add(l1.get(p1));
                p1++;
                p2++;
                continue;
            }
            if (l1.get(p1) < l2.get(p2)) {
                result.add(l1.get(p1));
                p1++;
            } else {
                result.add(l2.get(p2));
                p2++;
            }

        }

        for (; p1 < len1; p1++) {
            result.add(l1.get(p1));
        }

        for (; p2 < len2; p2++) {
            result.add(l2.get(p2));
        }

        return result;
    }
}
