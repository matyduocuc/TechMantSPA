package com.example.Gestion.de.usuarios.client;

import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "another-service", url = "${another.service.url}")
public interface AnotherServiceClient {

    @GetMapping("/api/resource")
    String getResourceFromAnotherService();
}
