package com.jessie.m1;

import java.util.ArrayList;
import java.util.List;

public class MockObejct {
    public static UsingMockObject staticMethod(String args) {
        List<String> list = new ArrayList<>();

        return new UsingMockObject();
    }

    public UsingMockObject notStaticMethod(){
        return new UsingMockObject();
    }

}
