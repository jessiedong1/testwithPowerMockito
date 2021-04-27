package com.jessie.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;

import com.jessie.m1.MockObejct;
import com.jessie.m1.UsingMockObject;
import jessie.com.RealObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({RealObject.class, MockObejct.class})
public class RealObjectTest {

    @Mock
    UsingMockObject uObj;

    @InjectMocks
    RealObject realObject;

    @Test
    public void testCreateUsingMockObject(){
        //Arrange
        Mockito.when(uObj.method(anyInt())).thenReturn(111);

        //Act
        realObject.createUsingMockObject(true);

        //Assert
//        Mockito.verifyZeroInteractions(uObj);
        Mockito.verify(uObj).method(anyInt());
    }


    @Test
    public void testMethod(){
        RealObject obj = new RealObject();
        assertEquals(obj.method(1,2),3);
    }

    @Test
    public void testMain(){
        PowerMockito.mockStatic(MockObejct.class);
        PowerMockito.when(MockObejct.staticMethod(anyString())).thenReturn(uObj);
        RealObject.main(anyString());
        RealObject.main(anyString());
        PowerMockito.verifyZeroInteractions(uObj);
    }
}
