package com.rodrigomencias.LiteraturaChallenge;

import com.rodrigomencias.LiteraturaChallenge.service.Menu;
import com.rodrigomencias.LiteraturaChallenge.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaChallengeApplication implements CommandLineRunner{
        private final Menu menu;
        
        

    public static void main(String[] args) {
	SpringApplication.run(LiteraturaChallengeApplication.class, args);
    }

    public LiteraturaChallengeApplication(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void run(String... args) throws Exception {
        menu.showMenu();
    }

}
