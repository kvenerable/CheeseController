package org.launchcode.cheesemvc.Controllers;

import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.CheeseType;
import org.launchcode.cheesemvc.models.cheese;
import org.launchcode.cheesemvc.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;

    @RequestMapping(value = "")
    public String index(Model model) {


        model.addAttribute("cheeses", cheeseDao.findAll());
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
        cheeseDao.save(newcheese);
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

        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }


    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeCheese(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            cheeseDao.delete(cheeseId);

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
    public String processEditForm(@PathVariable int cheeseId, String name, String description, CheeseType type, Integer rating, @ModelAttribute @Valid cheese thatCheese, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/edit";
        }

        thatCheese = CheeseData.getById(cheeseId);
        thatCheese.setName(name);
        thatCheese.setDescription(description);
        thatCheese.setType(type);
        thatCheese.setRating(rating);

        return "redirect:/cheese";

    }

}
