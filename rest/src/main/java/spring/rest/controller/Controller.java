package spring.rest.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Controller {

    @RequestMapping("/cusomers")
    public void getCustomers(){

    }

}
