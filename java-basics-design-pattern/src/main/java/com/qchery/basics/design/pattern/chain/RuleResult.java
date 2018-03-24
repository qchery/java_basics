package com.qchery.basics.design.pattern.chain;

/**
 * @author Chery
 * @date 2017/8/9 - 下午11:05
 */
public class RuleResult {

    public static final int CODE_REJECT = 0;
    public static final int CODE_WARN = 1;
    public static final int CODE_ERROR = -1;

    private int code;

    private String msg;

    public RuleResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RuleResult that = (RuleResult) o;

        if (code != that.code) return false;
        return msg != null ? msg.equals(that.msg) : that.msg == null;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RuleResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
