# Scheduler
### Solution 1. PriorityBlockQueue + timeDiff
- run thread every second.
- queue.peek()
    - if time reach, then queue.poll() and processing
    - if time not reach, then sleep(timeDiff)

### Solution 2.  Rolling clock 
- a pointer has a round counter
- each clock has 60 slot as a second.
- each slot is a priority queue , sort by round number. 
- The item in the queue, has a round number.
- when add to queue, calculate the round, and slot, put into the queue.
- each second read a slot, get all item which item.round == pointer.round

###Reference
[scheduler job](https://soulmachine.gitbooks.io/system-design/content/cn/task-scheduler.html)