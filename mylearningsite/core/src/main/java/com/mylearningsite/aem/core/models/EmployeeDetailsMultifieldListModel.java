package com.mylearningsite.aem.core.models;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EmployeeDetailsMultifieldListModel {
    @ValueMapValue
    private String mcompany;
    @ValueMapValue
    private String mdesignation;

    public String getMcompany() {
        return mcompany;
    }

    public String getMdesignation() {
        return mdesignation;
    }
}