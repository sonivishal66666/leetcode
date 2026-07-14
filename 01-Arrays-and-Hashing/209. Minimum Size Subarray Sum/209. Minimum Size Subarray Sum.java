/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(target, nums) {
    let lo = 1;
    let hi = nums.length;
    
    const hasSubarrayOfLengthWithSumLargerThanTarget = (length) => {
        let currSum = 0;
        for (let i = 0; i < length; i++) {
            currSum += nums[i];
            if (currSum >= target) {
                return true;
            }
        }
        
        for (let end = length; end < nums.length; end++) {
            currSum += nums[end];
            currSum -= nums[end - length];
            if (currSum >= target) {
                return true;
            }
        }
        
        return false
    };
    
    while (lo < hi) {
        const mid = lo + Math.floor((hi - lo) / 2);
        if (hasSubarrayOfLengthWithSumLargerThanTarget(mid)) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }
    
    if (hasSubarrayOfLengthWithSumLargerThanTarget(lo)) {
        return lo;
    } else {
        return 0;
    }
};