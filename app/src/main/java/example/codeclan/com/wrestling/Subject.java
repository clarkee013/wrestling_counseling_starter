package example.codeclan.com.wrestling;

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import db.SqlRunner;

import static example.codeclan.com.wrestling.Subject.all;

/**
 * Created by user on 26/06/2017.
 */

public class Subject {

    private String name;
    private String description;
    private int id;
    private int counselor_id;

    public Subject(String name, String description, int counselor_id) {
        this.name = name;
        this.description = description;
        this.counselor_id = counselor_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCounselor_id() {
        return counselor_id;
    }

    public int getSubject_id() {
        return id;
    }

    public static void all(){
        String sql = String.format("SELECT * FROM subjects;");
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                int counselor_id = rs.getInt("counselor_id");
                System.out.println("Title: " + title);
                System.out.println("Description: " + description);
                System.out.println("Counselor_ID: " + counselor_id);
                System.out.println();
            }
        } catch (Exception ex){
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }

    }

    public static void getAllDetails() {
        String sql = String.format("SELECT subjects.name, counselors.first_name, counselors.nick_name, counselors.last_name, counselors.member_since, counselors.email, counselors.telephone FROM subjects INNER JOIN counselors on counselors.id = subjects.counselor_id WHERE subjects.id = %d;", this.id);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String description = rs.getString("description");
                String first_name = rs.getString("first_name");
                String nick_name = rs.getString("nick_name");
                String last_name = rs.getString("last_name");
                String member_since = rs.getString("member_since");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                System.out.println("Description: " + description);
                System.out.println("First Name: " + first_name);
                System.out.println("Nickname: " + nick_name);
                System.out.println("Last Name: " + last_name);
                System.out.println("Member Since:" + member_since);
                System.out.println("Email Address: " + email);
                System.out.println("Telephone Number: " + telephone);
            }
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }

    }

    public static ResultSet listSubjectIdAndName() {
        String sql = String.format("SELECT id, name FROM subjects;");
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id + " " + name);
            }
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        } return rs;
    }

    public static int selector() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please make a selection: ");
        return sc.nextInt();
    }



}




