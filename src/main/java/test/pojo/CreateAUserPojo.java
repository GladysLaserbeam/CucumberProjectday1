package test.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
public class CreateAUserPojo {

    private int code;
    private String meta;
    private Map<String,Object>data;



}
