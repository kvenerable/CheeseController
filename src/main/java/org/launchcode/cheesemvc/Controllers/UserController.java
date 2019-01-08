package org.launchcode.cheesemvc.Controllers;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

   @RequestMapping(value="add", method = RequestMethod.GET)
   public String add(Model model){
       User user = new User();
       model.addAttribute("user",user);
       model.addAttribute("title", "User Signup");

       return "user/add";

    }



    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors, String verify){


        if(errors.hasErrors()){
            model.addAttribute(user);

            model.addAttribute("title", "User Signup");
            user.setPassword("");
            return"user/add";


        }


         if(!verify.equals(user.getPassword())|| user.getPassword().isEmpty()){
             model.addAttribute("username",user.getUsername());
             model.addAttribute("email",user.getEmail());
             model.addAttribute("error","passwords dont match");
            user.setPassword("");
             return"user/add";

        }
        else{
            model.addAttribute("username",user.getUsername());
            return"user/index";
         }



   }

}








