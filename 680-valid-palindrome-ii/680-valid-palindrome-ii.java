class Solution {
    /*
    Given string s can be palindrome by deleting at most one character only when:
    1. The string itself is a palindrome OR
    2. If s.charAt(i)!=s.charAt(j), then s can be palindrome by deleting
    one character only when s[i,j-1] OR s[i+1,j] is a palindrome
    */
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        while(start<end){
            // if not equal, then one of them can be deleted
            if(s.charAt(start) != s.charAt(end)){
                // if charAt(start) is deleted
                boolean b1 = isPalindrome(s, start+1, end);
                // if charAt(end) is deleted
                boolean b2 = isPalindrome(s, start, end-1);
                return b1 || b2;
            }
            
            start++; end--;
        }
        
        return true;
    }
    /*
    Take two pointers start and end
    Compare characters at `start` and `end` and keep updating the pointers
    If at any point two characters are not equal, return false
    */
    boolean isPalindrome(String s, int i, int j){
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++; j--;
        }
        
        return true;
    }
}