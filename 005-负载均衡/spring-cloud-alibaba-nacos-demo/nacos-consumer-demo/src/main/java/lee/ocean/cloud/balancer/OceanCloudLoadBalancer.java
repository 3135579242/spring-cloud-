package lee.ocean.cloud.balancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import reactor.core.publisher.Mono;

public class OceanCloudLoadBalancer implements ReactorServiceInstanceLoadBalancer {
    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        return null;
    }
}
