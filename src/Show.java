public class Show {
    public void show() {
        System.out.println("Hello world");
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Hello start");
        Show m = new Show();
        m.show();
        System.out.println("Hello end");
    }
}