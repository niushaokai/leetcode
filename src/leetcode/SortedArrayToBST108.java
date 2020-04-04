package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/30
 */
public class SortedArrayToBST108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;
    }

    public TreeNode sort2Tree(int[] nums,int start,int end){
        if(start == end){
            return null;
        }
        int mid = start + (end - start)>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sort2Tree(nums,start,mid-1);
        root.right = sort2Tree(nums,mid+1,end);
        return root;
    }
}