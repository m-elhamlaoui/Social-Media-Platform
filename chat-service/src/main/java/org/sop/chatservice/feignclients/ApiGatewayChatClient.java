package org.sop.chatservice.feignclients;

import org.sop.chatservice.models.User;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "API-GATEWAY", path = "/api/user")
@RibbonClient(name = "API-GATEWAY")
public interface ApiGatewayChatClient {
    @GetMapping("/id/{id}")
    User findById(@PathVariable Long id);
}
