package com.horizon.test.framework.command;

import java.util.Map;

import com.horizon.test.framework.exception.InvalidDataException;
import com.horizon.test.framework.exception.BasicServiceException;
import com.horizon.test.framework.model.BasicDataModel;
import com.horizon.test.framework.services.BasicFetchDataService;
import com.horizon.test.framework.services.BasicDataService;


public class BasicFetchActionCommand implements BasicActionCommand {

    private BasicDataService service;

    private String                fetchID;


    public BasicFetchActionCommand(String fetchID) {

        this.fetchID = fetchID;
    }


    @Override
    public Map<String, BasicDataModel> perform() throws InvalidDataException, BasicServiceException {

        System.out.println("perform...");
        if (this.fetchID == null || "".equals(this.fetchID)) {
            throw new InvalidDataException("FetchID cannot be null");
        }

        if (this.service == null) {
            this.service = new BasicFetchDataService();
        }
        System.out.println("Performing for fetchID: " + this.fetchID);
        return this.service.fetchData(this.fetchID);
    }


    @Override
    public void setService(BasicDataService service) {

        this.service = service;
    }
}
