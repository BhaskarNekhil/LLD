public class Main {
    public static void main(String[] args) {
        // Using SQL Fetch
        Fetch sqlFetch = new SqlFetch();
        final UserService userService = new UserService(sqlFetch);
        userService.getData("123");

        // Switching to MongoDB Fetch
        Fetch mongoFetch = new MongoFetch();
        userService.setFetch(mongoFetch);
        userService.getData("456");
    }
}
