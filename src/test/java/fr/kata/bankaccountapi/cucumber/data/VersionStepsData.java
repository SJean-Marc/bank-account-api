package fr.kata.bankaccountapi.cucumber.data;

public class VersionStepsData {
    private static int status;
    private static String version;

    public static int getStatus() {
        return status;
    }

    public static void setVersionAndStatusCode(String version, int status) {
        VersionStepsData.version = version;
        VersionStepsData.status = status;
    }

    public static String getVersion() {
        return version;
    }
}
