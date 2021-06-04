package coach.barnamenevis.security.users.service;

import coach.barnamenevis.security.users.domain.Users;
import coach.barnamenevis.security.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl {

    @Autowired
    private UsersRepository usersRepository;

    @PostAuthorize("returnObject.email == authentication.name")
    public Optional<Users> getById(long id){
        return usersRepository.findById(id);
    }
    public List<Users> getAll(){
        return usersRepository.findAll();
    }

}
