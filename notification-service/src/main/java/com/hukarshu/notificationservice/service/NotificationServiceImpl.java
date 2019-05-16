package com.hukarshu.notificationservice.service;

import com.hukarshu.notificationservice.client.AccountFeignClient;
import com.hukarshu.notificationservice.domain.NotificationType;
import com.hukarshu.notificationservice.domain.Recipient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class NotificationServiceImpl implements NotificationService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private RecipientService recipientService;

	@Autowired
	private EmailService emailService;

	@Override
	@Scheduled(cron = "${update.cron}")
	public void sendUpdateNotifications(){
		final NotificationType type = NotificationType.UPDATE;

		List<Recipient> recipients = recipientService.findReadyToNotify(type);
		log.info("found {} recipients for update notification", recipients.size());

		recipients.forEach(recipient -> CompletableFuture.runAsync(() -> {
			try {
				String attachment = "";
				emailService.send(type, recipient, attachment);
				recipientService.markNotified(type, recipient);
			} catch (Throwable t) {
				log.error("an error during update notification for {}", recipient, t);
			}
		}));
	}

	@Override
	@Scheduled(cron = "${remind.cron}")
	public void sendRemindNotifications() {

		final NotificationType type = NotificationType.REMIND;

		List<Recipient> recipients = recipientService.findReadyToNotify(type);
		log.info("found {} recipients for remind notification", recipients.size());

		recipients.forEach(recipient -> CompletableFuture.runAsync(() -> {
			try {
				emailService.send(type, recipient, null);
				recipientService.markNotified(type, recipient);
			} catch (Throwable t) {
				log.error("an error during remind notification for {}", recipient, t);
			}
		}));
	}
}
