package com.eva.controller;

import com.eva.model.User;

public class Login {
//    private void login(ActionEvent event) throws IOException {
//        UserDAO checkLogin = new UserDAO();
//        try {
//            if (email.getText().equals("") || password.getText().equals("")){
//                errorLabel.setText("Fill the form");
//            }else{
//                User loginAttempt = UserDAO.searchUsersByEmail(email.getText());
//                if (loginAttempt != null){
//                    Password checkCredentials = new Password();
//                    if (Password.verifyHash(password.getText(), loginAttempt.getPassword())){
//                        System.out.println("password match");
//                        //redirect
//
//                        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/application.fxml"));
//                        Parent root = loader.load();
//
//                        Application appController = loader.getController();
//                        appController.loadUser(loginAttempt);
//
//                        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//                        stage.hide();
//                        stage.setMinHeight(600);
//                        stage.setMinWidth(800);
//                        stage.setScene(new Scene(root));
//                        stage.setResizable(true);
//                        stage.show();
//
//
//                    }else{
//                        errorLabel.setText("Oh snap! Double check the email or password");
//                    }
//                }else{
//                    errorLabel.setText("Invalid account");
//                }
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//    }




}
