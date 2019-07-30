package algorithm.company.Square;

public class DayOfUtc {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getDay(6));
    }

    static class Solution {
        long current = System.currentTimeMillis();
        long longValueOfDay = 1000 * 60 * 60 * 24;
        long weekValueOfDay = longValueOfDay * 7;

        public int getDay(int today) {
            long rem = current % weekValueOfDay;
            if (rem == 0) return today;
            if (rem % longValueOfDay == 0) return (int) (today - rem / longValueOfDay);
            else return (int) (today - rem / longValueOfDay);
        }
    }

}

