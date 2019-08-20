package utils.impl;

import model.User;


public  class ContexHolderImpl  {
    private static User user;

    public static User getCurrentUser() {
        return user;
    }

    public static void setCurrentUser(User user) {
        ContexHolderImpl.user=user;
    }
}
