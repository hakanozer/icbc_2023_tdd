package utils;

public class Action extends Thread{

    String path = "";
    public Action(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        System.out.println("start :" + this.path);
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                System.out.println("send.. :" + this.path);
                //int j = 1 / 0;
            }
        }catch (Exception ex) {
            //throw new RuntimeException();
            System.err.println("Thread Error : " + ex);
        }
        System.out.println("end :" + this.path);
    }
}
