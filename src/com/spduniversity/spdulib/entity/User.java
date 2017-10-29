package com.spduniversity.spdulib.entity;

public class User {
    private long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private int gender;      // male, female, trasgender
    private String role;// user, editor, moderator

    public static class Builder {
        private long id;
        private String login;
        private String password;
        private String firstName;
        private String lastName;
        private int gender;
        private String role;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder gender(int gender) {
            this.gender = gender;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

    public User (Builder builder) {
        id = builder.id;
        login = builder.login;
        password = builder.password;
        firstName = builder.firstName;
        lastName = builder.lastName;
        gender = builder.gender;
        role = builder.role;
    }

    public long getId() {
        return id;
    }

    public User setId(long id) {
        return new Builder()
                .id(id)
                .login(login)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .role(role)
                .build();
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        return new Builder()
                .id(id)
                .login(login)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .role(role)
                .build();
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        return new Builder()
                .id(id)
                .login(login)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .role(role)
                .build();
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        return new Builder()
                .id(id)
                .login(login)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .role(role)
                .build();
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        return new Builder()
                .id(id)
                .login(login)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .role(role)
                .build();
    }

    public int getGender() {
        return gender;
    }

    public User setGender(int gender) {
        return new Builder()
                .id(id)
                .login(login)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .role(role)
                .build();
    }

    public String getRole() {
        return role;
    }

    public User setRole(String role) {
        return new Builder()
                .id(id)
                .login(login)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .role(role)
                .build();
    }
}
