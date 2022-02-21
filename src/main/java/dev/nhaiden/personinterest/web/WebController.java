package dev.nhaiden.personinterest.web;

import dev.nhaiden.personinterest.db.InterestRepository;
import dev.nhaiden.personinterest.db.PersonRepository;
import dev.nhaiden.personinterest.model.Interest;
import dev.nhaiden.personinterest.model.Person;
import dev.nhaiden.personinterest.model.Sex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/persons")
public class WebController {
    InterestRepository interestRepository;
    PersonRepository personRepository;

    public WebController(InterestRepository interestRepository, PersonRepository personRepository) {
        this.interestRepository = interestRepository;
        this.personRepository = personRepository;
    }

    @GetMapping("/all")
    public String allPersons(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "person/all";
    }

    @PostMapping("/new")
    public String addPerson(Model model, @Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            List<Interest> interestList = interestRepository.findAll();
            model.addAttribute("interests", interestList);
            model.addAttribute("genders", Sex.values());
            return "person/new";
        }

        System.out.println(person);
        personRepository.save(person);

        return "redirect:/persons/all";
    }

    @GetMapping("/new")
    public String personNew(Model model) {
        model.addAttribute("interests", interestRepository.findAll());
        model.addAttribute("person", new Person());
        model.addAttribute("genders", Sex.values());
        return "person/new";
    }
}
