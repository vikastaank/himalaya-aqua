package com.himalaya.aqua.aqua.services.security;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
