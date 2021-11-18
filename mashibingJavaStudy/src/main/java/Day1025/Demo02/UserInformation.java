package Day1025.Demo02;

import java.io.Serializable;

/**
 * @author 孙珑瑜
 * @version 211027
 * 用户类
 */
public class UserInformation implements Serializable {
    private static final long serialVersionUID = 5025773303097075876L;
    private String name;//用户名
    private String pwd;//密码

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public UserInformation(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
}
