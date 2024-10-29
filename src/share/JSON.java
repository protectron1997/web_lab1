package share;

public class JSON {
    private static String json = """
            {
            "result": "%s",
            "time_exec": "%s",
            "date": "%s"
            }
            """;

    public static String genStandardJSON(String result, String timeExec, String date){
        return json.formatted(result,timeExec,date);
    }
}
