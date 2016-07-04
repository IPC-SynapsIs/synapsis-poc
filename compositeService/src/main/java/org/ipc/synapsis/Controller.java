package org.ipc.synapsis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/call")
public class Controller {

    @Autowired
    private ApplicationClient client;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    Environment env;

    @RequestMapping("/test")
    public String index2() {
        List<ServiceInstance> list = discoveryClient.getInstances("application");
        ServiceInstance s = list.get(0);

        return s.getUri() + s.getHost() + s.getPort() + s.getServiceId();
    }
    @RequestMapping("/eureka2")
    public String index3() {

    return    discoveryClient.getInstances("composite-service").get(0).getHost().toString();

    }



    @RequestMapping("/resttemplate")
    public String index() {

        String response = restTemplate.getForObject("http://application/application/nameapp",String.class);
        return response;
    }

    @RequestMapping("/feign")
    public String feign() {

        String response = client.index();
        return response;
    }

    @FeignClient("application")
    public interface ApplicationClient {
        @RequestMapping("/application/nameapp")
        String index();
    }



}
