package test.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
public class GetCommentsPojo {
    private int code;
    private Object meta;
    private Map<String,Object>pagination;
    private Map<String,Object>data;
}
