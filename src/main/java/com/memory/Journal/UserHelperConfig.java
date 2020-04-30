package com.memory.Journal;

import com.memory.Journal.userHelper.UserHelper;
import com.memory.Journal.userHelper.UserHelperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@ComponentScan("com.memory.Journal.userHelper")
public class UserHelperConfig {

    @Bean
    public UserHelper provideUserHelper() {
        return new UserHelperImpl();
    }

}
