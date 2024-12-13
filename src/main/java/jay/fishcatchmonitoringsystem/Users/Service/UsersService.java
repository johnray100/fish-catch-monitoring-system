package jay.fishcatchmonitoringsystem.Users.Service;

import jay.fishcatchmonitoringsystem.Users.Dto.UsersRegistrationDto;
import jay.fishcatchmonitoringsystem.Users.Models.Role;
import jay.fishcatchmonitoringsystem.Users.Models.Users;
import jay.fishcatchmonitoringsystem.Users.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByEmail(username);
        if (users == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(), mapRolesToAuthorities(users.getRoles()));
    }

    public Users save(UsersRegistrationDto userRegistrationDto){
        Users user = new Users();
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));

        List<Role> roles = new ArrayList<Role>();
        Role role = new Role();
        role.setName("ROLE_USER");
        roles.add(role);
        user.setRoles(roles);

        return userRepository.save(user);
    }
}
