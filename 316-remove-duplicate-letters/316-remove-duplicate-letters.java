class Solution {
    
     /**
    Prepare a frequency-map of each character, And a isIncluded boolean-array that tells if a char has been included in our answer.
    Prepare a stack that will finally stores all characters of result string
    Iterate over each character and keep updating frequency-map. If isIncluded[character] is already true, then we can skip this character.
    Since we have to include a character only once AND have to maintain lexicographic order in our answer as well, 
        a. Before including a character in stack, check if isIncluded[character] is already true
        b. If character at top of stack is greater than current character AND the character at top of stack is still left in input string, then we will remove this character from top and make isIncluded[characterAtTop] = false because we can include this character at later point
        
    **/
    public String removeDuplicateLetters(String s) {
        int size = s.length();
        int[] freq = new int[26]; // count of each character of input string
        boolean[] isIncluded = new boolean[26]; // if a character has been included in our answer
        for(char ch: s.toCharArray()){
            freq[ch - 'a']++; 
        }
        
        LinkedList<Character> linkedList = new LinkedList<Character>();
        
        for(char ch: s.toCharArray()){
            freq[ch - 'a']--;
            
            if(isIncluded[ch - 'a']){ // only 1 occurence of each char is allowed
                continue;
            }
            // if last-element of list is greater than current char AND last-element is still available in input string
            while(!linkedList.isEmpty() && linkedList.getLast() > ch && freq[linkedList.getLast() - 'a'] > 0){
                char top = linkedList.removeLast();
                isIncluded[top - 'a'] = false;
            }
            
            linkedList.add(ch);
            isIncluded[ch - 'a'] = true;
        }
        
        StringBuffer sb = new StringBuffer();
        while(!linkedList.isEmpty()){
            sb.append(linkedList.removeFirst());
        }
        
        return sb.toString();
    }
}