package main.java.base.invokeorder;

public class Build {

    /*静态块*/
    static{
        System.out.println("this is static block!");
    }

    Person p1 = new Person(1);//------------1-----------

    /*非静态块*/
    {
        System.out.println("this is non-static block!");
    }

    public Build() {
        System.out.println("this is build's block!");
        Person p2 = new Person(2);
    }

    Person p3 = new Person(3);

    public static void main(String[] args) {
        Build b = new Build();
    }

}
