package com.mylearningsite.aem.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.sling.api.resource.Resource;

import static org.junit.jupiter.api.Assertions.*;

/*Once we have the basic class ready, we need to add Am specific libraries.For that we will use extend width and that will be defined above your class.
Extend with.Basically, it means that it will allow you to register your own extensions.
 */
@ExtendWith(AemContextExtension.class)
class EmployeeDetailsSlingModelTest {

    /*Now we need the AEM related APi's which will be accessing the resources and other stuff.
    For that we will be using Am context.*/

    private final AemContext aemContext = new AemContext();

    EmployeeDetailsSlingModel employeeDetailsSlingModel;

    //This method is executed before each of the Test Method.
    @BeforeEach
    void setUp() {
        //Registers the sling model to be tested into the mock Am context.
        aemContext.addModelsForClasses(EmployeeDetailsSlingModel.class);
        aemContext.load().json("/components/employeedetailssling/EmployeeDetailaSlingModel.json","/components");
        Resource resource = aemContext.resourceResolver().getResource("/components/data");
        employeeDetailsSlingModel = aemContext.getService(ModelFactory.class).createModel(resource,EmployeeDetailsSlingModel.class);
    }

    @Test
    void getSname() {
        String expected = "Amrutha";
        String actual = employeeDetailsSlingModel.getSname();
        assertEquals(expected, actual);
    }

    @Test
    void getSage() {
        String expected = "23";
        String actual = employeeDetailsSlingModel.getSage();
        assertEquals(expected, actual);
    }

    @Test
    void getScompany() {
        String expected = "TCS";
        String actual = employeeDetailsSlingModel.getScompany();
        assertEquals(expected, actual);
    }

    @Test
    void getSdesignation() {
        String expected = "Engineer";
        String actual = employeeDetailsSlingModel.getSdesignation();
        assertEquals(expected, actual);
    }

    @Test
    void getSnumber() {
        String expected = "2482155";
        String actual = employeeDetailsSlingModel.getSnumber();
        assertEquals(expected, actual);
    }
}