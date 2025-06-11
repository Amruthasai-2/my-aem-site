package com.mylearningsite.aem.core.models;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EmployeeDetailsMultifieldModel {

    @ValueMapValue
    private String mname;

    @ValueMapValue
    private String mage;

    @ValueMapValue
    private String mnumber;

    @ChildResource
    private List <EmployeeDetailsMultifieldListModel> multifieldList;

    public String getMname() {
        return mname;
    }

    public String getMage() {
        return mage;
    }

    public String getMnumber() {
        return mnumber;
    }

    public List<EmployeeDetailsMultifieldListModel> getMultifieldList() {
        return multifieldList;
    }
}