package jay.fishcatchmonitoringsystem.Users.Repository;

import jay.fishcatchmonitoringsystem.Users.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}
