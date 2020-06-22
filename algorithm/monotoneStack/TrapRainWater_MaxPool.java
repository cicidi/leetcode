package monotoneStack;
import java.util.Stack;
import java.util.Arrays;
public class TrapRainWater_MaxPool  {
  
   public static void main(String[] args){
      int[] input = new int[]{0,1,0,2,1,0,0,3,2,1,2,1};
      System.out.println(cal(input));
   }

   public static int cal(int[] input){
      Stack<Integer> stack = new Stack<>();
      int pool = 0;
      int max = 0;
      int lftHt = 0;
      for(int i = 0; i < input.length; ){
          if(stack.isEmpty() || input[stack.peek()] >= input[i]) {
              if (stack.isEmpty()){
                pool = 0;
              }
              stack.add(i);
              i++;
          }else{
            System.out.println(Arrays.toString(stack.toArray()));
            int bot = stack.pop();
            if (stack.isEmpty()){
              continue;
            }
            int bar = Math.min(input[i], input[stack.peek()]); 
            int wh = bar - input[bot];
            int dis = i - stack.peek() - 1; 
            pool += wh * dis;
            max = Math.max(pool, max);
            System.out.printf("bot: %d, bar: %d, wh: %d, dis: %d, pool: %d  max: %d \n", input[bot], bar, wh, dis, pool, max);
          }
      }
      return max;
   }
}


/*
 * index  height stack   lowBar   bottom          walter
 * 0      0                0                        0
 * 1      1       1        0                        0
 * 2      0       [1,0]    0                        0 
 * 3      2       [3]      1       stack.pop->0     1   <- 3 - 1 - 1* (lowBar - bottom) 
 *
 *
 * */
