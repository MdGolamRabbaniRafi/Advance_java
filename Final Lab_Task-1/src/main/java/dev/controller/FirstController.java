package dev.controller;

import dev.domain.User;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import             dev.service.UserService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

@Controller
public class FirstController {

    @InitBinder
    public void intiBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

        DateFormatEditor dateFormatEditor = new DateFormatEditor();
        webDataBinder.registerCustomEditor(LocalDate.class, dateFormatEditor);
    }

    @RequestMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping("/CreateStudent")
    public String CreateStudent(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) throws SQLException, ClassNotFoundException {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        else
        {
            UserService.create(user);
            return "confirm";
        }
    }
    @RequestMapping("/student/{id}")
    public String SearchStudent(@PathVariable("id") int Id, Model model) throws SQLException, ClassNotFoundException {
        User user = UserService.get(Id);
        model.addAttribute("user", user);
        return "confirm";
    }
    @RequestMapping("/student/{id}/edit")
    public String UpdateStudent(@PathVariable("id") int Id, Model model) throws SQLException, ClassNotFoundException {
        User user = UserService.get(Id);
        model.addAttribute("user", user);
        return "Update";
    }
    @RequestMapping("/student/{id}/UpdateStudent")
    public String Update(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) throws SQLException, ClassNotFoundException {
        if (bindingResult.hasErrors()) {
            return "Update";
        }
        else {
            UserService.update(user);
            return "confirm";
        }
    }

    @RequestMapping("/student/{id}/delete")
    public String DeleteStudent(@PathVariable("id") int Id, Model model) throws SQLException, ClassNotFoundException {
        User user = UserService.get(Id);
        model.addAttribute("user", user);
        return "Delete";
    }
    @RequestMapping("/student/{id}/DeleteStudent")
    public String delete(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) throws SQLException, ClassNotFoundException {
            UserService.delete(user);
            return "Deleted";

    }

    @RequestMapping("/student")
    public String student(Model model) throws SQLException, ClassNotFoundException {
        List<User> userList = UserService.getAlluser();
        model.addAttribute("userList", userList);
        return "Confirm2";
    }



    class DateFormatEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(text, dateTimeFormatter);
            setValue(localDate);
        }
    }
}