package org.itstep.controllers;

//import org.itstep.models.Person;
import org.itstep.entities.Person;
import org.itstep.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    //static List<Person> people = new ArrayList<>();
    static List<String> items = new ArrayList<>();

    static {
//        people.add(new Person("Vasya", 20));
//        people.add(new Person("Masha", 29));

        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");
    }

    private final PeopleRepository peopleRepos;

    public HomeController(PeopleRepository peopleRepos) {
        this.peopleRepos = peopleRepos;
    }

    @GetMapping("/")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "Unknown") String username,
                        @RequestParam(required = false, defaultValue = "0") int age,
                        Map<String, Object> model) {

        var queryResult = peopleRepos.findByFirstName("Vasya");

        var people = new ArrayList<Person>();
        var result = peopleRepos.findAll();
        result.forEach(people::add);

        //передача данных в представление
        model.put("name", username);
        model.put("age", age);
        model.put("people", people);
        model.put("items", items);

        return "home/index";
    }

    @PostMapping("/")
    public String index(String firstName, String lastName, int age) {
        peopleRepos.save(new Person(firstName, lastName, age));
        //people.add(new Person(name, age));

        /*Person p = peopleRepos.findById((long) 1).orElse(null);
        p.setFirstName("New");
        peopleRepos.save(p);*/

        return "redirect:/";
    }
}
