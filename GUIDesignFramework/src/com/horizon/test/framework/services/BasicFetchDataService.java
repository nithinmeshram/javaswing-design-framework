package com.horizon.test.framework.services;

import java.util.HashMap;
import java.util.Map;

import com.horizon.test.framework.exception.BasicServiceException;
import com.horizon.test.framework.model.BasicDataModel;
import com.horizon.test.framework.model.NameData;


public class BasicFetchDataService implements BasicDataService {

    private Map<String, BasicDataModel> dataMap;


    public BasicFetchDataService() {

        this.dataMap = new HashMap<String, BasicDataModel>();
        this.dataMap.put("1", new NameData("One"));
        this.dataMap.put("9", new NameData("Nine"));
    }


    @Override
    public Map<String, BasicDataModel> fetchData(String fetchID) throws BasicServiceException {

        System.out.println("fetchData: " + fetchID);
        Map<String, BasicDataModel> resultsDataMap = new HashMap<String, BasicDataModel>();
        if (fetchID != null && !"".equals(fetchID)) {

            BasicDataModel modelData = this.dataMap.get(fetchID);
            if (modelData != null) {
                resultsDataMap.put(fetchID, modelData);
            }
        }
        System.out.println("Returning: " + resultsDataMap);
        if (resultsDataMap.size() == 0) {
            throw new BasicServiceException("No data with fetchID " + fetchID);
        }

        return resultsDataMap;
    }
}
