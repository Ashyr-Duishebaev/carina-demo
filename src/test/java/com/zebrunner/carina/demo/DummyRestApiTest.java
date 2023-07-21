package com.zebrunner.carina.demo;

import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.dummyrestapi.DummyRestApiDeleteMethod;
import com.zebrunner.carina.demo.dummyrestapi.DummyRestApiGetMethod;
import com.zebrunner.carina.demo.dummyrestapi.DummyRestApiPostMethod;
import com.zebrunner.carina.demo.dummyrestapi.DummyRestApiPutMethod;
import org.testng.annotations.Test;


import org.skyscreamer.jsonassert.JSONCompareMode;

public class DummyRestApiTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "ashyr")
    public void testGetEmployees() {
        DummyRestApiGetMethod dummyRestApiGetMethod = new DummyRestApiGetMethod();
        dummyRestApiGetMethod.callAPIExpectSuccess();
        dummyRestApiGetMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        dummyRestApiGetMethod.validateResponseAgainstSchema("api/restapiexample/_get/rs.schema");
    }

    @Test
    @MethodOwner(owner = "ashyr")
    public void testCreateEmployees() {
        DummyRestApiPostMethod dummyRestApiPostMethod = new DummyRestApiPostMethod();
        dummyRestApiPostMethod.setProperties("api/restapiexample/employee.properties");
        dummyRestApiPostMethod.callAPIExpectSuccess();
        dummyRestApiPostMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "ashyr")
    public void testUpdateEmployees() {
        DummyRestApiPutMethod dummyRestApiPutMethod = new DummyRestApiPutMethod();
        dummyRestApiPutMethod.callAPIExpectSuccess();
        dummyRestApiPutMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "ashyr")
    public void testDeleteEmployees() {
        DummyRestApiDeleteMethod dummyRestApiDeleteMethod = new DummyRestApiDeleteMethod();
        dummyRestApiDeleteMethod.callAPIExpectSuccess();
        dummyRestApiDeleteMethod.validateResponse();
    }
}