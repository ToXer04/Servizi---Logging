package develhope.exercise.Servizi.Logging.controllers;

import develhope.exercise.Servizi.Logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@RestController
@RequestMapping
public class HomeController {
    @Autowired
    Environment environment;
    @Autowired
    BasicService basicService;
    Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Value("${num1}")
    private double num1;
    @Value("${num2}")
    private double num2;
    @GetMapping("/")
    public String welcome() {
        logger.info("Sending welcome message");
        return "Welcome!";
    }
    @GetMapping("/exp")
    public double getExp() {
        logger.info("Gathering informations");
        double result = basicService.calcExp(num1, num2);
        logger.info("The result is: " + result);
        return result;
    }
    @GetMapping("/get-errors")
    public void getErrors() throws Exception {
        logger.error("There's an error!");
        throw new Exception("Here's a simple exception!");
    }
}
