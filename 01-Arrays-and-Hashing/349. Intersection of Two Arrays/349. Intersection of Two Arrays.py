    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();

        HashSet<Integer> nums1Set = new HashSet<>();

        for(int num : nums1) {
            nums1Set.add(num);
        }

        for(int num : nums2) {
            if(nums1Set.contains(num)) {
                intersection.add(num);
                nums1Set.remove(num);
            }
        }

        int[] ans = new int[intersection.size()];

        for(int i = 0; i < ans.length; i++) {
            ans[i] = intersection.get(i);
        }

        return ans;
    }