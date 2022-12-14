class Solution {

    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        if (s.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < s.length; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!(map.get(pattern.charAt(i))).equals(s[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(s[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), s[i]);
            }
        }
        return true;
    }
}
