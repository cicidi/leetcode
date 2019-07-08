# Flash sale  秒杀系统

## Frontend   
- disable button if clicked  
- check code
- One User / IP one request per second
- rate limit by tech 
- rate limit by business logic, like random pick

## Mid layer
- load balancer 


## Backend  
- Server scalability 
- async service
    - return 201
    - call back (optional)
- message queue, like Kafka
    - send all message to queue. Queue is a good solution to handel tons of request in short period of time. and of course,
    it is async
- read and write separately 
  - more read then write, use cache, like LRU, or in memory DB
  - when ever database update update cache.
  - for write operation
    - use queue
    - use redis as a proxy for db, run out resource in redis, when server not busy update redis with with db
- database optimize
    - database sharding
    - database update with batch
    - user redis as mysql / oracle proxy



[reference: Java开发面试：高并发秒杀系统如何设计与优化](https://blog.csdn.net/CSDN_Terence/article/details/77744042)

