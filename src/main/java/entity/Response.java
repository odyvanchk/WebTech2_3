package entity;

import java.io.Serializable;

public class Response implements Serializable {
    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    private Object body;

}
