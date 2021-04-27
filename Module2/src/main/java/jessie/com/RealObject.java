package jessie.com;

import com.jessie.m1.MockObejct;
import com.jessie.m1.UsingMockObject;

public class RealObject {
    private static UsingMockObject obj;
    UsingMockObject mockObject;
    public static void main(String args) {
        obj = MockObejct.staticMethod(args);
        boolean shouldDo = true;

        System.out.println("false".equalsIgnoreCase("true"));
    }

    public RealObject(){
        mockObject = new UsingMockObject();
    }
    public int method(int sum1, int sum2){
        return sum1+sum2;
    }

    public void createUsingMockObject(boolean create){
        if (create){
            int result = mockObject.method(1);
            System.out.println("I'm creating " + result);
        } else {
            System.out.println("Not creating mock object");
        }


    }
}
