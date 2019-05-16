package com.hukarshu.notificationservice.domain;

public enum NotificationType {

	UPDATE("update.email.subject","update.email.text","update.email.attachment"),
	REMIND("remind.email.subject", "remind.email.text", null);


	private String subject;
	private String text;
	private String attachment;

	NotificationType(String subject, String text, String attachment) {
		this.subject = subject;
		this.text = text;
		this.attachment = attachment;
	}

	public String getSubject() {
		return subject;
	}

	public String getText() {
		return text;
	}

	public String getAttachment() {
		return attachment;
	}
}
