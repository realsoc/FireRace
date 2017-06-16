package com.example.realsoc.firerace;

import com.example.realsoc.firerace.model.Driver;

import java.util.Date;
import java.util.List;

/**
 * Created by realsoc on 15/06/17.
 */
// Abstracts calculus
public class Utils {
    // Calculate mean drivers' age from drivers' birthdays
    public static int getAgeFromDriverArray(List<Driver> drivers){
        int meanBirth;
        long temp = 0, now= new Date().getTime()/1000,birthday;
        for(Driver driver:drivers){
            birthday = driver.getDateOfBirth().getTime()/1000;
            temp += birthday;
            //System.out.println("Age : " +((now-birthday)/60/60/24/365));
        }
        temp /= drivers.size();
        temp = (now-temp)/60/60/24/365;
        meanBirth = (int)temp;
        return meanBirth;
    }
    // Get temporary animation duration for CounterView
    public static long getCurrentAnimationDuration(int animationDuration, int oldValue, int objective, int range, int accelerationFactor) {
        double a, b;
        if(objective == 0)
            objective = 1;
        b = animationDuration;
        // a=(max-b)/(objective*objective*objective)
        // y =ax*x*x+b (objective - b)/a = x*x*x
        a = (range*animationDuration)/Math.pow(objective,accelerationFactor);
        return (long)(a*Math.pow(oldValue,accelerationFactor)+b);
    }
}
