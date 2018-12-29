package org.launchcode.cheesemvc.Controllers;


        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;

        import java.util.ArrayList;
        import java.util.HashMap;


@Controller
@RequestMapping("cheese")
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();

    @RequestMapping(value = "")
    public String index(Model model) {


        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", " My Cheeses");
        return "cheese/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(Model model,@RequestParam String cheeseName, @RequestParam String cheeseInfo){


        if(cheeseName.isEmpty()){
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("message", "*Field cannot be empty");
            return "cheese/add";

        }
        cheeses.put(cheeseName, cheeseInfo);
        return "redirect:";



    }
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String removeCheeseForm(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }



    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeCheese(@RequestParam ArrayList<String> cheese){

        for (String cheeseName : cheese) {
            cheeses.remove(cheeseName);

        }return "redirect:";



    }

}