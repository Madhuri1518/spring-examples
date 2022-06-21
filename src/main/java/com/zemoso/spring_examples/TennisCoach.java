package com.zemoso.spring_examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("coachTe")
@Scope("prototype")
public class TennisCoach implements Coach{

    // Field injection
    @Autowired
    @Qualifier("randomFortuneService")
    FortuneService fortuneService;

    // Constructor injection
//    @Autowired
//    TennisCoach(FortuneService fortuneService){
//        this.fortuneService=fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Tennis coach: daily workout";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // Setter injection
//    @Autowired
    public void setFortuneService(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

//    @Autowired
//    @Qualifier("randomFortuneService")
    public void methodInjector(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

//    // add an init method
//    @PostConstruct
//    public void doMyStartupStuff() {
//        System.out.println("======TennisCoach: inside method doMyStartupStuff");
//    }
//
//    // add a destroy method
//    @PreDestroy
//    public void doMyCleanupStuffYoYo() {
//        System.out.println("=======TennisCoach: inside method doMyCleanupStuffYoYo");
//    }

}
