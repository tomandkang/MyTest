package com.example.testcommon.commom.eventListener;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
@ToString
public class TwoEvent extends ApplicationEvent {

    private String  name;

    public TwoEvent() {
        super("TwoEvent async message");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
