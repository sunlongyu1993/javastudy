package pojo;

import java.sql.Date;

/**
 * @author 孙珑瑜
 * @version 220729
 */
public class Accout {
    private  int level_Id;
    private String level_desc;
    private Date addtime;
    private Date updatetime;
    private  int del;

    public int getLevel_Id() {
        return level_Id;
    }

    public void setLevel_Id(int level_Id) {
        this.level_Id = level_Id;
    }

    public String getLevel_desc() {
        return level_desc;
    }

    public void setLevel_desc(String level_desc) {
        this.level_desc = level_desc;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "Accout{" +
                "level_Id=" + level_Id +
                ", level_desc='" + level_desc + '\'' +
                ", addtime=" + addtime +
                ", updatetime=" + updatetime +
                ", del=" + del +
                '}';
    }
}
