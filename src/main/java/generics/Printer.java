package generics;

public class Printer<T> { //这个<> 里面可以填任何东西，方便起见写 T

    T thingToPrint;

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }

}
