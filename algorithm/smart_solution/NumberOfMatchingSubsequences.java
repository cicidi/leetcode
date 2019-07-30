package smart_solution;

/*
* tag
* leetcode:792. Number of Matching Subsequences
* leetcode:734. Number of Subsequences of Form a^i b^j c^k
//Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.
//
//
//Example :
//Input:
//S = "abcde"
//words = ["a", "bb", "acd", "ace"]
//Output: 3
//Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
//
//
// Note:
//
//
// All words in words and S will only consists of lowercase letters.
// The length of S will be in the range of [1, 50000].
// The length of words will be in the range of [1, 5000].
// The length of words[i] will be in the range of [1, 50].
//
//
* */
public class NumberOfMatchingSubsequences {

    // Returns count of subsequences of the form 
    // a^i b^j c^k 
    static int countSubsequences(String s) {
        // Initialize counts of different subsequences 
        // caused by different combination of 'a' 
        int aCount = 0;

        // Initialize counts of different subsequences
        // caused by different combination of 'a' and 
        // different combination of 'b' 
        int bCount = 0;

        // Initialize counts of different subsequences 
        // caused by different combination of 'a', 'b' 
        // and 'c'. 
        int cCount = 0;

        // Traverse all characters of given string 
        for (int i = 0; i < s.length(); i++) {
            /* If current character is 'a', then 
               there are following possibilities : 
                 a) Current character begins a new 
                    subsequence. 
                 b) Current character is part of aCount 
                    subsequences. 
                 c) Current character is not part of 
                    aCount subsequences. */
            if (s.charAt(i) == 'a')
                aCount = (1 + 2 * aCount); 
       
            /* If current character is 'b', then 
               there are following possibilities : 
                 a) Current character begins a new 
                    subsequence of b's with aCount 
                    subsequences. 
                 b) Current character is part of bCount 
                    subsequences. 
                 c) Current character is not part of 
                    bCount subsequences. */
            else if (s.charAt(i) == 'b')
                bCount = (aCount + 2 * bCount); 
       
            /* If current character is 'c', then 
               there are following possibilities : 
                 a) Current character begins a new 
                    subsequence of c's with bCount 
                    subsequences. 
                 b) Current character is part of cCount 
                    subsequences. 
                 c) Current character is not part of 
                    cCount subsequences. */
            else if (s.charAt(i) == 'c')
                cCount = (bCount + 2 * cCount);
        }

        return cCount;
    }

    // Driver code 
    public static void main(String args[]) {
        String s = "abcabc";
        System.out.println(countSubsequences(s));
    }
}
// This code is contributed by Sumit Ghosh 