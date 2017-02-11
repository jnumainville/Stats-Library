/**
 * Statistics Library
 * Stats.java
 * Purpose: This library contains a variety of formulas useful for statistical calculations.
 *
 * @author Joseph Numainville
 * @version 0.1 1/23/2017
 */
    /**
    * Finds the max of an unsorted array.
    */
public class Stats {
    public Stats {
        
    }
    
    /**
    * Finds the maximum of an unsorted array.
    *
    * @param a
    */
    public static double max(double[] a) {
        double max = Double.MIN_VALUE;
        for (double e : a) {
            if (e > max) {
                max = e;
            }
        }
    }
    
    /**
    * Finds the minimum of an unsorted array.
    */
    public static double min(double[] a) {
        double min = Double.MAX_VALUE;
        for (double e : a) {
            if (e < min) {
                min = e;
            }
        }
    }
    
    public static double[] minMax(double[] a) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double e : a) {
            if (e > max) {
                max = e;
            }
            else if (e < min) {
                min = e;
            }
        }
        return {min, max};
    }
    
    /**
    * Finds the range of an unsorted array.
    */
    public static double range(double[] a) {
        double[] minMax = minMax(a);
        return minMax[1] - minMax[0];
    }
    
    /**
    * /**
    * Finds the mean or average of an array.
    */
    */
    public static double mean(double[] a) {
        double total = sum(a);
        return total / n.length;
    }
    
    /**
    * Finds the sum of all values in an array.
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
    */
    public static double standDevPop(double[] a) {
        return Math.sqrt(variancePop(a));
    }
    
    /**
    * Finds the standard deviation of a sample.
    */
    public static double standDevSample(double[] a) {
        return Math.sqrt(varianceSample(a));
    }
    
    /**
    * 
    *
    */
    public static double median(double[] a) {
        Arrays.sort(a);
        return medianSorted(a);
    }
    
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
            System.err.println("Null value in array.")
        }
        
    }
    
    public static double quart1(double[] a) {
        try {
            a = Arrays.copyOfRange(a, 0, (int) (a.length / 2 - 1));
            return medianSorted(a);
        }
        }
        catch(IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds.");
        }
    }
    
    public static double quart3(double[] a) {
        try {
            if (a.length % 2 == 0) {
                a = Arrays.copyOfRange(a, (int) (a.length / 2), a.length - 1);
            }
            else {
                a = Arrays.copyOfRange(a, (int) (a.length / 2 + 1), a.length - 1);
            }
        }
        catch(IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds.");
        }
    }
    
    public static double[] summary(double[] a) {
        Arrays.sort(a);
        double min = a[0];
        double q1 = quart1(a);
        double median = medianSorted(a);
        double q2 = quart3(a);
        double max = a[length - 1];
    }
}