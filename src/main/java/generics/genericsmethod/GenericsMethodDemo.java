package generics.genericsmethod;

import generics.genericsbound.Animal;
import generics.genericsbound.Cat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericsMethodDemo {

    //one parameter with generics
    private static <T> void shout(T thingsToShout) {
        System.out.println(thingsToShout + " !!!!!");
    }

    //double parameter with generics
    private static <T, V> void doubleShout(T first, V second) {
        System.out.println(first + "|" + second);
    }

    //double parameter with generics and return type
    private static <T, V> T doubleShoutWithReturn(T first, V second) {
        System.out.println(first + "|" + second);
        return first;
    }

    //当一个List是方法的参数时，你不知道这个参数会放入哪些类型的List
    //因此你需要使用 List<?> 来指定泛型，也可以extends来指定
    private static void wildCardPrint(List<?> myList) {
        System.out.println(myList);
    }

    //extends 来规划范围
    private static void wildCardPrintWithBound(List<? extends Animal> myList) {
        System.out.println(myList);
    }

    @Test
    void testGenericsMethod() {
        shout(22222);
        shout(new Cat());

        doubleShout("?", 256);

    }

    @Test
    void testWildCard() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(3568);
        wildCardPrint(integerList);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        wildCardPrint(catList);

        List<Cat> catList1 = new ArrayList<>();
        catList1.add(new Cat());
        wildCardPrintWithBound(catList1);

        //这个是错误的因为限定了只能接受extends Animal的List
        //wildCardPrintWithBound(integerList);

    }

}
