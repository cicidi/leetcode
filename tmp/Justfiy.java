public class Justify {

    public List<String> just(String[] words[], int limit) {
        List<String> result = new ArrayList<>();
        int last = 0;
        int total = 0; 
        int len = words.length;

        for (int current = 0; current <= len; current ++) {
            if (current == len || total + current - last + words[current].len > limit){
                int slot = current - last;
                int spaceCount = limit - total;
                StringBuilder sb = new StringBuilder();

               if (current == len){
                    for(int j = last; j < current; j++){
                        sb.append(words[jj]);
                        if(j != currnet - 1){
                            appendspace(sb, 1)
                        }
                    }
                    appendSpace(sb, limit - sb.length())'
               }else{

                    int avg = spaceCount / slot;
                    int extraTo = spaceCount % slot;
                    for (int j = last; j< currentl j++){
                        sb.append(words[j]);
                        if(j !=current - 1){
                         //  3 3 3 3 2 2 2
                         //  j = 4
                         //  extra = 4
                         //last = 0
                            appenspace(sb, j < las + 1 + extra? 1 : 0);
                        }
                    }
               } 

               result.add(sb.toString());
               total = 0;
               last = current;
            
            }

            if (current < len){
                total += words[current].length;
            }
        } 
    
    }
}
