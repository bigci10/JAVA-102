import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        MyList myList = new MyList<>();

        myList.add(5);
        myList.add("One");
        myList.add(6.5);
        myList.add("FB");

        System.out.println(myList.size());
        System.out.println(myList.getCapacity());
        System.out.println(myList.toString());
        System.out.println(myList.isEmpty());

        System.out.println(myList.subList(0,2));
        System.out.println(myList.lastIndexOf("FB"));
        System.out.println(myList.get(0));
        System.out.println(myList.indexOf("One"));
        System.out.println(myList.toArray());
        System.out.println(myList.set(0,"Two"));
        myList.clear();







    }


}
