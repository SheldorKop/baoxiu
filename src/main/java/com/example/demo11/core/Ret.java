package com.example.demo11.core;

public class Ret {

    public static String SUCCESS="200";
    public static String ERROR="500";

    String code;
    String message;
    Object data;

    public Ret(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Ret SUCCESS(){
        return new Ret(Ret.SUCCESS,"",null);
    }

    public static Ret SUCCESS(String message){
        return new Ret(Ret.SUCCESS,message,null);
    }


    public static Ret SUCCESS(String message,Object data){
        return new Ret(Ret.SUCCESS,message,data);
    }

    public static Ret ERROR(){
        return new Ret(Ret.ERROR,"",null);
    }

    public static Ret ERROR(String message){
        return new Ret(Ret.ERROR,message,null);
    }


    public static Ret ERROR(String message,Object data){
        return new Ret(Ret.ERROR,message,data);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
