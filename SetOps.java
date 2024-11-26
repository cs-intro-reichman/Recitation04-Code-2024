
public class SetOps {
    public static void main(String[] args) {
        int [] arr = {1, 8, 20, -3, 0, 1, 1, 6, 8};
        int [] set = set(arr);

        ArrayUtils.printArray(set);
        int [] arr1 = {67, 22, 22};
        System.out.println(countUnique(arr1));
    }
    // Question 5, Step 1
    public static boolean contains(int[] arr, int value, int index) { 
        for (int i = 0; i < index; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    // Question 5, Step 2
    public static int countUnique(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!contains(arr, arr[i], i)){
                count++; 
            }
        }
        return count;
    }
    // Question 5
    public static int [] set (int[] arr) {
        int [] res = new int [countUnique(arr)]; //{1, 8, 20, -3, 0, 1, 1, 6, 8} -> {1, 8, 20, -3, 0, 6}
        int index = 0; 
        for (int i = 0; i < arr.length; i++) {
            if (!contains(arr, arr[i], i)){
                res[index] = arr[i];
                index++;
            }
        }
        return res;
    }

    // Question 5, Expansion 3
    public static boolean contains(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false ;
    }
    
    // Question 5, Expansion 4
    public static int [] unionSets(int[] set1, int[] set2) { 
        int [] res = new int [set1.length + set2.length]; //{1,2,3,4,4,6,7}
        int index = 0; 
        for (int i = 0; i < set1.length; i++) {
            res[index] = set1[i];
            index++;
        }
        
        for (int i = 0; i < set2.length; i++) {
            res[index] = set2[i];
            index++;
        }
        return set(res);
    }

    // Question 5, Expansion 4, Another Solution
    public static int [] unionSets1(int[] set1, int[] set2) {
        int [] res = new int [set1.length + set2.length];
        for (int i = 0; i < res.length; i++) {
            if (i < set1.length){
                res[i] = set1[i];
            } else {
                res[i] = set2[i - set1.length];
            }
        }
        
        return set(res);
    }
    
    // Question 5, Expansion 5
    public static int [] intersectionSets(int[] set1, int[] set2) {
        int [] arr = new int [Math.min(set1.length , set2.length)]; // {1,2,5} {1,2,3,4}
        int [] smallSet = set1.length < set2.length ? set1 : set2;
        int [] bigSet = set1.length < set2.length ? set2 : set1;
        int size = 0;

        for (int i = 0; i < smallSet.length; i++) {
            if (contains(bigSet, smallSet[i])){
                arr[size] = smallSet[i];
                size++;
            }
        }

        int [] res = new int [size];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // Question 5, Expansion 6
    public static int [] diffSets(int[] set1, int[] set2) { // {1,2,3,4} {1,2,5} 
        int [] arr = new int [set1.length];                 // {0,0,0,0}
        int size = 0;                                       
     
        for (int i = 0; i < set1.length; i++) {
            if (!contains(set2, set1[i])){
                arr[size] = set1[i];
                size++;
            }
        }          
        int [] res = new int [size]; // arr: {3,4,0,0} , res: {0,0}
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i]; // copy solution from arr to res. 
        }
        return res; // {3,4}
    }
    
    // Question 5, Expansion 7
    public static int [] symDiffSets(int[] set1, int[] set2) {
        int [] diff12 = diffSets(set1,set2);
        int [] diff21 = diffSets(set2,set1);
        return unionSets(diff12,diff21);
    }
    
}
