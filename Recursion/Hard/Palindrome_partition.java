class Solution {
    public List<List<String>> partition(String s) {
     List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(0, s, path, res);
        return res;
    }

    private void backtrack(int index, String s, List<String> path, List<List<String>> res) {
        // Base Case: If we have reached the end of the string, 
        // the current path is a valid partition. Add it to results.
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // Try cutting the string at every possible position starting from 'index'
        for (int i = index; i < s.length(); ++i) {
            
            // Check if the substring from 'index' to 'i' is a palindrome
            if (isPalindrome(s, index, i)) {
                
                // 1. CHOOSE: Add the palindrome substring to our current path
                path.add(s.substring(index, i + 1));
                
                // 2. EXPLORE: Recurse to process the rest of the string
                backtrack(i + 1, s, path, res);
                
                // 3. UN-CHOOSE (Backtrack): Remove the substring to try the next possible cut
                path.remove(path.size() - 1);
            }
        }
    }

    // Standard helper function to check if a string is a palindrome
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
