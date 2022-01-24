class Solution {
    public boolean detectCapitalUse(String word) {
        String allUpperCase = word.toUpperCase();
        String allLowerCase = word.toLowerCase();
        char c = word.toUpperCase().toCharArray()[0];
        char[] charArray = word.toLowerCase().toCharArray();
        charArray[0] = c;
        String camelCase = new String(charArray);
        if(word.equals(allUpperCase) || word.equals(allLowerCase) || word.equals(camelCase)){
            return true;
        }
        
        return false;
    }
}