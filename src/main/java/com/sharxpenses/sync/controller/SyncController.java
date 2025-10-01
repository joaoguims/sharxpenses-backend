package com.sharxpenses.sync.controller;

import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sync")
public class SyncController {

    // GET /sync?since=timestamp → retorna alterações desde o timestamp informado
    @GetMapping
    public Map<String, Object> getSync(@RequestParam(required = false) Long since) {
        return Map.of(
            "status", "ok",
            "since", since != null ? since : Instant.now().toEpochMilli(),
            "changes", List.of() // TODO: buscar mudanças reais no futuro
        );
    }

    // POST /sync → recebe operações locais do mobile
    @PostMapping
    public Map<String, Object> postSync(@RequestBody Map<String, Object> operations) {
        // TODO: aplicar operações no servidor
        return Map.of("status", "applied", "ops", operations);
    }
}
