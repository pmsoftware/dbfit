package dbfit.environment;

import java.text.DateFormat;

public class TeradataDatePeriodParseDelegate {

    private static DateFormat df = DateFormat.getDateInstance();	

    public static Object parse(String s) throws Exception {

        String[] periodParts = s.split(",");
        java.sql.Date F;
        java.sql.Date T;
        java.util.Date ParsedFrom;
        java.util.Date ParsedTo;

        try {
            F = java.sql.Date.valueOf(periodParts[0]);
        }
        catch (IllegalArgumentException iex) {
            java.util.Date ud = df.parse(periodParts[0]);
            F = new java.sql.Date(ud.getTime());
        }

        try {
            T = java.sql.Date.valueOf(periodParts[1]);
        }
        catch (IllegalArgumentException iex) {
            java.util.Date ud = df.parse(periodParts[1]);
            T = new java.sql.Date(ud.getTime());
        }

        Object[] data = { F, T }; 
        return new TeradataDatePeriod(data);
    }
}
