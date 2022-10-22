package claro.test.myapplication2.model;

import com.google.gson.annotations.SerializedName;

/**
 * ***Created by: Edison Martinez,
 * ***Date:21,Friday,2022,
 * ***Proyect: My Application 2.
 **/
public class Name {

    @SerializedName("common")
    private String common;

    @SerializedName("official")
    private String official;


    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }
}
