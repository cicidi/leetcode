#tinyUrl

2. Ont to many or One to One   
    Do we store info, like who create / share the link, any other info need to be stored.  If yes, then one long url can have multiple short url
    1. If one to one mapping, do not each that much url, find exist and return
        1. We can store url share info in another table, and do one to one mapping for the url only, do not store other info
    2. If one to many, then many long url is generated, not able to find exist and replace or jus return
4. Generate url
    1. Real time generate
        1. Pro unlimited
        2. Cron 
            1. Slow during passing, and or generate by distribute machine.
    2. Pre generated
        1.  Pro
            1. Fast to generate
        2. Con
            1. Limit of numbers
5. Where to store (look at db compare part)
    1. Rational database 
        1. rich Query
        2. slow 
    2. In memory database
		1. fast
		2. less query 
    3. cassandra db 
6. Security
    1. Avoid web crawler. 
        1. Done not use sequential tiny url
        2. Avoid hacking with too many request. 
            1.  cache, like LRU
7. size of the url  
        1. suppose we use timestamp as a factor to generate url -> 2 ^ n  -> millisecond 
        2. 10 machine generate machine code 2 ^ 4 = 16
        3. 1024 code per machine  per second.  2 ^10
        4. Total sizeOfByte = n + 4 + 10
        5.  The character, if 26 char + number + case sensitive 62
        6.  Min size = 62 ^ size >  2 ^ (n+14)
		7. we use long type for time stamp, long type is 64 bit. So n max is 2 ^ (64+ 14 = 78) < 2 * 6 * size   
			Max of size is 13, but this is a huge number which assume as above.
		8. If 2 ^ 64 is enough, then 2^ 64 = 2 ^ 6*(64/6) close to 64 ^10  then size is close to 10
		9 for pre generate , if we know the size , that would be shorter. 1M per day, 20 years, -> 2  ^ ?
8. How to convert long value to a short URL  
    进制 decimal system
    keep dividing by 62
    for example  
    627 ->  627 % 10 -> 7   
            62 % 10 -> 2  
            6 %10 -> 6 
    
8. create distributed id by using database 



## How to answer this question
1. Question before start. quick solution
		1. Create
			- uuid
			- database feature , auto increment 
			- Distributed system
			- pre generated
		2. Update
			-if  one to one mapping
	              - if one to many , not easy to update. Because need query find exist
		3. Get 
			- store where DB/ cache
		4. Delete 
			- clean up delete by time or some other citeria
			- or “delete” by override. Time by time-able cache.
2. Then ask question to choose the different tools.
	- how long you want to store the data.
	- how many tiny url generated per day / per second
	- size limit of the tiny url
	- does tiny url only mapping to long url or other info, like. How many clicks, use who create the link, which website 
	he shares the link
			

## Reference
[实时输出最近一个小时内访问频率最高的10个IP](https://soulmachine.gitbooks.io/system-design/content/cn/top-k-frequent-ip-in-one-hour.html)  


			