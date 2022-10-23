package com.final_project.staselko.utils.param;

import org.springframework.stereotype.Component;

@Component
public class ParamCreator {

    public String getParamToURL(String str){
        return str.replace(" ", "+").replace("&", "%26");
    }
    public String getParamToDB(String str){
        return str.replace("+", " ").replace("%26", "&");
    }

    public Long getParamLongToDB(String str){
        return Long.parseLong(str);
    }
}
