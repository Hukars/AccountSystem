package com.hukarshu.notificationservice.repository;


import com.hukarshu.notificationservice.domain.Recipient;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipientRepository extends CrudRepository<Recipient, String> {

	Recipient findByAccountName(String name);

	@Query("{ $and: [ {'scheduledNotifications.UPDATE.active': true }, { $where: 'this.scheduledNotifications.UPDATE.lastNotified < " +
			"new Date(new Date().setDate(new Date().getDate() - this.scheduledNotifications.UPDATE.frequency ))' }] }")
	List<Recipient> findReadyForUpdate();

	@Query("{ $and: [ {'scheduledNotifications.REMIND.active': true }, { $where: 'this.scheduledNotifications.REMIND.lastNotified < " +
			"new Date(new Date().setDate(new Date().getDate() - this.scheduledNotifications.REMIND.frequency ))' }] }")
	List<Recipient> findReadyForRemind();

}
