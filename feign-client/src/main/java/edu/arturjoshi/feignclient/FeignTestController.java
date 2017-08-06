package edu.arturjoshi.feignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignTestController {

    @Autowired
    private ClientFirstService clientFirstService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String testFeign() {
        return clientFirstService.getWord();
    }
}
