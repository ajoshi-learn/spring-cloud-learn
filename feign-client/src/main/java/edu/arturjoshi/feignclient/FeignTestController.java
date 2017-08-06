package edu.arturjoshi.feignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class FeignTestController {

    @Autowired
    private ClientFirstService clientFirstService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @HystrixCommand(defaultFallback = "feignFallback")
    public String testFeign() {
        return clientFirstService.getWord();
    }

    public String feignFallback() {
        return "Service is temporarily unavailable";
    }
}
