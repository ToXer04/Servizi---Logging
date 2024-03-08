package develhope.exercise.Servizi.Logging.services;

import develhope.exercise.Servizi.Logging.controllers.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BasicService {
    Logger logger = LoggerFactory.getLogger(HomeController.class);
    public double calcExp(double num1, double num2) {
        logger.info("Starting calculation");
        logger.debug("Params are: " + num1 + " and " + num2);
        double result = Math.pow(num1, num2);
        logger.info("Calculation concluded");
        return result;
    }
}
