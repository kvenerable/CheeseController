package org.launchcode.cheesemvc.Controllers;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String add(Model model, @ModelAttribute User user, String verify){

        model.addAttribute("username",user.getUsername());
        model.addAttribute("Email",user.getEmail());
        model.addAttribute("Password",user.getPassword());

        if(verify.equals(user.getPassword())){
            return "user/index";
        }
        else {
            model.addAttribute("username",user.getUsername());
            model.addAttribute("Email",user.getEmail());
            model.addAttribute("message","*passwords must match");
            return "add";
        }
}



}







