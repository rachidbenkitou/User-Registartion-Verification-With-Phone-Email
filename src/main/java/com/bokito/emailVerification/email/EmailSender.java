package com.bokito.emailVerification.email;

public interface EmailSender {
    void send(String to, String email);
}
