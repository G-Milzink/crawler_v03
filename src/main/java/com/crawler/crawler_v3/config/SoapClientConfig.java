package com.crawler.crawler_v3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("cmf.edsn.service.searchmeteringpoints._3.standard"); // Adjust to match generated package
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
        WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
        template.setDefaultUri("http://localhost:9000/b2b/synchroon/ResponderSearchMeteringPointsRespondingActivity"); // Replace with your actual SOAP endpoint
        return template;
    }
}
