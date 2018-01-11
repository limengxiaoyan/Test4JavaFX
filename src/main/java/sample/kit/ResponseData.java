package sample.kit;

/**
 * Created by chenli on 2018/1/11 0011.
 */
public class ResponseData<T> {
    public boolean status = true;
    public int code;
    public String msg;
    public T body;

    public ResponseData(boolean status, String msg, T body, int code) {
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.body = body;
    }

    public ResponseData() {
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getBody() {
        return this.body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public void setError(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.status = false;
    }

    public void setError(String msg) {
        this.status = false;
        this.msg = msg;
    }

    public static ResponseData fail() {
        return new ResponseData(false, "操作成功", (Object)null, 0);
    }

    public static ResponseData success() {
        return new ResponseData(true, "操作失败", (Object)null, 0);
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "status=" + status +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", body=" + body +
                '}';
    }
}