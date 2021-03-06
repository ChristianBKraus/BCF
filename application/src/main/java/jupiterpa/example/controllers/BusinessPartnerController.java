package jupiterpa.example.controllers;

import com.sap.cloud.sdk.cloudplatform.logging.CloudLoggerFactory;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.BusinessPartnerService;

import jupiterpa.example.commands.GetAllBusinessPartnersCommand;
import jupiterpa.example.commands.GetSingleBusinessPartnerByIdCommand;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/business-partners", produces = "application/json")
public class BusinessPartnerController {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = CloudLoggerFactory.getLogger(BusinessPartnerController.class);

    private final BusinessPartnerService service;

    @Autowired
    public BusinessPartnerController(BusinessPartnerService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    protected ResponseEntity<Object> getBusinessPartners(@RequestParam(required = false) final String id) {

        final Object result;
        if (id == null) {
            logger.info("Retrieving all business partners");
            result = new GetAllBusinessPartnersCommand(service).execute();
        } else {
            logger.info("Retrieving business partner with id {}", id);
            result = new GetSingleBusinessPartnerByIdCommand(service, id).execute();
        }

        return ResponseEntity.ok(result);
    }
}
