package me.kvngleissner;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) {
        try {
            JavaBot bot = new JavaBot();
        } catch (LoginException e) {
            System.out.println("Errro: Invalid Token provided");
        }
    }
}