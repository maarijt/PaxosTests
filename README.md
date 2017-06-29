# PaxosTests

Problem 1:

The website is live at hashnslash.x10host.com. Click the button to go to "messages.php". Here, enter your message and press submit to save
and see the hash. Enter a hash in the second textbox to check if a message with that hash exists. I implemented the server side logic in
php and stored hashes and messages in a database. Given more time, I couldve definately made the website...more aesthetically pleasing.

The main bottleneck is the calculation of the hash itself. The service spends valuable microseconds to calculate and write the hash to
the database. As the service scales, we will need to replicate the service to multiple servers and shard the database to make it more 
accessible, and to lower the latencies involved. NoSQL based database will be far more useful here. 

Problem 2:

The code is in Solution.java. Usage is java Solution [filename] [Total]

Problem 2 was straightforward. The complexity is O(n). Since the list is sorted, I start from the first and the last element, calculate
the sum and check if its greater, lesser or equal to the sum. If its greater, I move the second pointer up to the second last element.
If lesser, I move the first pointer to the second element, all the while keeping track of the maximum sum less than the total given. 
If equal, I return the pair.

Problem 3:

The code is in Solution2.java. Usage is: java Solution2 [input String]

Used recursion to tackle this one. For every X seen, I make two recursive calls that replace the X with a 1 and a 0 and find the next X
and do it all over again. The code runs in O(n * 2^k) where n is the total length of the input string, and k is the number of Xs. 
