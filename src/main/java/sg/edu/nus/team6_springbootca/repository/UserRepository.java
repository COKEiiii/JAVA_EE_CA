package sg.edu.nus.team6_springbootca.repository;

import sg.edu.nus.team6_springbootca.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 根据用户名查找用户（用于登录验证）
    Optional<User> findByUsername(String username);

    // 检查用户名是否已存在
    Boolean existsByUsername(String username);

    // 检查邮箱是否已存在
    Boolean existsByEmail(String email);
}
