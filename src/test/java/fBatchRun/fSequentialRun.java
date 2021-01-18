package fBatchRun;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class fSequentialRun {

    static List<String> testCases;
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        //trying test cases by name
        TestCase x = new TestRegister();
        x.run();
        x = new TestLogin();
        x.run();

        //adding test case names to list
        testCases = new ArrayList<>();
        testCases.add("fBatchRun.TestRegister");
        testCases.add("fBatchRun.TestLogin");

        //Instantiationg test case by test case and running it.
        for(String tc: testCases) {
            TestCase y = TestCase.createTest(tc);
            y.run();
        }
    }
}
