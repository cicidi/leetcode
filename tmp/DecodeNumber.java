public class DecodeNumber {
    
    int dp[] ;

    public static void main(String[] args){
        String test = "1211";
        DecodeNumber d = new DecodeNumber();
        d.init(test.length());   
        int result = d.helper(test,0);
        System.out.println(result);
    
    }
    public int helper(String str, int i){
        if(str.length() == 0 || str.charAt(0) == '0' ||i >= str.length()){
            return 0;
        }
        if (i == str.length()-1){
            return 1;
        }       
        if (dp[i] != -1 ){
            return dp[i];
        }
        int result = helper(str, i+1);
        if (i + 1 < str.length()){
            int a = str.charAt(i) - '0';
            int b = str.charAt(i+1) - '1';
            if  (a*10 + b < 26){
                if (i == str.length() - 2){
                    result += 1;
                }
                result += helper(str, i+2);
            } 
        }
        dp[i] = result;
        return result;
    }

    public void init(int length){
        dp = new int[length];
        for (int i = 0; i < dp.length; i++){
            dp[i] = -1;
        }
    }


    /*
     *Num(12345) = Num(2345) + Num(345)
     *Num(34567) = Num(4567)

     if String equal "" or str[0-1] < 26
     * */


}
