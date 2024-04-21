package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class NotificationController {
    @GetMapping("/testRollback")
    public ResponseEntity<Void> testNotification(){
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/notification")
    public ResponseEntity<String> notification(){
        return ResponseEntity.ok("Order created");
    }

}
