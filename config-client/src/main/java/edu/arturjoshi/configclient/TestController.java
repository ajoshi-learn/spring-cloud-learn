package edu.arturjoshi.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${lucky-word}")
    private String luckyWord;

    @RequestMapping(method = RequestMethod.GET, value = "/lucky-word")
    private ResponseEntity<String> showLuckyWord() {
        return ResponseEntity.ok(luckyWord);
    }
}
