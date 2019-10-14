package Database;

import android.provider.BaseColumns;

public final class EmployeeInfo {

    private EmployeeInfo(){}

    public class Employees implements BaseColumns {
        public static final String TABLE_NAME_EMPLOYEE = "EmployeeInfo";
        public static final String COLUMN_NAME_EMPNAME = "empName";
        public static final String COLUMN_NAME_EMPTEL = "empTelephone";
        public static final String COLUMN_NAME_GENDER = "empGender";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_Type = "empType";
    }
}
