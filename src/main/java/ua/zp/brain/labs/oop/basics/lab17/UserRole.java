package ua.zp.brain.labs.oop.basics.lab17;

/**
 * Roles for authorisation control of access to {@link Store}
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
enum UserRole {
    ROLE_DIRECTOR("ROLE_DIRECTOR"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_MANAGER("ROLE_MANAGER"),
    ROLE_CLIENT("ROLE_CLIENT"),
    ROLE_USER("ROLE_USER");

    private final String role;

    /**
     * Construct Role
     *
     * @param role String representation of Role
     */
    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
