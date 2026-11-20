package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.utils.SecurityContextHolder;

public class JpaApplication {

    static void main() throws InterruptedException {
        printCurrentUsernameAndLogin("mohsen");
        Thread first = new Thread(
                () -> printCurrentUsernameAndLogin("mat"), "first"
        );
        Thread second = new Thread(
                () -> printCurrentUsernameAndLogin("asgari"), "second"
        );
        first.start();
        second.start();

        first.join();
        second.join();
        System.out.println("current username in thread: " + Thread.currentThread().getName() + " is " + SecurityContextHolder.getUsername());
    }

    private static void printCurrentUsernameAndLogin(String username) {
        System.out.println("current username in thread: " + Thread.currentThread().getName() + " is " + SecurityContextHolder.getUsername());
        login(username);
        System.out.println("current username in thread: " + Thread.currentThread().getName() + " is " + SecurityContextHolder.getUsername());
    }

    static void login(String username) {
//        login logic
        SecurityContextHolder.setUsername(username);
    }

    static String getCurrentUsername() {
        return SecurityContextHolder.getUsername();
    }

}