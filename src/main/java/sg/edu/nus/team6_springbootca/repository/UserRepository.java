package sg.edu.nus.team6_springbootca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.edu.nus.team6_springbootca.model.User;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName UserRepository
 * @Description Repository interface for User entity, which is to provide CRUD
 *              operations
 *              and conduct custom queries.
 * @Author JIA QIANRUI
 * @StudentID A0335225L
 * @Date 2025/10/2
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a user by username.
     *
     * @param username the username of the user
     * @return an Optional containing the user if found
     */
    Optional<User> findByUsername(String username);

    /**
     * Find a user by email.
     *
     * @param email the email of the user
     * @return an Optional containing the user if found
     */
    Optional<User> findByEmail(String email);

    /**
     * Find a user by phone number.
     *
     * @param phone the phone number of the user
     * @return an Optional containing the user if found
     */
    Optional<User> findByPhone(String phone);

    /**
     * Check if a user exists by username.
     *
     * @param username the username to check
     * @return true if a user with the given username exists
     */
    boolean existsByUsername(String username);

    /**
     * Check if a user exists by email.
     *
     * @param email the email to check
     * @return true if a user with the given email exists
     */
    boolean existsByEmail(String email);

    /**
     * Check if a user exists by phone number.
     *
     * @param phone the phone number to check
     * @return true if a user with the given phone number exists
     */
    boolean existsByPhone(String phone);

    /**
     * Find users by first name and last name (case-insensitive).
     *
     * @param firstName the first name to search for
     * @param lastName  the last name to search for
     * @return a list of users with the specified first and last name
     */
    List<User> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);

    /**
     * Fuzzy query to search for users by username, email, phone, first name, or
     * last name.
     *
     * @param keyword the keyword to search for in username, email, phone, first
     *                name, or last name
     * @return a list of users matching the search criteria
     */
    @Query("SELECT u FROM User u WHERE " +
            "LOWER(u.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(u.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(u.phone) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(u.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(u.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<User> searchByKeyword(@Param("keyword") String keyword);

    /**
     * Find users created after a specific date.
     *
     * @param date the date to compare against
     * @return a list of users created after the specified date
     */
    List<User> findByCreatedAtAfter(java.time.LocalDateTime date);

    /**
     * Find users created before a specific date.
     *
     * @param date the date to compare against
     * @return a list of users created before the specified date
     */
    List<User> findByCreatedAtBefore(java.time.LocalDateTime date);

    /**
     * Find users by username or email.
     *
     * @param username the username to search for
     * @param email    the email to search for
     * @return an Optional containing the user if found by either username or email
     */
    @Query("SELECT u FROM User u WHERE u.username = :username OR u.email = :email")
    Optional<User> findByUsernameOrEmail(@Param("username") String username, @Param("email") String email);

}