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

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
