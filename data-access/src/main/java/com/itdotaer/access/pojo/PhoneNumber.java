package com.itdotaer.access.pojo;

/**
 * Created by jt_hu on 2017/1/3.
 */
public class PhoneNumber {
    private String countryCode;
    private String number;

    public PhoneNumber(){};

    public PhoneNumber(String countryCode, String number){
        this.countryCode = countryCode;
        this.number = number;
    }

    public PhoneNumber(String string){
        if(string != null){
            String[] parts = string.split("-");
            if(parts.length > 0){
                this.countryCode = parts[0];
            }
            if(parts.length > 1){
                this.number = parts[1];
            }
        }
    }

    @Override
    public String toString() {
        return countryCode + "-" + number;
    }
}
