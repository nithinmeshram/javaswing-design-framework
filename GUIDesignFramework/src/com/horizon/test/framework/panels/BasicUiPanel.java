package com.horizon.test.framework.panels;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JComponent;

import com.horizon.test.framework.model.BasicDataModel;


public interface BasicUiPanel {

    public BasicUiPanel createUI();


    public List<JComponent> getComponentsToRegister();


    public void setUIData(Set<String> inputKeys, Map<String, BasicDataModel> dataMap);

}
