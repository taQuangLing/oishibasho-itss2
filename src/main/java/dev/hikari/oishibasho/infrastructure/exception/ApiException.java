package dev.hikari.oishibasho.infrastructure.exception;

import dev.hikari.oishibasho.infrastructure.utilies.MessageCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiException extends RuntimeException{
    private int code;
    private String message;
    private String description;
    private Object data;

    public ApiException(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }
    public ApiException(MessageCode messageCode){
        this.code = messageCode.getCode();
        this.message = messageCode.getMessage();
        this.description = messageCode.getDescription();
    }
    public ApiException(MessageCode messageCode, Object data){
        this.code = messageCode.getCode();
        this.message = messageCode.getMessage();
        this.description = messageCode.getDescription();
        this.data = data;
    }
    public void setMessageCode(MessageCode messageCode){
        this.code = messageCode.getCode();
        this.message = messageCode.getMessage();
        this.description = messageCode.getDescription();
    }
    public void setMessageCode(MessageCode messageCode, Object data){
        setMessageCode(messageCode);
        this.data = data;
    }

}
