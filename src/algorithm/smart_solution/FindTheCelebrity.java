package algorithm.smart_solution;

/*
  * tag
  * 645. Find the Celebrity
  * https://www.lintcode.com/problem/find-the-celebrity/description
  */
public class FindTheCelebrity {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Write your code here
        int ans = 0;
        //
        // since celebrity know noone, if i is the celebrity if wont change to anython value
        // but there is a change that his celebrity is a fake one, who know people before i
        // so need to check one more time in the next loop.
        for (int i = 1; i < n; i++) {
            if (knows(ans, i)) {
                ans = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (ans != i && knows(ans, i)) {
                return -1;
            }
            if (ans != i && !knows(i, ans)) {
                return -1;
            }
        }
        return ans;
    }

    boolean knows(int a, int b) {
        return true;
    }
}
