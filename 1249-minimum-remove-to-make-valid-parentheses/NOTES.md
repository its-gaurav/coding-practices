Algorithm:
1. We will take a stack which will be either empty or containing all invalid paranthesis
2. Idea here is we will collect all invalid paranthesis with their index in a stack
3. And then we will remove them from our result using index
4. If char is '(' , then we will add that to stack
5. If char is ')', then we will check top of the stack if it contains '('.
a. If top contains '(', then it makes a valid pair of paranthesis. Hence remove this from stack
b. If stack is empty OR top doesn't contain '(', then char does not make valid paranthesis hence add that to stack
6. Once iteration over each char is done, iterate over each element of stack and remove that from string