package org.itstep.controllers;

import org.itstep.entities.Author;
import org.itstep.entities.Book;
import org.itstep.entities.PersonalData;
import org.itstep.entities.User;
import org.itstep.repositories.AuthorsRepository;
import org.itstep.repositories.BooksRepository;
import org.itstep.repositories.PersonalDataRepository;
import org.itstep.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping({"/", "/home"})
public class HomeController {

    private final UsersRepository usersRepos;
    private final PersonalDataRepository personalDataRepos;
    private final AuthorsRepository authorsRepos;
    private final BooksRepository booksRepository;

    public HomeController(UsersRepository usersRepos, PersonalDataRepository personalDataRepos, AuthorsRepository authorsRepos, BooksRepository booksRepository) {
        this.usersRepos = usersRepos;
        this.personalDataRepos = personalDataRepos;
        this.authorsRepos = authorsRepos;
        this.booksRepository = booksRepository;

        //One-To-One demo
//        User user = new User();
//        PersonalData personalData = new PersonalData();
//
//        user.setLogin("vasya");
//        user.setPassword("123456");
//
//        personalData.setFirstName("Vasiliy");
//        personalData.setLastName("Petrov");
//        personalData.setMiddleName("Ivanovich");
//        personalData.setBirth(LocalDate.now());
//
//        user.setPersonalData(personalData);
//
//        usersRepos.save(user);


        //Many-To-Many

//        Author author1 = new Author();
//        author1.setFirstName("First name 1");
//        author1.setLastName("Last name 1");
//
//        Author author2 = new Author();
//        author2.setFirstName("First name 2");
//        author2.setLastName("Last name 2");
//
//        Author author3 = new Author();
//        author3.setFirstName("First name 3");
//        author3.setLastName("Last name 3");
//
//
//        Book book1 = new Book();
//        book1.setName("Book 1");
//        book1.setPages(100);
//
//        Book book2 = new Book();
//        book2.setName("Book 2");
//        book2.setPages(155);
//
//        Book book3 = new Book();
//        book3.setName("Book 3");
//        book3.setPages(560);
//
//        Book book4 = new Book();
//        book4.setName("Book 4");
//        book4.setPages(320);
//
//        Book book5 = new Book();
//        book5.setName("Book 5");
//        book5.setPages(487);
//
//        authorsRepos.save(author1);
//        authorsRepos.save(author2);
//        authorsRepos.save(author3);
//
//        booksRepository.save(book1);
//        booksRepository.save(book2);
//        booksRepository.save(book3);
//        booksRepository.save(book4);
//        booksRepository.save(book5);
    }

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    @GetMapping("/demo")
    public String demo() {
//        var pd = personalDataRepos.findById(7L).get();
//        var user = new User();
//        user.setLogin("petya");
//        user.setPassword("123456");
//        user.setPersonalData(pd);
//
//        usersRepos.save(user);

//        Author author = authorsRepos.findById(23L).get();
//        Book book1 = booksRepository.findById(26L).get();
//        Book book2 = booksRepository.findById(30L).get();
//
//        author.getBooks().add(book1);
//        author.getBooks().add(book2);
        //authorsRepos.save(author);


//        Author author1 = authorsRepos.findById(24L).get();
//        Author author2 = authorsRepos.findById(25L).get();
//
//        Book book3 = booksRepository.findById(28L).get();
//
//        author1.getBooks().add(book3);
//        author2.getBooks().add(book3);
//
//
//
//        authorsRepos.save(author1);
//        authorsRepos.save(author2);

        Author author = authorsRepos.findById(24L).get();
        Book book = booksRepository.findById(28L).get();

        return "";
    }
}
