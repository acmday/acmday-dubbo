package com.acmday.dubbo.provider.bo;

import org.springframework.stereotype.Component;

/**
 * @author acmday.
 * @date 2020/6/28.
 */
@Component
public class Rain {

    private String level;

    public void print(){
        System.out.println("---- rain -----");
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
