package com.sbapi.sample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SampleController {
    @RequestMapping(path = "/defaultHello", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> hello(@RequestParam(value = "message", required = false) String message) {
      HashMap<String, String> map = new HashMap<>();
      String finalMessage = "Hello ";
      finalMessage = finalMessage + message;
      if (message == null) {
          map.put("echo", "Hello World!");
      } else {
          if (!message.isEmpty()) {
              map.put("echo", finalMessage);
          } else {
              map.put("echo", "Hello World!");
          }
      }
        return ResponseEntity.ok(map);
    }

    @RequestMapping(path = "/customHello", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> customHello(@RequestParam(value = "message", required = false) String message) {
      HashMap<String, String> map = new HashMap<>();
      String finalMessage = "Custom ";
      map.put("echo", finalMessage);

        if (message == null) {
            return ResponseEntity.badRequest().body(map);
        } else {
            if (!message.isEmpty()) {
                finalMessage = finalMessage + message;
                map.put("echo", finalMessage);
            }
            return ResponseEntity.ok(map);
        }

    }
}
