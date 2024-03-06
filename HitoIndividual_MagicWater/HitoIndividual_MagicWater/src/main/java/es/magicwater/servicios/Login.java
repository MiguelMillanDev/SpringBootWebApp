package es.magicwater.servicios;

import es.magicwater.jpa.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class Login {
    private Usuario login;

    public Login() {
        login = null;
    }
    public Usuario getLogin() {
        return login;
    }

    public void setLogin(Usuario login) {
        this.login = login;
    }
}
