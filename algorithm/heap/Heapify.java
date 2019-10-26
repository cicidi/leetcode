package heap;

//important 这道题只能被
//recite
/*
 * Given an integer array, heapify it into a min-heap array.For a heap array A, A[0] is the root of heap,
 * and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
 * 给出一个整数数组，堆化操作就是把它变成一个最小堆数组。对于堆数组A，A[0]是堆的根，并对于每个A[i]，
 * A [i * 2 + 1]是A[i]的左儿子并且A[i * 2 + 2]是A[i]的右儿子。

 * */

/*
* 分析  最后得出来的array 并不是order 的 他只是满足min heap 的要求
*
0	1	2	3	4	5	6	7	8	9
1	3	4	12	7	9	8	6	5	2
				^
1	3	4	12	2	9	8	6	5	7
				^
1	3	4	5	2	9	8	6	12	7
			^
1	3	4	5	2	9	8	6	12	7
		^
1	3	4	5	2	9	8	6	12	7
	^
1	3	4	5	2	9	8	6	12	7
	^
1	3	4	5	2	9	8	6	12	7
^
* */
public class Heapify {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here

        int length = A.length;
        if (length == 0)
            return;
        //notice 从中点开始 从后往前scan
        for (int i = length / 2; i >= 0; i--) {
            scanFromMidToLeft(A, i);
        }
    }

    // question 感觉这道题不光是要把 Ai 和Ai*2+2 Ai*2+2 的关系找出来，而且还得是按照
    // 大小顺序 一次重新排列出来  需要重新找一下这道题
    public void scanFromMidToLeft(int[] A, int selected) {
        int length = A.length;
        while (selected < length) {
            //notice 另smallest 等于当前选择
            int smallest = selected;
            //notice 在selected 和 select*2+1  select*2+2 中间找一个 最小的
            if (selected * 2 + 1 < length && A[smallest] > A[selected * 2 + 1]) {
                smallest = selected * 2 + 1;
            }
            if (selected * 2 + 2 < length && A[smallest] > A[selected * 2 + 2]) {
                smallest = selected * 2 + 2;
            }
            if (smallest == selected) {
                break;
            }

            //notice 然后互相交换
            int tmp = A[smallest];
            A[smallest] = A[selected];
            A[selected] = tmp;
            //notice 交换玩以后再让select 等于smallest
            selected = smallest;
        }
    }
}