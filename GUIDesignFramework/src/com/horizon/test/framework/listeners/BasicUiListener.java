package com.horizon.test.framework.listeners;

import java.awt.event.ActionListener;


public interface BasicUiListener<T> extends ActionListener {

    public void initializeUIComponents();


    public T getPanel();

}
