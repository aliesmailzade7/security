package coach.barnamenevis.security;

import coach.barnamenevis.security.users.domain.Users;
import coach.barnamenevis.security.users.service.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@Controller
public class MainController {

    @Autowired
    UsersServiceImpl usersService;

    @GetMapping
    public String indexPage() {
        return "index";
    }


    @GetMapping("/user")
    @PreAuthorize("hasAuthority('OP_ACCESS_USER')")
    public String userPage() {
        return "user";
    }


    @GetMapping("/user/get")
    @PreAuthorize("hasAuthority('OP_GET_USERS')")
    public @ResponseBody
    List<Users> getUser() {
        return usersService.getAll();
    }


    @GetMapping("/user/get/{id}")
    public @ResponseBody
    Optional<Users> getUser(@PathVariable long id) {
        return usersService.getById(id);
    }


    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('OP_ACCESS_ADMIN')")
    public String adminPage() {
        return "admin";
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
