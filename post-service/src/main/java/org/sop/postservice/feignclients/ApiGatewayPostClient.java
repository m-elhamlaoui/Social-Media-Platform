package org.sop.postservice.feignclients;

import org.sop.postservice.models.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-gateway", path = "/api/user")
public interface ApiGatewayPostClient {
    
    @GetMapping("/id/{id}")
    Post findById(@PathVariable Long id);
    Post getPostById(@PathVariable("postId") Long postId);


}