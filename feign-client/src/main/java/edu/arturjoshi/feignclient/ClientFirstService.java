package edu.arturjoshi.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("first-service")
public interface ClientFirstService {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String getWord();
}
