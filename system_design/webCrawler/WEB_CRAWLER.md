
#Webcrawler


## Url Storage
1. Use in memory db
1. Use bloom filter
    - Pro
        - does not store value, only check it is exist, less space
        - insert and get all O(n)
    - Cons
        - can not garnette accuracy, object might have duplicate hash value, But for web crawler is fine. 

## KafkaQueue
topic by region / priority....

## Scheduler
Some url need to be update by period of time. 
    -> this can be a question as a scheduler.  Go to ./schedule.md
##Master 
- func acceptNewRequest()   
    - check exist
    - upsert record in DB
    - send Url to Kafka by region

##Worker
- var region
- func subScribeJobByRegion()  // or get  high priority first
    - if topic is empty, get job from other region_topic

## Job
- var job_url
- var[] sub_url. (if sub url different domain, or different ip send back to master. otherwise keep digging)

## Parser 
- Parsing, different , content , technology , different parser. 
- what to extract
- get subUrl to extract

## Content Storage
- MongoDB.
    - why
      - not transactional 
      - document oriented , html can change to a json format -> A document database is a type of nonrelational database that is designed to store and query data as JSON-like documents. 
      - Geospatial support
      - High scalability, unlimited storage.
- cassandra  
uuid, url, domain, content, lastModified_time

## Clean up
Content clean up after a period of time

##Follow up
- concurrent download
- de-duplicate
- ip-blocked
- how to know crawling finish (no sub url)
- how to split work if half machine is faster than others  (job are picked by machine itself, so does'nt matter of machine speed) 
- Split job by location


##Reference
[Build a Web Crawler](http://blog.gainlo.co/index.php/2016/06/29/build-web-crawler/)
[When to Use (and Not to Use) MongoDB](https://dzone.com/articles/why-mongodb)