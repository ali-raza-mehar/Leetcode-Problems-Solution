
public class Search_in_rotated_sorted_array {

    static int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    static int helper(int[] nums, int target, int s, int e) {
        if (s > e)
            return -1;

        int mid = s + (e - s) / 2;
        if (nums[mid] == target)
            return mid;
        // check part sorted or not
        if (nums[s] <= nums[mid]) {
            // check whether the target lies in this range or not
            if (target >= nums[s] && target <= nums[mid])
                return helper(nums, target, s, mid - 1);
            else
                return helper(nums, target, mid + 1, e);
        }

        // check whether the element lies in second part or not
        if (target >= nums[mid] && target <= nums[e])
            return helper(nums, target, mid + 1, e);

        return helper(nums, target, s, mid - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(search(nums, target));
    }
}