package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("in constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 100 meters as a warm up";
    }
}
