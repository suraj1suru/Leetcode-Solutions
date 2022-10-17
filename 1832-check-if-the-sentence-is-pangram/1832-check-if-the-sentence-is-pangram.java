class Solution {

    public boolean checkIfPangram(String s) {
        int i = 0;
        int n = s.length();
        if (n < 26) return false;
        boolean[] mark = new boolean[26];
        while (i != n) {
            int index = s.charAt(i) - 'a';
            mark[index] = true;
            i++;
        }
        for (int j = 0; j < mark.length; j++) {
            if (mark[j] == false) return false;
        }

        return true;
    }
}
