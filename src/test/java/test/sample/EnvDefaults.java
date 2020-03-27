package test.sample;

public class EnvDefaults {

    public static final String IP_ADD = "192.168.0.14";
    public static final String AUTH_CODE = "test";

    public static String getBaseURI() {
        return "http://" + IP_ADD + "/sony";
    }

    public static String getAuthCode() {
        return AUTH_CODE;
    }
}
