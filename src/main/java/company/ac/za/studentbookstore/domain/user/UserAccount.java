package company.ac.za.studentbookstore.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class UserAccount {
    @Id
    private String email;
    private String password;
    private String account_status;
    private String roleId;
    private Date date;

    private UserAccount() {
    }

    public UserAccount(Builder builder) {
        this.account_status=builder.account_status;
        this.date=builder.date;
        this.email=builder.email;
        this.password=builder.password;
        this.roleId = builder.role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getAccount_status() {
        return account_status;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", account_status='" + account_status + '\'' +
                ", date=" + date +
                '}';
    }

    public static class Builder{
        private String email;
        private String password;
        private String account_status;
        private String role;
        private Date date;

        public Builder(String email){
            this.email=email;
        }
        public Builder buildPassword(String password){
            this.password=password;
            return this;
        }
        public Builder buildRole(String role){
            this.role = role;
            return this;
        }
        public Builder buildAccountStatus(String account_status){
            this.account_status=account_status;
            return this;
        }
        public Builder buildDate(Date date){
            this.date=date;
            return this;
        }
        public UserAccount build(){
            return new UserAccount(this);
        }
    }
}
