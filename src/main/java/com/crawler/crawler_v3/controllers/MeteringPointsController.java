package com.crawler.crawler_v3.controllers;

import com.crawler.crawler_v3.services.SoapClientService;
import cmf.edsn.data.searchmeteringpointsrequest._3.standard.SearchMeteringPointsRequestEnvelope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metering-points")
public class MeteringPointsController {

    private final SoapClientService soapClientService;

    public MeteringPointsController(SoapClientService soapClientService) {
        this.soapClientService = soapClientService;
    }

    @PostMapping("/search")
    public String searchMeteringPoints(@RequestBody SearchMeteringPointsRequestEnvelope requestEnvelope) {
        // Call the SOAP service
        return soapClientService.sendRequest(requestEnvelope);
    }
}
