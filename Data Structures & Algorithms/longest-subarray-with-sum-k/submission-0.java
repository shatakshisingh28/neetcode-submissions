class Solution {
    public int longestSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> firstIndex = new HashMap<>();
        firstIndex.put(0, -1);
        int curSum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];

            if (firstIndex.containsKey(curSum - k)) {
                maxLen = Math.max(maxLen, i - firstIndex.get(curSum - k));
            }

            firstIndex.putIfAbsent(curSum, i);
        }
        return maxLen;
    }
}
