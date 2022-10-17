class Solution {

    public boolean checkIfPangram(String s) {
        // Empty set 'seen'.
        Set<Character> seen = new HashSet<>();

        // Iterate over 'sentence' add every letter to 'seen'.
        for (char currChar : s.toCharArray()) seen.add(currChar);

        // If the size of 'seen' is 26, then 'sentence' is a pangram.
        return seen.size() == 26;
    }
}
