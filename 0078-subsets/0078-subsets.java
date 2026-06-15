class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return generate(nums.length, nums);
    }

    public List<List<Integer>> generate(int n, int[] nums) {
        if (n == 0) {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }

        int num = nums[n - 1];

        List<List<Integer>> faith = generate(n - 1, nums);

        List<List<Integer>> answer = new ArrayList<>(faith);

        for (List<Integer> temp : faith) {
            List<Integer> newSubset = new ArrayList<>(temp);
            newSubset.add(num);
            answer.add(newSubset);
        }

        return answer;
    }
}