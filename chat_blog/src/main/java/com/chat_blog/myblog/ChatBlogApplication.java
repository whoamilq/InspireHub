package com.chat_blog.myblog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@ServletComponentScan
@EnableKafka
@EnableTransactionManagement
@SpringBootApplication
public class ChatBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatBlogApplication.class, args);
	}

}
