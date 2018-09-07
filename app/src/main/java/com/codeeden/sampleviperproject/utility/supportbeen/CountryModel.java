package com.codeeden.sampleviperproject.utility.supportbeen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryModel {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dial_code")
    @Expose
    private String dialCode;
    @SerializedName("code")
    @Expose
    private String code;

    /**
     * No args constructor for use in serialization
     *
     */
    public CountryModel() {
    }

    /**
     *
     * @param name
     * @param code
     * @param dialCode
     */
    public CountryModel(String name, String dialCode, String code) {
        super();
        this.name = name;
        this.dialCode = dialCode;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDialCode() {
        return dialCode;
    }

    public void setDialCode(String dialCode) {
        this.dialCode = dialCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
