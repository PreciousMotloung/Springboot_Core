package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;

    // define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach anotherCoach)
    {
        System.out.println("In constructor" + getClass().getName());
        this.myCoach = theCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkouts()
    {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check()
    {
        return "comparing beans: myCoach = anotherCoach, "+(myCoach == anotherCoach);
    }
}
