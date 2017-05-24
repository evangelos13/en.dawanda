package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CredentialGenerator {

    private static final String DATE_PATTERN = "yyyMMdd_HHmmss";
    private static final String FRONTEND_TEST_USER = "frontend-test-user-";
    private static final String DOMAIN = "@dawandamail.com";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String USER_NAME = "nickName";

    private static String getCurrentDateTime() {
        return new SimpleDateFormat(DATE_PATTERN).format(Calendar.getInstance().getTime());
    }

    public static String generateEmail(){
        return FRONTEND_TEST_USER + getCurrentDateTime() + DOMAIN;
    }

    public static String generatePassword(){
        return FRONTEND_TEST_USER + getCurrentDateTime();
    }

    public static String getFirstName() {
        return FIRST_NAME + getCurrentDateTime();
    }

    public static String getLastName() {
        return LAST_NAME + getCurrentDateTime();
    }

    public static String getUserName() {
        return USER_NAME + getCurrentDateTime();
    }
}
