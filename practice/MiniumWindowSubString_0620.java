import java.util.*;
public class MiniumWindowSubString_0620{
  public String min(String s, String t){
      int left = 0;
      for(int right = 0; right < t.lenght(); right++){
        char c = t.charAt(right);
        if 
      }
    
    }
    
    public Map<Character, Integer> convertToMap(String t){
       Map<Character,Integer> map  = new HashMap<Character, Integer>();  
       for(char c:t.toCharArray()){
        map.put(c,map.getOrDefault(c,0)+1);
       }
       return map;
    }
}
