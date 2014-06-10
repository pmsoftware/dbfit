package dbfit.environment;

import java.sql.*;

public class TeradataTimePeriod extends DbStruct {

    public TeradataTimePeriod(Object[] dates) {
        super("PERIOD(TIME)", dates);
    }

    public String toString() {
        
        String r = "";

        try {
            Object[] a = super.getAttributes();

            for (int i = 0; i < a.length; i++) {
                if (i > 0)
                    r = r + ",";

                r = r + a[i].toString();
            }
        }
        catch (SQLException e){
            throw new Error("TeradataTimePeriod: toString: error converting to String");
        }

        return r;
    }

    @Override
    public boolean equals(Object other) {

        if (other == null)
            return false;

        if (!(other instanceof TeradataTimePeriod))
            return false;

        TeradataTimePeriod odp = (TeradataTimePeriod)other;

        Object[] thisAtts = null;
        Object[] otherAtts = null;

        try {
            otherAtts = odp.getAttributes();
            thisAtts = this.getAttributes();
        }
        catch (SQLException e) {
            throw new Error("TeradataTimePeriod: equals: error getting attributes of DbStruct");
        }

        if (!(thisAtts[0].equals(otherAtts[0])))
            return false;

        if (!(thisAtts[1].equals(otherAtts[1])))
            return false;

        return true;
    }
}
