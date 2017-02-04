/** Statistics Library
 * Stats.java
 * Purpose: This library contains a variety of formulas useful for statistical calculations.
 * I am mainly using it to implement my statistical knowledge from class.
 *
 * @author Joseph Numainville
 * @version 0.1 1/23/2017
 */

import java.util.*;
public class Stats {
    public Stats () {
        
    }
    
    /**
    * Finds the maximum of an array.
    *
    * @param a The array containing the data.
    * @return double The maximum value of the array.
    */
    public static double max(double[] a) {
        double max = Double.MIN_VALUE;
        for (double e : a) {
            if (e > max) {
                max = e;
            }
        }
        return max;
    }
    
    /**
    * Finds the minimum of an array.
    * 
    * @param a The array containing the data. 
    * @return double The minimum value of the array.
    */
    public static double min(double[] a) {
        double min = Double.MAX_VALUE;
        for (double e : a) {
            if (e < min) {
                min = e;
            }
        }
        return min;
    }
    
    /**
     * Finds the min and max and combines them into one array.
     * 
     * @param a The array containing the data.
     * @return double[] The min and max of the data, in that order.
     */
    public static double[] minMax(double[] a) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double e : a) {
            if (e > max) {
                max = e;
            }
            if (e < min) {
                min = e;
            }
        }
        double[] arr = {min, max};
        return arr;
    }
    
    /**
    * Finds the range of an unsorted array.
    * 
    * @param a The array containing the data.
    * @return double The range of the data.
    */
    public static double range(double[] a) {
        double[] minMax = minMax(a);
        return minMax[1] - minMax[0];
    }
    
    /**
    * Finds the mean or average of an array.
    * 
    * @param a The array containing the data.
    * @return double The mean or average of the data.
    */
    public static double mean(double[] a) {
        double total = sum(a);
        return total / a.length;
    }
    
    /**
    * Finds the sum of all values in an array.
    * 
    * @param a The array containing the data.
    * @return double The sum of the values in the array.
    */
    public static double sum(double[] a) {
        double total = 0;
        for (double e : a) {
            total += e;
        }
        return total;
    }
    
    /**
    * Finds the variance of an array of a population.
    * 
    * @param a The array containing the data.
    * @return double The variance of the population.
    */
    public static double variancePop(double[] a) {
        double mean = mean(a);
        double total = 0;
        for (double e : a) {
            total += Math.pow(mean - e,2);
        }
        return total / a.length;
    }
    
    /**
    * Finds the variance of an array of a sample.
    * 
    * @param a The array containing the data.
    * @return double the variance of the sample.
    */
    public static double varianceSample(double[] a) {
        double mean = mean(a);
        double total = 0;
        for (double e : a) {
            total += Math.pow(mean - e,2);
        }
        return total / (a.length - 1);
    }
    
    /**
    * Finds the standard deviation of a population.
    * 
    * @param a The array containing the data.
    * @return double The standard deviation of the population.
    */
    public static double standDevPop(double[] a) {
        return Math.sqrt(variancePop(a));
    }
    
    /**
    * Finds the standard deviation of a sample.
    * 
    * @param a The array containing the data.
    * @return double The standard deviation of the sample.
    */
    public static double standDevSample(double[] a) {
        return Math.sqrt(varianceSample(a));
    }
    
    /**
    * Finds the median of a data set given an unsorted array.
    * 
    * @param a The array containing the data.
    * @return double The median of the array.
    */
    public static double median(double[] a) {
        Arrays.sort(a);
        return medianSorted(a);
    }
    
    /**
     * Finds the median of a data set given a sorted array.
     * 
     * @param a The array containing the data.
     * @return double The median of the array.
     */
    public static double medianSorted(double[] a) {
        try {
            if(a.length % 2 == 1) {
                return a[(int) a.length / 2];
            }
            else {
                return (a[(int) a.length / 2] + a[(int) (a.length / 2 - 1)]) / 2;
            }
        }
        catch(IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds.");
        }
        catch(NullPointerException e) {
            System.err.println("Null value in array.");
        }
        return 0;
    }
    
    /**
     * Finds the first quartile of the data.
     * 
     * @param a The array containing the data.
     * @return double The first quartile of the data.
     */
    public static double quart1(double[] a) {
        try {
            a = Arrays.copyOfRange(a, 0, (int) (a.length / 2));
            return medianSorted(a);
        }
        catch(IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds.");
        }
        return 0;
    }
    
    /**
     * Finds the third quartile of the data
     * 
     * @param a The array containing the data.
     * @return double The third quartile of the data.
     */
    public static double quart3(double[] a) {
        try {
            if (a.length % 2 == 0) {
                a = Arrays.copyOfRange(a, (int) (a.length / 2), a.length);
                return medianSorted(a);
            }
            else {
                a = Arrays.copyOfRange(a, (int) (a.length / 2 + 1), a.length);
                return medianSorted(a);
            }
        }
        catch(IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds.");
        }
        return 0;
    }
    
    /**
     * Finds the five number summary of a dataset, which includes the min, q1, median,
     * q3, and max.
     * 
     * @param a The array containing the data.
     * @return double[] Double[] containing the min, q1, median, q3, max, in that order.
     */
    public static double[] summary(double[] a) {
        Arrays.sort(a);
        double[] minMax = minMax(a);
        double q1 = quart1(a);
        double median = medianSorted(a);
        double q3 = quart3(a);
        double[] arr = {minMax[0], q1, median, q3, minMax[1]};
        return arr;
    }
    
    /**
     * Prints the five number summary of the data.
     * 
     * @param a The array containing the data.
     */
    public static void printSummary(double[] a) {
    	a = summary(a);
    	System.out.println("Min: " + a[0] + " Quartile 1: " + a[1]
    			+ " Median: " + a[2] + " Quartile 3: " + a[3] + " Max: " + a[4]);
    }
    
    /**
     * Finds the interquartile range of the data.
     * 
     * @param a The array containing the data.
     * @return double The interquartile range of the data.
     */
    public static double intQuartRange(double[] a) {
    	Arrays.sort(a);
    	return (quart3(a) - quart1(a));
    }
    
}

