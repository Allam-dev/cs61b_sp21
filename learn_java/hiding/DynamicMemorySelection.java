public class DynamicMemorySelection {
    public static void main(String[] args) {
        Object b1 = new BMW();
        Car c1 = (Car) b1;
        ((Car) b1).move();
        ((BMW) b1).move();
        c1.move();
        ((BMW) b1).printCC();


    }
}
