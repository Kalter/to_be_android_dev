package com.akvelon.myfirstapp.lesson4.rxintro;

class RxIntroStepTwo {

    public static void main(String[] args) {
        UserManager um = new UserManagerStub();
        System.out.println(um.getUser());

        um.setName("Jane Doe", new Runnable() {
            @Override
            public void run() {
                System.out.println(um.getUser());
            }
        });
    }

    private interface UserManager {
        User getUser();

        void setName(String name, Runnable callback);

        void setAge(int age, Runnable callback);
    }

    private static class UserManagerStub implements UserManager {

        @Override
        public User getUser() {
            return null;
        }

        @Override
        public void setName(String name, Runnable callback) {

        }

        @Override
        public void setAge(int age, Runnable callback) {

        }
    }

}
