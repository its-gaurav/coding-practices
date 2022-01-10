class Solution {
    /*
    Approach:
    In binary sum, 
    If sum of two binary bits and carry is greater than 1 then 
    new-carry would be 1
    Else new-carry would be 0
    If sum of two binary bits and carry is divisible by 2 then
    new bit would 0 (e.g like sum (1,1,0) or sum (0,1,1))
    Else new bit would be 1 (e.g like sum (1,1,1))
    
    If there is no bit left in either of two strings but carry!=0
    then add carry to String
    
    */
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int l1 = a.length();
        int l2 = b.length();
        int carry = 0, sum = 0, bitRes = 0;
        while(l1-1>=0 || l2-1>=0){
            sum = carry;
            if(l1-1>=0){
                sum = sum + (a.charAt(l1-1) - '0');
                l1--;
            }
            if(l2-1>=0){
                sum = sum + (b.charAt(l2-1) - '0');
                l2--;
            }
            
            // if sum > 1, then carry would be 1
            carry = (sum > 1) ? 1 : 0;
            
            if(sum%2==0){
                bitRes = 0;
            }else{
                bitRes = 1;
            }
            
            res.append(bitRes);
        }
        
        if(carry==1){
            res.append("1");
        }
        
        return res.reverse().toString();
    }
    
    /*
    Time Complexity: O(max(m,n)) where m,n are lengths of two strings
    Space Complexity: O(max(m,n)) where m,n are lengths of two strings
    */
}