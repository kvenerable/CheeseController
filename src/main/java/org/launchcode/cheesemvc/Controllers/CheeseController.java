package org.launchcode.cheesemvc.Controllers;


        import org.launchcode.cheesemvc.models.CheeseData;
        import org.launchcode.cheesemvc.models.CheeseType;
        import org.launchcode.cheesemvc.models.cheese;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.Errors;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
        import java.util.ArrayList;




@Controller
@RequestMapping("cheese")
public class CheeseController {


    @RequestMapping(value = "")
    public String index(Model model) {


        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", " My Cheeses");
        return "cheese/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute("cheese", new cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid cheese newcheese, Errors errors, Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/add";

        }
        CheeseData.add(newcheese);
        return "redirect:";

        //if(cheeseName.isEmpty()){
        // model.addAttribute("title", "Add Cheese");
        // model.addAttribute("message", "*Field cannot be empty");
        // return "cheese/add";
    }
    // cheese newcheese = new cheese(cheeseName,cheeseInfo);
    // CheeseData.add(newcheese);
    //return "redirect:";


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String removeCheeseForm(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }


    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeCheese(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);

        }
        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {

        model.addAttribute("cheese", CheeseData.getById(cheeseId));
        model.addAttribute("title", "Edit");
        model.addAttribute("cheeseTypes", CheeseType.values());

        return "cheese/edit";
    }


    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.POST)
    public String processEditForm(int cheeseId, String name, String description, Integer rating, CheeseType type, @ModelAttribute @Valid cheese thatCheese, Model model, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/edit";
        }

        thatCheese = CheeseData.getById(cheeseId);

        thatCheese.setName(name);
        thatCheese.setDescription(description);
        thatCheese.setRating(rating);
        thatCheese.setType(type);

        return "redirect:/cheese";

    }
    }




