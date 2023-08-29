import utils.Action;

public class AppMain {
    public static void main(String[] args) {
        Action ac1 = new Action("main1.jpg");
        ac1.start();

        Action ac2 = new Action("main2.jpg");
        ac2.start();

        Action ac3 = new Action("main3.jpg");
        ac3.start();

        Action ac4 = new Action("main4.jpg");
        ac4.start();
    }
}
