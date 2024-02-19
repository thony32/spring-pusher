package com.mademo.pusher1.config;

import com.pusher.rest.Pusher;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public Pusher pusher(){
        Pusher pusher = new Pusher("1758868","cbced54b8cb2fbe5911c", "901419b3b7acab0fe48B");
        pusher.setCluster("ap2");
        pusher.setEncrypted(true);
        return pusher;
    }

}
