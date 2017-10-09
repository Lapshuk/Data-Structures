import java.util.*;
import java.util.stream.Collectors;

public class UserExercises extends DBTable<User> {
    UserExercises() {
    }

    UserExercises(Collection<User> lst) {
        super(lst);
    }

    /**
     * Get an ordered List of Users, sorted first on age,
     * then on their id if the age is the same.
     */
    public List<User> getOrderedByAgeThenId() {
        return entries.stream()
                .sorted(Comparator.comparing(User::getAge).thenComparing(User::getId))
                .collect(Collectors.toList());
    }

    /**
     * Get the average age of all the users.
     * If there are no users, the average is 0.
     */
    public double getAverageAge() {
        return entries.stream()
                    .mapToDouble(entry -> entry.getAge())
                    .average()
                    .orElse(0);

    }

    /**
     * Group usernames by user age, for all users that have an age greater than min_age.
     * Usernames with ages less than or equal to min_age are excluded.
     * Returns a Map from each age present to a list of the usernames that have that age.
     */
    public Map<Integer, List<String>> groupUsernamesByAgeOlderThan(int min_age) {
        return entries.stream()
                .filter(entry -> entry.getAge() > min_age)
                .collect(Collectors.groupingBy(User::getAge,
                        Collectors.mapping(User::getUsername, Collectors.toList())));
    }

    public static void main(String[] args) {
        User[] users = {new User(2, "christine", ""), new User(4, "antares", ""), new User(5, "ching", ""),
                new User(1, "daniel", ""), new User(1, "dan", "")};
        Arrays.sort(users);
        System.out.println(Arrays.toString(users));
    }
}
