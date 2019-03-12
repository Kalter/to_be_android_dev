package com.akvelon.myfirstapp.lesson4.rxintro;

class RxIntroStepOne {
    public static void main(String[] args) {
        UserManager um = new UserManagerStub();
        System.out.println(um.getUser());

        um.setName("Jane Doe");
        System.out.println(um.getUser());
    }

    private interface UserManager {
        User getUser();

        void setName(String name);

        void setAge(int age);
    }

    private static class UserManagerStub implements UserManager {

        @Override
        public User getUser() {
            // return user
            return null;
        }

        @Override
        public void setName(String name) {
            // setting name
        }

        @Override
        public void setAge(int age) {
            // setting age
        }
    }
}


