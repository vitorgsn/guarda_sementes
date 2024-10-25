package br.com.ifs.edu.guarda_sementes.configs;

import br.com.ifs.edu.guarda_sementes.enums.Role;
import br.com.ifs.edu.guarda_sementes.models.RoleModel;
import br.com.ifs.edu.guarda_sementes.models.UserModel;
import br.com.ifs.edu.guarda_sementes.repositories.IRoleRepository;
import br.com.ifs.edu.guarda_sementes.repositories.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private final IRoleRepository roleRepository;
    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(IRoleRepository roleRepository, IUserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        var roleAdmin = roleRepository.findByName(Role.ADMIN.name());

        if (roleAdmin == null) {
            var role = new RoleModel();
            role.setName("ADMIN");
            roleRepository.save(role);
        }

        var roleUser = roleRepository.findByName(Role.USER.name());

        if (roleUser == null) {
            var role = new RoleModel();
            role.setName("USER");
            roleRepository.save(role);
        }

        var roleAdminCreated = roleRepository.findByName(Role.ADMIN.name());


        var userAdmin = userRepository.findByEmail("admin@guardasementes.com");

        userAdmin.ifPresentOrElse(
                (user) -> {
                    System.out.println("admin user already exists.");
                },
                () -> {
                    var user = new UserModel();
                    user.setFirstName("Admin");
                    user.setLastName("Guarda Sementes");
                    user.setEmail("admin@guardasementes.com");
                    user.setPassword(passwordEncoder.encode("guardasementes"));
                    user.setRoles(Set.of(roleAdminCreated));
                    userRepository.save(user);
                }
        );

    }
}
