package com.lemondeperdu.Le.Monde.Perdu.infrastructure.configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class ValidatorConfig {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$",
            Pattern.CASE_INSENSITIVE
    );

    private static final Pattern PSEUDO_PATTERN = Pattern.compile( "^[\\p{L}0-9](?:[\\p{L}0-9_-]{1,18}[\\p{L}0-9])?$",
            Pattern.CASE_INSENSITIVE);

    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,20}$"
    );

    private static final Set<String> SQL_KEYWORDS = new HashSet<>(Arrays.asList(
            "SELECT", "INSERT", "UPDATE", "DELETE", "DROP", "ALTER",
            "CREATE", "TRUNCATE", "EXEC", "UNION", "MERGE", "CALL"
    ));

    public static boolean isSafeEmail(String email) {
        if (email == null) return false;
        if (!EMAIL_PATTERN.matcher(email).matches()) return false;
        return !SQL_KEYWORDS.contains(email.toUpperCase());
    }

    public static boolean isValidPassword(String password) {
        if (password == null) return false;
        if(!PASSWORD_PATTERN.matcher(password).matches()) return false;
        return !SQL_KEYWORDS.contains(password.toUpperCase());
    }

    public static boolean isValidPseudo(String pseudo) {
        if (pseudo == null) return false;
        if(!PASSWORD_PATTERN.matcher(pseudo).matches()) return false;
        return !SQL_KEYWORDS.contains(pseudo.toUpperCase());

    }
}

