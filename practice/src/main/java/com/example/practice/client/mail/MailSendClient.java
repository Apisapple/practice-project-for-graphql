package com.example.practice.client.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MailSendClient {

    public boolean sendEmail(String fromEmail, String toEmail, String subject, String content) {
        // 메일 전송 로직은 생략
        log.info("메일 전송 완료: {} {} {} {}", fromEmail, toEmail, subject, content);

        return true;
    }
}
