package com.zebrunner.carina.demo.dummyrestapi;


import com.zebrunner.carina.api.AbstractApiMethod;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/api/v1/update/21", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/restapiexample/_put/rq.json")
@ResponseTemplatePath(path = "api/restapiexample/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DummyRestApiPutMethod extends AbstractApiMethodV2 {

    public DummyRestApiPutMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}