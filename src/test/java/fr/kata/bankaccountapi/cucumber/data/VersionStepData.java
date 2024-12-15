package fr.kata.bankaccountapi.cucumber.data;

public class VersionStepData {
    private static int status;
    private static String version;

    public static int getStatus() {
        return status;
    }

    public static void setVersionAndStatusCode(String version, int status) {
        VersionStepData.version = version;
        VersionStepData.status = status;
    }

    public static String getVersion() {
        return version;
    }
}
