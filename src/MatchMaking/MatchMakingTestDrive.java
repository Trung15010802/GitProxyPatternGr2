package MatchMaking;

import java.lang.reflect.Proxy;

public class MatchMakingTestDrive {
    // instance variables here

    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    public MatchMakingTestDrive() {
    }

    public void drive() {
        System.out.println("Onwer proxy");
        Person joe = new PersonImpl("Joe Javabean");
        Person ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is " + ownerProxy.getName());
        System.out.println("Setting interests: bowling, Go");
        ownerProxy.setInterests("bowling, Go");
        System.out.println("Interests are set from owner proxy: "+ownerProxy.getInterests());
        System.out.println("Setting rating: 10");
        try {
            ownerProxy.setGeekRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getGeekRating());

        System.out.println();

        System.out.println("Nonowner proxy");
        Person nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("Name is " + nonOwnerProxy.getName());
        System.out.println("Setting interests: bowling, Go");
        try {
            nonOwnerProxy.setInterests("racing, Go");
        } catch (Exception e) {
            System.out.println("Can't set interests from non owner proxy");
        }
        System.out.println("Setting rating: 3");
        nonOwnerProxy.setGeekRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + nonOwnerProxy.getGeekRating());
    }

    Person getOwnerProxy(Person person) {

        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    Person getNonOwnerProxy(Person person) {

        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person));
    }
}