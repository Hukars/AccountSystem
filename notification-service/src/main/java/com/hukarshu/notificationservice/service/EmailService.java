package com.hukarshu.notificationservice.service;



import com.hukarshu.notificationservice.domain.NotificationType;
import com.hukarshu.notificationservice.domain.Recipient;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {

	void send(NotificationType type, Recipient recipient, String attachment) throws MessagingException, IOException;

}
