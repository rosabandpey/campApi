package com.camp.campApi.modules.users.service;

import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;

public class MyBeanCopy extends BeanUtilsBean {

    @Override
    public void copyProperties(Object bean, Object value) throws IllegalAccessException, InvocationTargetException {
        if (value == null || value.toString().isEmpty())
            return;
        super.copyProperties(bean, value);
    }
}