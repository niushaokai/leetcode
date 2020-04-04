package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author niushaokai
 * @date 2019-12-30
 */
public class FindKthLargest215 {
    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        Collections.sort(list);
        return list.get(nums.length - k);
    }

    /**
     * 高手解法，堆
     */
    public static int findKthLargest2(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // output
        return heap.poll();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 8, 7, 2, 9};

        //小顶堆
//        PriorityQueue<Integer> heap =
//                new PriorityQueue<>((n1, n2) -> n1 - n2);


        //大顶堆
        PriorityQueue<Integer> heap =
                new PriorityQueue<>((n1, n2) -> n2 - n1);
        heap.offer(2);
        heap.offer(1);
        heap.offer(6);
        while (heap.size()>0){
            System.out.println(heap.poll());
        }
    }
}