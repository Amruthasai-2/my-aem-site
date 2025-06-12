package com.mylearningsite.aem.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.sling.api.resource.Resource;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(AemContextExtension.class)
class EmployeeDetailsMultifieldModelTest {
    private final AemContext aemContext = new AemContext();
    EmployeeDetailsMultifieldModel employeeDetailsMultifieldModel;

    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(EmployeeDetailsMultifieldModel.class, EmployeeDetailsMultifieldListModel.class);
        aemContext.load().json("/components/employeedetailssling/EmployeeDetailsMultifieldModel.json", "/components");
        Resource resource = aemContext.resourceResolver().getResource("/components/data");
        employeeDetailsMultifieldModel = aemContext.getService(ModelFactory.class).createModel(resource, EmployeeDetailsMultifieldModel.class);
    }

    @Test
    void getMname() {
        String expected = "Amrutha";
        String actual = employeeDetailsMultifieldModel.getMname();
        assertEquals(expected, actual);
    }

    @Test
    void getMage() {
        String expected = "23";
        String actual = employeeDetailsMultifieldModel.getMage();
        assertEquals(expected, actual);
    }

    @Test
    void getMnumber() {
        String expected = "2482155";
        String actual = employeeDetailsMultifieldModel.getMnumber();
        assertEquals(expected, actual);
    }

    @Test
    void getMultifieldList() {
        String expectedD0 = "Engineer";
        String actualD0 = employeeDetailsMultifieldModel.getMultifieldList().get(0).getMdesignation();
        assertEquals(expectedD0, actualD0);

        String expectedD1 = "AEM Developer";
        String actualD1 = employeeDetailsMultifieldModel.getMultifieldList().get(1).getMdesignation();
        assertEquals(expectedD1, actualD1);

        String expectedC0 = "TCS";
        String actualC0 = employeeDetailsMultifieldModel.getMultifieldList().get(0).getMcompany();
        assertEquals(expectedC0, actualC0);

        String expectedC1 = "TCS";
        String actualC1 = employeeDetailsMultifieldModel.getMultifieldList().get(1).getMcompany();
        assertEquals(expectedC1, actualC1);
    }
}