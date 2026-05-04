package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class DemoApplication {

//    @Bean
//    public VotingController votingController(@Qualifier("votingServiceImpl") VotingService votingService) {
//        return new VotingController(votingService);
//    }

//    @Bean
//    @Profile("dev")
//    @ConditionalOnProperty(
//            name= "name",
//            havingValue = "gandon"
//    )
//    public VotingService myService(CandidateDAO candidateDAO) {
//        return new VotingServiceImpl(candidateDAO);
//    }
//
//    @Bean
//    @Profile("prod")
//    @ConditionalOnProperty(
//            name= "name",
//            havingValue = "bandon"
//    )
//    public VotingService votingService() {
//        return new TestServiceImpl();
//    }

    @Bean
    public MessageSource messageSource() {
        var ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:i18n/messages");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
