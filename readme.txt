Linh Nguyen '21 (lnguyen@colgate.edu) 

Test cases: 

test1.txt: generate text until the word limit is reached.
java WordGen test1.txt
baababababababababababababababababababababababaababababababababababababababababababababababababababa
Word Count: 100/100

java WordGen test1.txt 123
123
Word Count: 3/100

test2.txt: nothing in the text. program cannot generate any text.
java WordGen test2.txt

Word Count: 0/100

test3.txt: only 2 characters in the text. program cannot generate any new characters and must stop.
java WordGen test3.txt
ab
Word Count: 2/100

test4.txt: generate text until there is no character after the sequence to continue.
java WordGen test4.txt abc 5
abcxy
Word Count: 5/5

java WordGen test4.txt abc
abcxyz.-12345
Word Count: 13/100

as_you_like_it.txt (default file) and hamlet.txt: these two files are used to text for time efficiency. 

java WordGen
watcher fair ev'n in his again
a come good
  ROSALIND. But is own.

     in people you many fair ROS
Word Count: 100/100

java WordGen hamlet.txt
cipate:
   We hat death-be must slownerly give which, thy brink. Heaven dead!

   Are art as the in 
Word Count: 100/100

Comments: 
- I am happy that my code is functional and each method only has one function. The code is fairly easy to read with clearly named methods and variables. 

- The problem is the running time is quite slow in my opinion. I try to eliminate as much loop as possible. It works fine for short file, but for longer file (hamlet.txt and as_you_like_it.txt), it takes the program a few second to run. 

- Also, it would be great to have a shorter and faster way to read all the information in the plain text files, including white spaces. 

