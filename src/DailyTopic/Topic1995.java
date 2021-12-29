package DailyTopic;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/12/29 22:26
 */
public class Topic1995 {
    class Solution {
        public int countQuadruplets(int[] nums) {
            int n = nums.length;
            if(n < 4)
                return 0;

            int res = 0;
            for(int i = 0; i < n - 3; i++){
                for(int j = i + 1; j < n - 2; j++){
                    for(int k = j + 1; k < n - 1; k++){
                        for(int l = k + 1; l < n; l++){
                            if(nums[i] + nums[j] + nums[k] == nums[l]){
                                res++;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
}
