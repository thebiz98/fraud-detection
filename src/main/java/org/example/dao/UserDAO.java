package org.example.dao;

import java.util.Set;

public class UserDAO {

    public Set<String> getUSerDevices() {
        return Set.of("dev-xyz");
    }

    public Set<String> getUserLocations() {
        return Set.of("Delhi");
    }
}
