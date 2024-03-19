import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final char[] VOWELS = {'a','e','i','o','u'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        CrackerRunnable.password = sc.nextLine();
        int thrdCount = 1;
        ArrayList<Thread> checkerThreads = new ArrayList<>();
        for(int i = 0; i< CrackerRunnable.password.length(); i++){
            for(int j=0; j<5; j++){
                CrackerRunnable c = new CrackerRunnable(VOWELS[j],i);
                Thread t = new Thread(c);
                if(thrdCount > 9){
                    t.setName("Thread "+ thrdCount);
                } else {
                    t.setName("Thread 0"+ thrdCount);
                }
                thrdCount++;
                checkerThreads.add(t);
                t.start();
            }
        }
        for( Thread t : checkerThreads){
            try {
                t.join();
            } catch (InterruptedException e) {}
        }
    }

}
