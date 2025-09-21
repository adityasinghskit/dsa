package org.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args){
//        88. Merge Sorted Array
//                Solved
//        Easy
//                Topics
//        premium lock icon
//                Companies
//        Hint
//        You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//                Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//                The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//
//
//
//        Example 1:
//
//        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//        Output: [1,2,2,3,5,6]
//        Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//        The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//                Example 2:
//
//        Input: nums1 = [1], m = 1, nums2 = [], n = 0
//        Output: [1]
//        Explanation: The arrays we are merging are [1] and [].
//                The result of the merge is [1].
//                Example 3:
//
//        Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//        Output: [1]
//        Explanation: The arrays we are merging are [] and [1].
//                The result of the merge is [1].
//                Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
//
//
//        Constraints:
//
//        nums1.length == m + n
//        nums2.length == n
//        0 <= m, n <= 200
//        1 <= m + n <= 200
//                -109 <= nums1[i], nums2[j] <= 109

        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        String result = driver(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        System.out.println(result);
    }

    static String driver(int[] nums1, int m, int[] nums2, int n) {
        int k=m;
        for(int i=0;i<n;i++){
            nums1[k]=nums2[i];
            k++;
        }
        return mergeSort(nums1, 0, m+n-1);
    }

    static String mergeSort(int[] arr, int l, int r){
        if(l<r){
            int m = l+(r-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
        return Arrays.toString(arr);
    }

    static void merge(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;

        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m+1, R, 0, n2);

        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }
}
