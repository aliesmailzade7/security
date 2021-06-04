package coach.barnamenevis.security.security;

import coach.barnamenevis.security.users.domain.Role;
import coach.barnamenevis.security.users.domain.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//جزئیات یوزر رو برمیگردونه

public class UserDetailsImpl implements UserDetails {

    private Users users;

    public UserDetailsImpl(Users users) {
        this.users = users;
    }

    @Override //لیست نقش یوزر ها رو برمیگردونه
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = users.getRoles();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Role r : roles) {
            grantedAuthorities.addAll(r.getAuthorities());
        }

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return users.isEnabled();
    }
}
