class Solution {
    /*
    starting from right most character in string "ZY"
    ('Y'-'A'+1)* 26^0 + ('Z'-'A'+1)* 26^1
    */
    public int titleToNumber(String columnTitle) {
        char[] charArr = columnTitle.toCharArray();
        int colNumbr = 0;
        int len = charArr.length;
        for(int i=len; i>0; i--){
            double tmp = (charArr[i-1] - 'A' + 1) * Math.pow(26, len - i);
            colNumbr += tmp;
        }
        
        return colNumbr;
    }
}