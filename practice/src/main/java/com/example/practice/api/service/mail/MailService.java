package com.example.practice.api.service.mail;

import com.example.practice.client.mail.MailSendClient;
import com.example.practice.domain.history.mail.MailSendHistory;
import com.example.practice.domain.history.mail.MailSendHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final MailSendClient mailSendClient;
    private final MailSendHistoryRepository mailSendHistoryRepository;

    public boolean sendMail(String fromEmail, String toEmail, String subject, String content) {
        // 실제 메일 전송 로직은 생략

        boolean result = mailSendClient.sendEmail(fromEmail, toEmail, subject, content);
        if (result) {
            // 메일 전송 이력 저장
            mailSendHistoryRepository.save(MailSendHistory.builder()
                .content(content)
                .fromEmail(fromEmail)
                .subject(subject)
                .toEmail(toEmail)
                .build());

            return true;
        }

        return false;
    }
}
