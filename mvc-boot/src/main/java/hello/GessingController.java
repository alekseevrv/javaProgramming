package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.MyService;

@Controller
public class GessingController {

    @Autowired
    MyService myService;

    @RequestMapping("/gess")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="Noname") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("num", Math.random());
        return "gessing";
    }

}
