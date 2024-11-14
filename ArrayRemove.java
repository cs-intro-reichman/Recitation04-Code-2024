public class ArrayRemove {
    public static void main(String[] args) {
        int [] arr1 = {4, 1, 2, 3, 5};
        int [] arr2 = {0, 1, 2, 3, 0, 6, 0, 9};
        int [] arr3 = {1, 2, 3};
        int [] res1 = remove(arr1, 2);
        int [] res2 = remove(arr2, 0);
        int [] res3 = remove(arr3, 19);
        ArrayUtils.printArray(res1);
        ArrayUtils.printArray(res2);
        ArrayUtils.printArray(res3);
    }
    
    // Question 4
    public static int[] remove(int[] arr, int element) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                count++;
            }
        }
        int[] ans = new int[arr.length - count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != element){
                ans[index] = arr[i];
                index++;
            }
        }
        return ans;
    }
    
}
