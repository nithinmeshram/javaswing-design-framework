package com.horizon.test.framework.command;

import java.util.Map;

import com.horizon.test.framework.exception.InvalidDataException;
import com.horizon.test.framework.exception.BasicServiceException;
import com.horizon.test.framework.model.BasicDataModel;
import com.horizon.test.framework.services.BasicDataService;


public interface BasicActionCommand {

    public void setService(BasicDataService service);


    public Map<String, BasicDataModel> perform() throws InvalidDataException, BasicServiceException;

}
