package com.crawler.crawler_v3.services;

import cmf.edsn.data.searchmeteringpointsrequest._3.standard.*;

public class MeteringPointsService {

    public SearchMeteringPointsRequestEnvelope createRequest() {
        // Create the main request envelope
        SearchMeteringPointsRequestEnvelope requestEnvelope = new SearchMeteringPointsRequestEnvelope();

        // Create and populate the header
        SearchMeteringPointsRequestEnvelopeEDSNBusinessDocumentHeader header =
                new SearchMeteringPointsRequestEnvelopeEDSNBusinessDocumentHeader();

        SearchMeteringPointsRequestEnvelopeEDSNBusinessDocumentHeaderSource source =
                new SearchMeteringPointsRequestEnvelopeEDSNBusinessDocumentHeaderSource();
        source.setSenderID("MySystemID");

        SearchMeteringPointsRequestEnvelopeEDSNBusinessDocumentHeaderDestinationReceiver receiver =
                new SearchMeteringPointsRequestEnvelopeEDSNBusinessDocumentHeaderDestinationReceiver();
        receiver.setReceiverID("APIEndpointID");

        SearchMeteringPointsRequestEnvelopeEDSNBusinessDocumentHeaderDestination destination =
                new SearchMeteringPointsRequestEnvelopeEDSNBusinessDocumentHeaderDestination();
        destination.setReceiver(receiver);

        header.setSource(source);
        header.setDestination(destination);

        requestEnvelope.setEDSNBusinessDocumentHeader(header);

        // Populate CAR_Content
        SearchMeteringPointsRequestEnvelopeCCCMP carMeteringPoint = new SearchMeteringPointsRequestEnvelopeCCCMP();

        // Populate simple fields
        carMeteringPoint.setEANID("123456789");
        carMeteringPoint.setGridArea("GridArea1");
        carMeteringPoint.setMarketSegment("ART");
        carMeteringPoint.setLocationDescription("Location Description Example");
        carMeteringPoint.setProductType("Electricity");

        // Populate EDSN_AddressExtended
        SearchMeteringPointsRequestEnvelopeAddress address = new SearchMeteringPointsRequestEnvelopeAddress();
        address.setStreetName("Main Street");
        address.setBuildingNr(123);
        address.setZIPCode("12345");
        address.setCityName("Example City");
        address.setCountry("Example Country");
        carMeteringPoint.setEDSNAddressExtended(address);

        // Populate GridOperator_Company
        SearchMeteringPointsRequestEnvelopeCCCMPGOC gridOperator = new SearchMeteringPointsRequestEnvelopeCCCMPGOC();
        gridOperator.setID("1234567890123"); // Set the ID as per the schema
        carMeteringPoint.setGridOperatorCompany(gridOperator);

        // Populate MPPhysicalCharacteristics
        SearchMeteringPointsRequestEnvelopeCCCMPMPPC physicalCharacteristics = new SearchMeteringPointsRequestEnvelopeCCCMPMPPC();
        physicalCharacteristics.setPhysicalStatus("Physical Property Example");
        carMeteringPoint.setMPPhysicalCharacteristics(physicalCharacteristics);

        // Attach CAR_Content to the request
        SearchMeteringPointsRequestEnvelopeCC carContent = new SearchMeteringPointsRequestEnvelopeCC();
        carContent.setCARMeteringPoint(carMeteringPoint);

        requestEnvelope.setCARContent(carContent);

        return requestEnvelope;
    }
}
