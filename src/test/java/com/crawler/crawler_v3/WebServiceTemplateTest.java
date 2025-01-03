package com.crawler.crawler_v3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ws.client.core.WebServiceTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class WebServiceTemplateTest {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    @Test
    public void testWebServiceTemplateBean() {
        assertNotNull(webServiceTemplate, "WebServiceTemplate should not be null");
    }
}
