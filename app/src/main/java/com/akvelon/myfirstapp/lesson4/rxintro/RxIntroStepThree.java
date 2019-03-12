package com.akvelon.myfirstapp.lesson4.rxintro;

import java.io.IOException;

class RxIntroStepThree {

    public static void main(String[] args) {
        UserManager um = new UserManagerStub();
        System.out.println(um.getUser());

        um.setName("Jane Doe", new UserManager.Listener() {
            @Override
            public void success() {
                System.out.println(um.getUser());
            }

            @Override
            public void failure(IOException e) {
                // TODO show the error...
            }
        });

        um.setAge(40, new UserManager.Listener() {
            @Override
            public void success() {
                System.out.println(um.getUser());
            }

            @Override
            public void failure(IOException e) {
                // TODO show the error…
            }
        });
    }

    private interface UserManager {
        User getUser();

        void setName(String name, Listener callback);

        void setAge(int age, Listener callback);

        interface Listener {
            void success();

            void failure(IOException e);
        }
    }

    static class UserManagerStub implements UserManager {

        @Override
        public User getUser() {
            return null;
        }

        @Override
        public void setName(String name, Listener callback) {

        }

        @Override
        public void setAge(int age, Listener callback) {

        }
    }

}
