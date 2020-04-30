package com.memory.Journal.userHelper;

import com.memory.Journal.model.User;

public class UserHelperImpl implements UserHelper {

    @Override
    public void updateUserDetails(User storedUser, User updatedDetailsUser) {
        storedUser.setDateOfBirth(updatedDetailsUser.getDateOfBirth());
        storedUser.setEmail(updatedDetailsUser.getEmail());
        storedUser.setEnrolledOn(updatedDetailsUser.getEnrolledOn());
        storedUser.setFirstName(updatedDetailsUser.getFirstName());
        storedUser.setLastName(updatedDetailsUser.getLastName());
        storedUser.setPassword(updatedDetailsUser.getPassword());
    }
}
