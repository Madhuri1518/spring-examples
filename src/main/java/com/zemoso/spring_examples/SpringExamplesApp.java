package com.zemoso.spring_examples;

import com.zemoso.spring_examples.config.BeanConfig;
import com.zemoso.spring_examples.config.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExamplesApp {
    public static void main(String args[]){

        //========XML configuration===========
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlConfiguration.xml");
        Coach coach = context.getBean("coach", Coach.class);

        System.out.println("coach -"+coach.getDailyWorkout());
        //========Constructor injection===========
        System.out.println("fortune -"+coach.getDailyFortune());


        //========Scope ==========
        //=====Singleton
        Coach theCoach = context.getBean("coach", Coach.class);
        Coach alphaCoach = context.getBean("coach", Coach.class);
        // check if they are the same
        boolean result = (theCoach == alphaCoach);
        // print out the results
        System.out.println("Singleton\nPointing to the same object: " + result);
        System.out.println("Memory location for theCoach: " + theCoach);
        System.out.println("Memory location for alphaCoach: " + alphaCoach + "\n");

        //====Prototype
        Coach theCoach1 = context.getBean("scopedBeanCoach", Coach.class);
        Coach alphaCoach1 = context.getBean("scopedBeanCoach", Coach.class);
        // check if they are the same
        boolean result1 = (theCoach1 == alphaCoach1);
        // print out the results
        System.out.println("Prototype\nPointing to the same object: " + result1);
        System.out.println("Memory location for theCoach: " + theCoach1);
        System.out.println("Memory location for alphaCoach: " + alphaCoach1 + "\n");
        System.out.println(theCoach1.getDailyWorkout());
        System.out.println(alphaCoach1.getDailyWorkout());

//        //==========life cycle methods
//        Coach lifeCycleCoach = context.getBean("lifeCycleCoach", Coach.class);
        context.close();

        //============Component scanning
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("annotationConfiguration.xml");

        Coach tennisCoach = context1.getBean("coachTe", Coach.class);
        System.out.println("component scan coach -"+tennisCoach.getDailyWorkout());
        //==========annotation - field/constructor/setter/method injection
        System.out.println("annotation config coach(field injection) -"+tennisCoach.getDailyFortune());

        //===========scope using annotation
        System.out.println("\nMemory location for first ref: " + tennisCoach);
        tennisCoach = context1.getBean("coachTe", Coach.class);
        System.out.println("\nMemory location for first ref: " + tennisCoach);

        context1.close();
        //===========no xml
        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(SportConfig.class);
        Coach tennisCoach2 = context2.getBean("coachTe", Coach.class);
        System.out.println("no xml scan coach -"+tennisCoach2.getDailyWorkout());

        context2 = new AnnotationConfigApplicationContext(BeanConfig.class);
        Coach baseballCoach = context2.getBean("baseballCoachBean", Coach.class);
        System.out.println("bean annotation -"+baseballCoach.getDailyWorkout());

        //==========properties
        BaseballCoach baseballCoach1 = context2.getBean("baseballCoachBean", BaseballCoach.class);
        System.out.println("properties email: "+ baseballCoach1.getEmail());
        System.out.println("properties team: "+ baseballCoach1.getTeam());
        context2.close();
    }
}
