package org.itstep.api.v1.controllers;

import org.itstep.pojo.User;
import org.itstep.services.GitHubLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/api/v1/github")
public class GitHubController {

    private static final Logger logger = LoggerFactory.getLogger(GitHubController.class);

    final GitHubLookupService gitHubLookupService;

    public GitHubController(GitHubLookupService gitHubLookupService) {
        this.gitHubLookupService = gitHubLookupService;
    }

    @GetMapping("find-user")
    public User findUser(String login) throws InterruptedException, ExecutionException {
        //logger.info(login);
        final long startTime = System.currentTimeMillis();
        CompletableFuture<User> future = gitHubLookupService.findUser(login);

        CompletableFuture.allOf(future).join();
        final long duration = (System.currentTimeMillis() - startTime) / 1000;
        User findUser = future.get();
        logger.info("user completed--> " + findUser);
        logger.info("duration--> " + duration);
        return findUser;
    }
}
