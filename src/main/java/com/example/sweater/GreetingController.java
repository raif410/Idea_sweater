package com.example.sweater;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

/*@SpringBootApplication
public class DemoApplication {*/

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model)
    {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("some", "Hello let's code!");
        return "main";
    }
     /*public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    } Это было изначально из стартового пака*/
    }

