package 基础算法;

public class 快速排序 {
    private static void quickSorted(int [] arr, int start, int end){
        if (arr.length == 0 || arr.length == 1 || start >= end) {
            return;
        }
        int temp = arr[start];
        int l = start;
        int r = end;
        while (l < r){
            // 从右向左
            while (l < r && arr[r] > temp){
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
            }
            l++;
            // 从左向右
            while (l < r && arr[l] < temp){
                l++;
            }
            // 一轮结束，
            if (l < r) {
                arr[r] = arr[l];
            }

        }
        arr[r] = temp;
        quickSorted(arr, start, r-1);
        quickSorted(arr, r+1, end);
    }

    public static void main(String[] args) {
        int[] arr = {33,2,4,3,224,321,444,2};
        quickSorted(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
