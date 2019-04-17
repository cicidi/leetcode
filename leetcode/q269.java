//public class Solution {
//    public String alienOrder(String[] words) {
//        Map<Character, Set<Character>> graph = new HashMap<>();
//        int[] inDegree = new int[26];
//        buildGraph(words, graph, inDegree);
//
//        String order = topologicalSort(graph, inDegree);
//        return order.length() == graph.size() ? order : "";
//    }
//
//    private void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] inDegree) {
//        for (String word : words) {
//            for (char c : word.toCharArray()) {
//                graph.put(c, new HashSet<>());  // 创建一个空图
//            }
//        }
//
//        for (int i = 1; i < words.length; i++) {
//            String first = words[i - 1];
//            String second = words[i];
//            int length = Math.min(first.length(), second.length());// 取最小的长度取比，因为多余的地方没法比indegree
//
//            for (int j = 0; j < length; j++) {
//                char parent = first.charAt(j);
//                char child = second.charAt(j);
//                if (parent != child) {
//                    if (!graph.get(parent).contains(child)) { // 看是否存在
//                        graph.get(parent).add(child);  // 不在加到图里面
//                        inDegree[child - 'a']++;  // 并且child 的 indegree 还要加1
//                    }
//                    break;// 因为已经有一个child了  说明已经在某个位置发生了不一样的字符串，所以就没有必要在继续下面比较了
//                }
//            }
//        }
//    }
//
//    private String topologicalSort(Map<Character, Set<Character>> graph, int[] inDegree) {
//        Queue<Character> queue = new LinkedList<>();
//        for (char c : graph.keySet()) {
//            if (inDegree[c - 'a'] == 0) { //直接开始  从所有最底层的c开始  他们的indegree为0
//                queue.offer(c);
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        while (!queue.isEmpty()) {
//            char c = queue.poll();
//            sb.append(c);  // 因为所有的在queue 里面的char 肯定是indegree 为0 的
//            for (char child: graph.get(c)) {
//                inDegree[child - 'a']--; // 遍历所有的child 值  然后看所有的上一层的indegree 是否为0
//                if (inDegree[child - 'a'] == 0) {
//                    queue.offer(child);
//                }
//            }
//        }
//        return sb.toString();
//    }
//}
