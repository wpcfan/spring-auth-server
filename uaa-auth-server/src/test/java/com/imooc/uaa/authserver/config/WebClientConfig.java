package com.imooc.uaa.authserver.config;

import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        WebClient client = new WebClient();
        client.getOptions().setRedirectEnabled(true);
        client.getOptions().setCssEnabled(true);
        client.getOptions().setJavaScriptEnabled(true);
        return client;
    }
}
