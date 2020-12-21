package org.itstep.components;

import org.itstep.repositories.UsersRepository;
import org.itstep.services.MailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class ScheduledMailSendingTasks {
    static final int delay = 10000;//1000 * 60 * 60 * 24 * 7; // one message per week

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    private final MailSenderService mailSenderService;
    private final UsersRepository usersRepos;

    public ScheduledMailSendingTasks(MailSenderService mailSenderService, UsersRepository usersRepos) {
        this.mailSenderService = mailSenderService;
        this.usersRepos = usersRepos;
    }

    @Scheduled(fixedRate = delay)
    public void sendMessages() {
        var emailsResult = usersRepos.getAllUserEmails();//.collect(Collectors.toList());
        var emails = new String[emailsResult.size()];
        emailsResult.toArray(emails);

        mailSenderService.sendAll(emails, "Рассылка акции", "У нас скоро в продаже...");
        log.info(mailSenderService.toString());

    }
}
