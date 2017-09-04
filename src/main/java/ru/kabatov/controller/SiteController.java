package ru.kabatov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kabatov.domain.Users;
import ru.kabatov.storage.UsersStorage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Кабатов on 24.08.2017.
 */
@Controller
@RequestMapping(value = "/")
public class SiteController {
    @RequestMapping(method = RequestMethod.GET)
    public String printIndex(ModelMap model) {
        UsersStorage usersStorage = new UsersStorage();
        List<Users> users = new ArrayList<>(usersStorage.values());
        model.addAttribute("users", users);
        return "index";
    }
}
