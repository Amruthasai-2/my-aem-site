package com.mylearningsite.aem.core.models;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EmployeeDetailsSlingModel {

    private static final Logger Log =LoggerFactory.getLogger(EmployeeDetailsSlingModel.class);

    @ValueMapValue
    private String sname;

    @ValueMapValue
    private String sage;

    @ValueMapValue
    private String scompany;

    @ValueMapValue
    private String sdesignation;

    @ValueMapValue
    private String snumber;

    @PostConstruct
    protected void init(){
        Log.info("EmployeeDetailsSlingModel Initialized");
        if(sname !=null){
            Log.info("Name: {}",sname);
        }else{
            Log.info("Name not injected");
        }
    }

    public String getSname() {
        return sname;
    }

    public String getSage() {
        return sage;
    }

    public String getScompany() {
        return scompany;
    }

    public String getSdesignation() {
        return sdesignation;
    }

    public String getSnumber() {
        return snumber;
    }

}
