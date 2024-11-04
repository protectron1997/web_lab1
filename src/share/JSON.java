package share;

public class JSON {

    public static String genStandardJSON(String result, String timeExec, String date){
        String json = """
                {
                "result": "%s",
                "time_exec": "%s",
                "date": "%s"
                }
                """;
        return json.formatted(result,timeExec,date);
    }
}
