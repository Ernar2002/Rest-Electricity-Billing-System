package kz.iitu.itse1905.damir.rest_electricity_billing_system.service.impl;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.EActive;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Role;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.RoleRepository;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.UserRepository;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_USER"));

        if(user.getRoles() == null) {
            user.setRoles(roles);
        }

        if (user.getActive() == null) {
            user.setActive(EActive.ACTIVE);
        }

        if(!user.getPassword().startsWith("$")) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        if(user.getCreated() == null) {
            Date date = new Date();
            user.setCreated(date);
        }
        userRepository.save(user);

        log.info("In UserServiceImpl method save: {} successfully saved", user);
    }

    @Override
    public void update(Long id, User user) {

    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByIIN(String iin) {
        return userRepository.findUserByIin(iin);
    }

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
    }

    @EnableAsync
    public class ScheduledFixedRateExample {
        @Async
        @Scheduled(fixedRate = 1000)
        public void scheduleFixedRateTaskAsync() {
            List<User> users = getAll();
            LocalDateTime date = LocalDateTime.now();
            int seconds = date.toLocalTime().getSecond();

            users.forEach(user -> {
                user.setEmail("damir@gmail.com" + seconds);
                save(user);
                log.info("Hero id updated --> " + user);
            });
            log.info("Fixed delay task - " + seconds);
        }

    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedRateWithInitialDelayTask() {
        String name = "damir@gmail.com42";
        Optional<User> user = Optional.ofNullable(findByEmail(name));

        if(user.isPresent()) {
            log.info("User with damir@gmail.com42 name found: " + user);
        } else {
            log.error("User not found");
        }

        long now = System.currentTimeMillis() / 1000;
        log.info("Fixed rate task with one second initial delay - " + now);
    }

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(5);
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
        return threadPoolTaskScheduler;
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void currentTime() {
        log.info("Current Time      = {}", dateFormat.format(new Date()));
    }
}
