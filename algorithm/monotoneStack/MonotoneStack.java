package monotoneStack;

import java.util.Stack;
import java.util.Arrays;

public class MonotoneStack {
  public static void main(String[] args){
      System.out.println("test");
      int[] input = new int[]{4,2,3,1,5,4};
      System.out.println(Arrays.toString(asc(input).toArray()));
  }
  public static Stack<Integer> asc(int[] input) {
    Stack<Integer> stack = new Stack<>();
    for (int i : input){
       while(!stack.isEmpty()){
         int tmp = stack.peek();
         if (tmp > i){
            stack.pop();
         }else{
            break;
         }
       } 
       stack.add(i);
    }  
   return stack;
  }
}
