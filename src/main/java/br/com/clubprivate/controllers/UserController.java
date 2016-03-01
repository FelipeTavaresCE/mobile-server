package br.com.clubprivate.controllers;

import br.com.clubprivate.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController<User, Long> {

    public UserController() {
        super(User.class);
    }
}
