package com.jessie.test;

import jessie.com.SendEmailClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SendEmailClass.class, Session.class, Transport.class})
public class SendEmailClassTest {

    @Test
    public void testSendEmail() throws Exception {
        //Arrange
        String to = "sonoojaiswal1988@gmail.com";//change accordingly
        String from = "sonoojaiswal1987@gmail.com"; //change accordingly
        Properties properties = mock(Properties.class);
        whenNew(Properties.class).withNoArguments().thenReturn(properties);
        when(properties.getProperty(anyString())).thenReturn("Testtttt");
        Session session = mock(Session.class);
        mockStatic(Session.class);
        when(Session.getDefaultInstance(any())).thenReturn(session);
        MimeMessage message = mock(MimeMessage.class);
        whenNew(MimeMessage.class).withAnyArguments().thenReturn(message);
        InternetAddress internetAddress = mock(InternetAddress.class);
        whenNew(InternetAddress.class).withAnyArguments().thenReturn(internetAddress);
        mockStatic(Transport.class);

        //Act
        SendEmailClass.sendEmail(to, from);

        //Assert
        PowerMockito.verifyStatic(Transport.class, times(1));

        Transport.send(any());
    }
}
