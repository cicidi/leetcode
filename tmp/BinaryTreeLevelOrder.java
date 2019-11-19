//public class BinaryTreeLevelOrder {
//	public List<Integer> levelOrder (TreeNode node){
//		if (node == null) {
//			return null;
//		}
//		List<Integer> result = new ArrayList<>();
//		PriorityQueue<Integer> queue = new LinkedList<>();
//		queue.offer(node);
//		while(!queue.isEmpty()){
//			List<TreeNode> tmpList = new ArrayList<>();
//			while!queue.isEmpty()){
//				tmpList.add(queue.poll);
//			}
//			for(TreeNode treeNode : tmpList){
//				result.add(treeNode.value);
//				if (treeNode.left != null){
//					queue.offer(treeNode.left);
//				}
//				if(treeNode.right != null ){
//					queueu.offer(treeNode.right);
//				}
//			}
//
//		}
//		return result;
//	}
//
//}
