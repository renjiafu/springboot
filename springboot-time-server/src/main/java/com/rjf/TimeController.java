package com.rjf;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@RestController
public class TimeController {

    @GetMapping("/")
    public String getTime(HttpServletRequest req, HttpServletResponse res) {
        return LocalDateTime.now().toString();
    }
}
