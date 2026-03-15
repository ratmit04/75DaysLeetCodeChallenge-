class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char hashForS[] = new char[26];
        char hashForT[] = new char[26];
        for(int i = 0 ; i<s.length() ; i++){
            var chS = s.charAt(i); 
            var chT = t.charAt(i); 
            hashForS[(int)chS - 'a']++;
            hashForT[(int)chT - 'a']++;
        }
        var s1 = new String(hashForS);
        var t1 = new String(hashForT);
        return s1.equals(t1);
    }
}