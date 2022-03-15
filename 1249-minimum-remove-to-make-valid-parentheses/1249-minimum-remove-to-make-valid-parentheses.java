/*
Algorithm:
1. We will take a stack which will be either empty or containing all invalid paranthesis
2. Idea here is we will collect all invalid paranthesis with their index in a stack
3. And then we will remove them from our result using index
4. If char is '(' , then we will add that to stack
5. If char is ')', then we will check top of the stack if it contains '('. 
    a. If top contains '(', then it makes a valid pair of paranthesis. Hence remove this from stack
    b. If stack is empty OR top doesn't contain '(', then char does not make valid paranthesis hence add that to stack
6. Once iteration over each char is done, iterate over each element of stack and remove that from string    
    
*/
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Pair> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        StringBuilder result = new StringBuilder();
        for(int i=0; i<len; i++){
            char c = charArray[i];
            switch(c){
                case '(': stack.push(new Pair(i, c));
                          break;
                case ')': if(!stack.isEmpty()){
                    if(stack.peek().character == '('){ // checking top of stack
                        Pair pair = stack.pop();   
                    }else{
                        stack.push(new Pair(i, c));
                    }
                  }else{
                        stack.push(new Pair(i, c));
                  }    
            }
            result.append(c);
        }
        // if stack is not empty it contains invalid paranthesis only
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            result.deleteCharAt(pair.index);
        }
        
        return result.toString();
    }
}

class Pair{
    int index;
    char character;
    
    Pair(int index, char character){
        this.index = index;
        this.character = character;
    }
}