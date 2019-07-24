**Memoization**

This repository includes a Java as well as a JavaScript implementation of the memoization optimization technique. 
The implementations were tested with the function "addToTime". 

```
function addToTime(year, month, day) {
    return Date.now() + Date(year, month, day)
;}
``` 

If a resolver is provided, it determines the cache key for storing the result
based on the arguments provided to the memorized function. By default, the first
argument provided to the memorized function is used as the map cache key. The 
memorized values timeout after the timeout exceeds. The timeout is defined in milliseconds.
