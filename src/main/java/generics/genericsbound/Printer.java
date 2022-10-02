package generics.genericsbound;

public class Printer<T extends Animal> { //给一个范围 必须是动物的子类

    T thingToPrint;

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }

}
