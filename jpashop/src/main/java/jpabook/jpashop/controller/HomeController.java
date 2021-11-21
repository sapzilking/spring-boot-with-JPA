package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j //아래 주석을 얻어오는 것과 동일(lombok에 포함되어있음)
public class HomeController {

//    Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
