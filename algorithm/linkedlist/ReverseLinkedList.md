
# Reverse LinkedList

### Here is the problem 
 nil -> cur -> next -> others...
 
     ->  0  ->  1   ->   2

#### what we need to do is using recursion. outside of the recursion we need to variables to track the relation ships
- prev
- cur

####In the recursion, we just need to do this in the while loop

1. prev <- cur, which mean the next of `cur` is `prev`.

```
  Node next = cur.next; // save next somewhere; and give it to `cur`
  cur.next = prev;   // set the next of cur to prev
```

what to do next ?
move ` prev`and `cur` to right(next) 
```java
prev = cur;
cur = cur.next;
```
only the first 2 line is actually changing the relation, and `linklist` doesnt care relation of `who is previous`



