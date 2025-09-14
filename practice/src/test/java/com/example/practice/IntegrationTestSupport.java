package com.example.practice;

import com.example.practice.client.mail.MailSendClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@ActiveProfiles("test")
@SpringBootTest
public abstract class IntegrationTestSupport {


    @MockitoBean
    private MailSendClient mailSendClient;
}
