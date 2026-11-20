package ir.maktabsharif.jpa.utils;

public class SecurityContextHolder {

    //    private static final ThreadLocal<String> CURRENT_USERNAME = new ThreadLocal<>();
//    private static final ThreadLocal<String> CURRENT_USERNAME = ThreadLocal.withInitial(() -> "default value");
    private static final ThreadLocal<String> CURRENT_USERNAME = new InheritableThreadLocal<>();

    public static void setUsername(String username) {
        CURRENT_USERNAME.set(username);
    }

    public static String getUsername() {
        return CURRENT_USERNAME.get();
    }

    public static void clear() {
        CURRENT_USERNAME.remove();
    }
}
