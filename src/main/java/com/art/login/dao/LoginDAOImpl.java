package com.art.login.dao;

import com.art.login.dto.User;

import java.sql.*;

public class LoginDAOImpl implements LoginDAO {

    private Connection con;
    static Statement st;

    public Boolean connect() {
        Boolean b = false;
        try {
            // for testing table name try change when connect to real db
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/try", "root", "root");
            st = this.con.createStatement();
            b = true;

        } catch (Exception e) {

        }

        return b;

    }


    //when registering a new user
    public Boolean checkEmail(User u) {
        Boolean b = true;
        try {
            ResultSet rs = st.executeQuery("select email from users;");
            while (rs.next()) {
                if (rs.getString("email").equals(u.getEmail())) {
                    b = false;
                    return b;
                }
            }

        } catch (Exception e) {
            System.out.println();
        }

        return b;

    }

    @Override
    public Boolean registerUser(User u) {

        try {
            if (checkEmail(u)) {
                PreparedStatement userAddQuery = con.prepareStatement("insert into users(name,email,password,contact,country,dob) values(?,?,?,?,?,?)");
                userAddQuery.setString(1, u.getName());
                userAddQuery.setString(2, u.getEmail());
                userAddQuery.setString(3, u.getPassword());
                userAddQuery.setString(4, u.getContact());
                userAddQuery.setString(5, u.getCountry());
                userAddQuery.setDate(6, u.getDob());
                System.out.println(userAddQuery);
                userAddQuery.executeUpdate();

                return true;

            }

        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public Boolean verifyUser(User u) {

        Boolean b = false;
        try {
            System.out.println("select email,password from Users where email='" + u.getEmail() + "'");
            ResultSet rs = st.executeQuery("select email,password from Users where email='" + u.getEmail() + "'");
            while (rs.next()) {

                if (rs.getString("email").equals(u.getEmail()) && rs.getString("password").equals(u.getPassword())) {
                    b = true;
                }

            }
        } catch (Exception e) {

        }

        return b;

    }

    @Override
    public Boolean resetPassword(User u) {
        Boolean b = false;
        try {
            System.out.println("select password from Users where email='" + u.getEmail() + "'");
            ResultSet rs = st.executeQuery("select password from Users where email='" + u.getEmail() + "'");

            while (rs.next()) {
//
                if (rs.getString("password").equals(u.getPassword())) {
                    String newPassword = u.getNewPassword();
//                    System.out.println(newPassword);
                    String updatePasswordQuery = "update users set password='" + newPassword + "' where email='" + u.getEmail() + "'";
                    System.out.println(updatePasswordQuery);
                    st.executeUpdate(updatePasswordQuery);

                    b = true;
                }

            }
        } catch (Exception x) {
            System.out.println("Catch Block");
        }

        return b;
    }

    @Override
    public User getProfile(String email) {
        User user = null;
        try {

            String viewQuery = "select * from users where email='" + email + "'";
            System.out.println(viewQuery);
            ResultSet rs = st.executeQuery(viewQuery);

            while (rs.next()) {
                String name = rs.getString("name");
                String email1 = rs.getString("email");
                String contact = rs.getString("contact");
                String country = rs.getString("country");
                Date dob = rs.getDate("dob");

                user = new User(name, email1, contact, country, dob);
                System.out.print(user);
            }
        } catch (Exception e) {

        }
        return user;

    }


}
