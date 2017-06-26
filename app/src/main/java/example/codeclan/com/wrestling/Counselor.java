package example.codeclan.com.wrestling;

import static android.R.attr.name;

/**
 * Created by user on 26/06/2017.
 */


public class Counselor {

    private String first_name;
    private String nick_name;
    private String last_name;
    private String telephone;
    private String email;
    private String member_since;
    private int id;


    public Counselor(String first_name, String nick_name, String last_name,
                     String telephone, String email, String member_since) {
        this.first_name = first_name;
        this.nick_name = nick_name;
        this.last_name = last_name;
        this.telephone = telephone;
        this.email = email;
        this.member_since = member_since;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getMember_since() {
        return member_since;
    }
}



