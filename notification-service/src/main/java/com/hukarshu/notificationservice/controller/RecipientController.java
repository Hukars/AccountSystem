package com.hukarshu.notificationservice.controller;

import com.hukarshu.notificationservice.domain.Recipient;
import com.hukarshu.notificationservice.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * @Auther: hunan
 * @Date: 02/05/2019 15:04
 * @Description:
 */
@RestController
@RequestMapping("/recipients")
public class RecipientController {

    @Autowired
    private RecipientService recipientService;

    @GetMapping("/current")
    public Object getCurrentNotificationsSettings(Principal principal) {
        return recipientService.findByAccountName(principal.getName());
    }

    @PutMapping("/current")
    public Object saveCurrentNotificationsSettings(Principal principal, @Valid @RequestBody Recipient recipient) {
        return recipientService.save(principal.getName(), recipient);
    }

}
