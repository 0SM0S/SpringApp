package pkg;


import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@RestController
public class Controller implements ErrorController {
    static final String ERROR = "/error";
    static final String ADD = "/add";
    static final String MULT = "/mult";
    static final String SUB = "/sub";
    static final String DIV = "/div";

    @RequestMapping(path = "/")
    public String home() {
        return "Nothing to see here...";
    }

    @RequestMapping(method = RequestMethod.GET, path = ADD)
    public String add(@PathParam(value = "") Integer number1, @PathParam(value = "") Integer number2) {
        return "" + (number1 + number2);
    }

    @RequestMapping(method = RequestMethod.GET, path = MULT)
    public String sub(@PathParam(value = "") Integer number1, @PathParam(value = "") Integer number2) {
        return "" + (number1 - number2);
    }

    @RequestMapping(method = RequestMethod.GET, path = SUB)
    public String mul(@PathParam(value = "") Integer number1, @PathParam(value = "") Integer number2) {
        return "" + (number1 * number2);
    }

    @RequestMapping(method = RequestMethod.GET, path = DIV)
    public String div(@PathParam(value = "") Integer number1, @PathParam(value = "") Integer number2) {
        if(number2 == 0)
            return "This might take a while...";
        else
            return "" + (number1 / number2);
    }

    @RequestMapping(path = ERROR)
    public String atError() {
        return "You done goofed!";
    }

    @Override
    public String getErrorPath() {
        return ERROR;
    }

}
