/**
* Description:
*
*In order to win the prize for most cookies sold, my friend Alice and I are going to merge our Girl Scout Cookies orders and enter as one unit.
*
* Each order is represented by an "order id" (an integer).
*
* We have our lists of orders sorted numerically already, in arrays. Write a method to merge our arrays of orders into one sorted array.
*
* For example:

* int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
* int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};
*
* System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
* // prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
*
*/
package arrays;


import java.util.Arrays;

public class MergeLists {

    public static void main(String []args){

        int []list1 = new int[]{1,2};
        int []list2 = new int []{-1,4,5,6};

        System.out.println(Arrays.toString(mergelists(list1, list2)));
    }

    public static int[] mergelists(int []a, int []b){

        int i = 0; //  for a
        int j = 0; //  for b
        int k = 0; //  for c
        int []c = new int[a.length + b.length]; // length : 8
        while (i < a.length && j < b.length){

            if (a[i] <= b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length) {
            c[k++] = a[i];
            i++;
        }

        while (j < b.length) {
            c[k++] = b[j];
            j++;
        }

        return c;

    }



}
