package com.jessie.m1.test;

import static org.junit.Assert.assertEquals;

import com.jessie.m1.UsingMockObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsingMockObjectTest {
    @InjectMocks
    UsingMockObject obj;

    @Test
    public void testMethod(){
        assertEquals(obj.method(1),1);
    }
}
