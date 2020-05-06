package com.eva.helpers;

import org.mindrot.jbcrypt.BCrypt;

public class Password {
    public static String encryptPassword(String password){
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        return passwordHash;
    }
    public static Boolean checkPassword(String plaintextPassword, String hashed){
        return BCrypt.checkpw(plaintextPassword, hashed);
    }
}
