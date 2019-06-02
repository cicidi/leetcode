//import java.util.HashSet;
//import java.util.Set;
//
///*
// * To execute Java, please define "static void main" on a class
// * named Solution.
// *
// * If you need more classes, simply define them inline.
// */
//
//
//////aaaabbaaccgddcdcccddcc
////aabbaa
////cdc
////ccddcc
//
//
//class Solution {
//    public static void main(String[] args) {
//
//        String str = "aaaabbaaccgddcdcccddcc";
//        if (str == null || str.isEmpty()) {
//            return;
//        }
//        Set<String> strings = new HashSet<String>();
//        for (int i = 0; i < str.length(); i++) {
//            scan(str, i, strings);
//        }
//
//        for (String string : strings) {
//            System.out.println(string);
//        }
//    }
//
//    public static void scan(String str, int current, Set<String> results) {
//        int start = current;
//        int end = current;
//        int length = str.length();
//        for (; start >= 0 && end < length; ) {
//            if (start == end && end + 1 < length && str.charAt(start) == str.charAt(end + 1)) {
//                end++;
//                continue;
//            }
//            if (start - 1 >= 0 && end + 1 < length && str.charAt(start - 1) == str.charAt(end + 1)) {
//                start--;
//                end++;
//                continue;
//            }
//            break;
//        }
//        results.add(str.substring(start, end + 1));
//    }
//
//}
//
//
//
//
//
