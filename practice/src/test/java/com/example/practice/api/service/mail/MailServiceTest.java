package com.example.practice.api.service.mail;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;

import com.example.practice.client.mail.MailSendClient;
import com.example.practice.domain.history.mail.MailSendHistory;
import com.example.practice.domain.history.mail.MailSendHistoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MailServiceTest {

    @Spy
    private MailSendClient mailSendClient;

    @Mock
    private MailSendHistoryRepository mailSendHistoryRepository;

    @InjectMocks
    private MailService mailService;

    @DisplayName("메일 전송 테스트")
    @Test
    void sendMail() {
        // given
        doReturn(true)
            .when(mailSendClient)
            .sendEmail(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
                Mockito.anyString());

        // when
        boolean result = mailService.sendMail("", "", "", "");

        // then
        Assertions.assertThat(result).isTrue();
        Mockito.verify(mailSendHistoryRepository, times(1))
            .save(Mockito.any(MailSendHistory.class));
    }
}