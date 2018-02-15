import java.util.Arrays;
public class Runner {

    public static void main(String args[]) {
        System.out.println(monkeyTrouble(true, true)==true);
        System.out.println(monkeyTrouble(false, false)==true);
        System.out.println(monkeyTrouble(true, false)==false);

        System.out.println(stringTimes("Hi", 3).equals("HiHiHi"));
        System.out.println(stringTimes("Oh Boy!", 2).equals("Oh Boy!Oh Boy!"));
        System.out.println(stringTimes("code", 3).equals("codecodecode"));

        System.out.println(withoutEnd("Hello").equals("ell"));
        System.out.println(withoutEnd("coding").equals("odin"));
        System.out.println(withoutEnd("Chocolate!").equals("hocolate"));

        int[] testArray = {11, 5, 9};
        int[] solutionArray = {11, 11, 11};
        System.out.println(Arrays.equals(maxEnd3(testArray),solutionArray));
        testArray = new int[] {4, 5, 1};
        solutionArray = new int[] {4, 4, 4};
        System.out.println(Arrays.equals(maxEnd3(testArray),solutionArray));
        testArray = new int[] {-5, 193, 2};
        solutionArray = new int[] {2, 2, 2};
        System.out.println(Arrays.equals(maxEnd3(testArray),solutionArray));

        System.out.println(squirrelPlay(95, false)==false);
        System.out.println(squirrelPlay(95, true)==true);
        System.out.println(squirrelPlay(105, true)==false);

        System.out.println(evenlySpaced(2, 4, 6)==true);
        System.out.println(evenlySpaced(10, 9, 11)==true);
        System.out.println(evenlySpaced(3, 6, 12)==false);

        System.out.println(bobThere("abcbob")==true);
        System.out.println(bobThere("123abcbcdbabxyz")==true);
        System.out.println(bobThere("b12b1b")==true);
        System.out.println(bobThere("bb")==false);

        System.out.println(mirrorEnds("abXYZba").equals("ab"));
        System.out.println(mirrorEnds("Hi and iH").equals("Hi "));
        System.out.println(mirrorEnds("").equals(""));

        testArray = new int[] {1, 2, 3, 4, 100};
        System.out.println(centeredAverage(testArray)==3);
        testArray = new int[] {100, 0, 5, 3, 4};
        System.out.println(centeredAverage(testArray)==4);
        testArray = new int[] {-10, -4, -2, -4, -2, 0};
        System.out.println(centeredAverage(testArray)==-3);

        solutionArray = new int[] {0, 0, 1, 0, 2, 1, 3, 2, 1};
        System.out.println(Arrays.equals(squareUp(3), solutionArray));
        solutionArray = new int[] {};
        System.out.println(Arrays.equals(squareUp(0), solutionArray));
        solutionArray = new int[] {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 1, 0, 0, 0, 3, 2, 1, 0, 0, 4, 3, 2, 1, 0, 5, 4, 3,
                2, 1, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.equals(squareUp(6), solutionArray));
    }

    public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return aSmile==bSmile;
    }

    public static String stringTimes(String str, int n) {
        String returnString = "";
        for(int i = 0; i < n; i++){
            returnString = returnString+str;
        }
        return returnString;
    }

    public static String withoutEnd(String str) {
        return str.substring(1, str.length()-1);
    }

    public static int[] maxEnd3(int[] nums) {
        int highestInt;
        if(nums[0]>nums[2]){
            highestInt = nums[0];
        }else{
            highestInt = nums[2];
        }
        for(int n = 0; n<3; n++){
            nums[n] = highestInt;
        }
        return nums;
    }

    public static boolean squirrelPlay(int temp, boolean isSummer){
        if(temp>=60){
            if(temp<=90){
                return true;
            }else if(isSummer&&temp<=100){
                return true;
            }
        }
        return false;
    }

    public static boolean evenlySpaced(int a, int b, int c){
        int maxVal = a;
        int medVal = b;
        int minVal = c;
        int sortVal;
        for(int n = 0; n<2; n++){
            if(maxVal<medVal){
                sortVal = maxVal;
                maxVal = medVal;
                medVal = sortVal;
            }
            if(medVal<minVal){
                sortVal = medVal;
                medVal = minVal;
                minVal = sortVal;
            }
        }
        if(maxVal-medVal==medVal-minVal){
            return true;
        }else{
            return false;
        }
    }

    public static boolean bobThere(String str){
        for(int n = 0; n<str.length()-2; n++){
            if(str.substring(n, n+1).equals("b")&&str.substring(n+2, n+3).equals("b")){
                return true;
            }
        }
        return false;
    }

    public static String mirrorEnds(String str){
        String ends = "";
        int strLength = str.length();
        int n = 0;
        if(strLength>0){
            while (str.substring(n, n + 1).equals(str.substring(strLength - n - 1, strLength - n)) && n < strLength - 1) {
                ends += str.substring(n, n + 1);
                n++;
            }
            if (str.substring(n).equals(str.substring(strLength - n - 1, strLength - n))) {
                ends += str.substring(n);
            }
        }
        return ends;
    }

    public static int centeredAverage(int[] nums) {
        int highestIndex = 0;
        int lowestIndex = 0;
        int numSum = 0;
        for(int n = 0; n < nums.length; n++){
            if(nums[n]>nums[highestIndex]){
                highestIndex = n;
            }
            if(nums[n]<nums[lowestIndex]){
                lowestIndex = n;
            }
            numSum+=nums[n];
        }
        numSum-=nums[highestIndex];
        numSum-=nums[lowestIndex];
        return numSum/(nums.length-2);
    }

    public static int[] squareUp(int n) {
        int row = 1;
        int[] returnArray = new int[n*n];
        int arrayIndex = 0;
        for(int i = 0; i<n; i++){
            int x;
            for(x = n; x>0; x-=1){
                if(x>row){
                    returnArray[arrayIndex] = 0;
                }else{
                    returnArray[arrayIndex] = x;
                }
                arrayIndex++;
            }
            row++;
        }
        return returnArray;
    }

}
