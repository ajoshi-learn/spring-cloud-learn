package edu.arturjoshi.discoveryclientsecond;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExchangeController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String exchange() {
        return getWord("first-service");
    }

    private String getWord(String service) {
        List<ServiceInstance> instances = discoveryClient.getInstances(service);
        if(instances != null && instances.size() > 0) {
            URI uri = instances.get(0).getUri();
            if(uri != null) {
                return (new RestTemplate()).getForObject(uri, String.class);
            }
        }
        return null;
    }
}
