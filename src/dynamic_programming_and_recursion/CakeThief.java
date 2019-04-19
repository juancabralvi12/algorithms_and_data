package dynamic_programming_and_recursion;

public class CakeThief {



public static class CakeType {

  int weight;
  int value;

  public CakeType(int weight, int value) {
    this.weight = weight;
    this.value  = value;
  }
}




  public static long maxDuffelBagValue(CakeType []cakeTypes, int capacity){



    long maxDuffelBagValue = 0;
    boolean stillProfitToCarry = true;


    //inside the for loop
    CakeType taken = new CakeType(0,0);


    while (capacity > 0 && stillProfitToCarry) {
      long currentMaximumProfit = 0;
      long currentCapacity = 0;
      long currentRealCapacity = 0;


      stillProfitToCarry = false;
      for (CakeType cakeType : cakeTypes) {
        long capacityPerWeight = capacity / cakeType.weight;
        long maximumProfit = capacityPerWeight * cakeType.value;
        long realCapacity = capacityPerWeight * cakeType.value;

        if (maximumProfit > currentMaximumProfit) {

          stillProfitToCarry = true;
          currentMaximumProfit = maximumProfit;
          currentCapacity = capacityPerWeight * cakeType.weight;
          currentRealCapacity = realCapacity;
          taken = cakeType;
        }

      }

      if (currentRealCapacity > 0 && currentCapacity>0)
        System.out.println(String.format("Taking %s pieces of value %s", currentCapacity / taken.weight, taken.value));

      taken.weight -= currentCapacity;
      maxDuffelBagValue += currentRealCapacity;
      capacity -= currentCapacity;

    }

    return  maxDuffelBagValue;

  }

  public static class InfinityException extends RuntimeException {
    public InfinityException() {
      super("Max value is infinity!");
    }
  }

  public static long maxDuffelBagValueBook(CakeType[] cakeTypes, int weightCapacity) {

    // we make an array to hold the maximum possible value at every
    // duffel bag weight capacity from 0 to weightCapacity
    // starting each index with value 0
    long[] maxValuesAtCapacities = new long[weightCapacity + 1];

    for (int currentCapacity = 0; currentCapacity <= weightCapacity; currentCapacity++) {

      // set a variable to hold the max monetary value so far for currentCapacity
      long currentMaxValue = 0;

      for (CakeType cakeType : cakeTypes) {

        // if a cake weighs 0 and has a positive value the value of our duffel bag is infinite!
        if (cakeType.weight == 0 && cakeType.value != 0) {
          throw new InfinityException();
        }

        // if the current cake weighs as much or less than the current weight capacity
        // it's possible taking the cake would get a better value
        if (cakeType.weight <= currentCapacity) {

          // so we check: should we use the cake or not?
          // if we use the cake, the most kilograms we can include in addition to the cake
          // we're adding is the current capacity minus the cake's weight. we find the max
          // value at that integer capacity in our array maxValuesAtCapacities
          long valueAtMaxCapacities = maxValuesAtCapacities[currentCapacity - cakeType.weight];

          long maxValueUsingCake = cakeType.value + valueAtMaxCapacities;

          // now we see if it's worth taking the cake. how does the
          // value with the cake compare to the currentMaxValue?
          currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);
        }
      }

      // add each capacity's max value to our array so we can use them
      // when calculating all the remaining capacities
      maxValuesAtCapacities[currentCapacity] = currentMaxValue;
    }

    return maxValuesAtCapacities[weightCapacity];
  }

  public static void main(String []args){

    //test case 1

    /*
    *     new CakeType(7, 160),
      new CakeType(3, 90),
      new CakeType(2, 15),
    *
    * */

    int capacity = 8;

    CakeType[] cakeTypes = new CakeType[] {
      new CakeType(3, 40),
    new CakeType(5, 70)
    };



    CakeType[] cakeTypes2 = new CakeType[] {
      new CakeType(3, 40),
      new CakeType(5, 70)
    };

    long start = System.currentTimeMillis();
    System.out.println(maxDuffelBagValue(cakeTypes, capacity));
    long end = System.currentTimeMillis();

    System.out.println("Juan's solution : " + (end - start));


    start = System.currentTimeMillis();
    System.out.println(maxDuffelBagValueBook(cakeTypes2, capacity));
    end = System.currentTimeMillis();


    System.out.println("Cake's solution : " + (end - start));


  }


}

