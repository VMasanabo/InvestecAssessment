import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class NumberCalculator {
    public int highestCommonFactor(int[] numbers) {
       Arrays.sort(numbers);
       int smallestNumber = numbers[0];
       int highestCommonFactor=0;

       //Get factors for all number's in array
        ArrayList<Integer> arrayCommonFactors = new ArrayList();
        for(int x=0;x<numbers.length;x++){
            for(int i=1;i<=smallestNumber;i++){
                if(numbers[x]%i==0){
                    arrayCommonFactors.add(i);
                }
            }

        }
        Collections.sort(arrayCommonFactors);
        // 1. All common factors must be less or equal to the smallest number on the array
        // 2. A number is the highest common factor if it is divisible by all number on the array
        //  2.1 Hence we created a counter , that needs to equal the array
        //      2.1.1 Meaning that number is divisible by all number in the array.
        for(int commonFactor:arrayCommonFactors){
            int count =0;
            for(int number:numbers){
                if(number%commonFactor==0){
                    count++;
                    if(count == numbers.length){
                        highestCommonFactor = commonFactor;
                    }
                }
            }
        }
      return highestCommonFactor;
    }

}
