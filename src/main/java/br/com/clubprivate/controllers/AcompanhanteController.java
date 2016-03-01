package br.com.clubprivate.controllers;

import br.com.clubprivate.models.Acompanhante;
import br.com.clubprivate.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acompanhante")
public class AcompanhanteController extends AbstractController<Acompanhante, Long> {

    public AcompanhanteController() {
        super(Acompanhante.class);
    }
}
