package com.crawler.crawler_v3;

import cmf.edsn.data.searchmeteringpointsrequest._3.standard.*;
import com.crawler.crawler_v3.services.MeteringPointsService;
import com.crawler.crawler_v3.services.SoapClientService;

public class SoapClientServiceTest {

    public static void main(String[] args) {
        // Create the request
        MeteringPointsService meteringPointsService = new MeteringPointsService();
        SearchMeteringPointsRequestEnvelope requestEnvelope = meteringPointsService.createRequest();

        // Send the request using the SOAP client
        SoapClientService soapClientService = new SoapClientService();
        String response = soapClientService.sendRequest(requestEnvelope);

        // Print the response
        if (response != null) {
            System.out.println("Response received: ");
            System.out.println(response);
        } else {
            System.out.println("No response received or an error occurred.");
        }
    }
}
