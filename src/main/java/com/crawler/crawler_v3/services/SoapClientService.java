package com.crawler.crawler_v3.services;

import cmf.edsn.data.searchmeteringpointsrequest._3.standard.SearchMeteringPointsRequestEnvelope;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.soap.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;

@Component
public class SoapClientService {

    private static final String SOAP_ENDPOINT = "https://portaal-opt.edsn.nl/b2b/synchroon/ResponderSearchMeteringPointsRespondingActivity"; // Replace with the actual endpoint URL
    private static final String SOAP_ACTION = ""; // Set if required by the API

    public String sendRequest(SearchMeteringPointsRequestEnvelope requestEnvelope) {
        try {
            // Create a SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Create the SOAP Message
            SOAPMessage soapMessage = createSOAPRequest(requestEnvelope);

            // Send the request and receive the response
            SOAPMessage soapResponse = soapConnection.call(soapMessage, SOAP_ENDPOINT);

            // Process the response
            String responseString = soapResponseToString(soapResponse);

            soapConnection.close();
            return responseString;

        } catch (Exception e) {
            System.err.println("Error during SOAP communication: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private SOAPMessage createSOAPRequest(SearchMeteringPointsRequestEnvelope requestEnvelope) throws Exception {
        // Create a SOAP Message
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        // Set up the envelope
        SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();
        envelope.addNamespaceDeclaration("urn", "urn:cmf:edsn:data:searchmeteringpointsrequest:3:standard");

        // Convert JAXB object to XML and add to the SOAP body
        SOAPBody soapBody = envelope.getBody();
        JAXBContext jaxbContext = JAXBContext.newInstance(SearchMeteringPointsRequestEnvelope.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(requestEnvelope, soapBody);

        // Add SOAPAction header if required
        MimeHeaders headers = soapMessage.getMimeHeaders();
        if (!SOAP_ACTION.isEmpty()) {
            headers.addHeader("SOAPAction", SOAP_ACTION);
        }

        soapMessage.saveChanges();
        return soapMessage;
    }

    private String soapResponseToString(SOAPMessage soapMessage) throws Exception {
        // Convert SOAPMessage to String
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        soapMessage.writeTo(outputStream);
        return new String(outputStream.toByteArray());
    }
}
