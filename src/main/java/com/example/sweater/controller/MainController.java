package com.example.sweater;

import com.example.sweater.domain.Message;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

/*@SpringBootApplication
public class DemoApplication {*/

@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messagesRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messagesRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag ,Map<String, Object> model){
        Message message = new Message(text, tag);

        messagesRepo.save(message);

        Iterable<Message> messages = messagesRepo.findAll();

        model.put("messages", messages);

        return "main";
    }
     /*public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    } Это было изначально из стартового пака*/
    }

