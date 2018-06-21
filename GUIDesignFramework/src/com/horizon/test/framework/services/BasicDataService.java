package com.horizon.test.framework.services;

import java.util.Map;

import com.horizon.test.framework.exception.BasicServiceException;
import com.horizon.test.framework.model.BasicDataModel;


/**
 * <pre>
 *  + Fetches, Creates and Provides data
 * </pre>
 */
public interface BasicDataService {

    public Map<String, BasicDataModel> fetchData(String fetchID) throws BasicServiceException;

}
