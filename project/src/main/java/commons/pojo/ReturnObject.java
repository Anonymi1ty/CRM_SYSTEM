//因为Map实体类对象会降低查询效率，所以在这里使用了一个自定义的实体类对象ReturnObject，用于封装返回值
package commons.pojo;

public class ReturnObject {
    private String code;//处理结果的状态码 1---成功，0---失败
    private String message;//提示信息
    private Object data;//返回的其他数据

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
