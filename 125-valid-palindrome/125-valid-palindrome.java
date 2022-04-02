class Solution {
    /*
    Take two pointers over given string, say `start` and `end`
    1. while char at `start` is not in alphanumeric range, do `start`++
    2. Similarly while char at `end` is not in alphanumeric range, do `end`--
    3. If both char are alphanumeric but not equal, return false
    4. start++, end--
    
    Numbers ascii range = 48 to 57
    Alphabets A-Z = 65 to 90
    Alphabets a-z = 97 to 122
    */
    public boolean isPalindrome(String s) {
        int start = 0;
        int len = s.length();
        int end = len-1;
        
        while(start<=end){
             while(start<len && !(isAlphabet(s.charAt(start)) || isNumber(s.charAt(start)))){
                start++;
            }
            while(end>=0 && !(isAlphabet(s.charAt(end)) || isNumber(s.charAt(end)))){
                end--;
            }
            if(start<len && end>=0){
                if(isAlphabet(s.charAt(start)) && isAlphabet(s.charAt(end)) && 
               Character.toLowerCase(s.charAt(start))!= Character.toLowerCase(s.charAt(end))){
                    return false;
                }else if(isNumber(s.charAt(start)) && isNumber(s.charAt(end)) && 
                        s.charAt(start) != s.charAt(end)){
                    return false;
                }else if(isAlphabet(s.charAt(start)) && isNumber(s.charAt(end))){
                    return false;
                }else if(isAlphabet(s.charAt(end)) && isNumber(s.charAt(start))){
                    return false;
                }   
            }
            
            start++; end--;
            
        }
        
        return true;
    }
    
    public boolean isAlphabet(char c){
        return (c>=65 && c<=90) || (c>=97 && c<=122);
    }
    public boolean isNumber(char c){
        return (c>=48 && c<=57);
    }
}