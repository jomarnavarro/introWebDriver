package fBatchRun;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelRun {

    static List<String> listTC = new ArrayList<>(Arrays.asList(
            "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister",
            "TestLogin", "TestRegister", "TestLogin",
            "TestRegister", "TestLogin", "TestRegister"
    ));

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String packageName = "fBatchRun";
        long timeStart = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(12);

        for (int i = 0; i < listTC.size(); i++) {
            es.submit(
                    TestCase.createTest(
                            String.format("%s.%s", packageName, listTC.get(i)
                            )
                    )
            );
        }
        try {
            es.shutdown();
            es.awaitTermination(120, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        long timeEnd = System.currentTimeMillis();

        System.out.println("Time to execute: " + listTC.size() +
                " testcases: " + (timeEnd - timeStart) / 1000 + " seconds.");
    }
}
//        old manual thread scheduler.
//        int i = 0;
//        Thread[] workers = new Thread[12];
//        while(i < listTC.size()) {
//            //assign threads
//            for(int j = 0; j < workers.length; j++) {
//                if(i < listTC.size() && (workers[j] == null || !workers[j].isAlive() )) {
//                    workers[j] = new Thread(TestCase.createTest(packageName+"."+listTC.get(i)));
//                    workers[j].start();
//                    i++;
//                }
//            }
//            for(int k = 0; k < workers.length; k++) {
//                System.out.println("workers["+ k+"]: " + workers[k].isAlive());
//            }
//            TestCase.sleep(2000);
//        }
//        for( i = 0; i < workers.length; i++) {
//            workers[i].join();
//        }

