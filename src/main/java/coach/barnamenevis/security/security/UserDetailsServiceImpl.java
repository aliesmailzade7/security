package coach.barnamenevis.security.security;

import coach.barnamenevis.security.users.domain.Users;
import coach.barnamenevis.security.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

//براساس نام یوزر جستجو میکنه و جزئیات یوزر رو برمیگردونه

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(userName);
        if (user==null){
            throw new UsernameNotFoundException("Username Not Found");
        }
        return new UserDetailsImpl(user);
    }
}
