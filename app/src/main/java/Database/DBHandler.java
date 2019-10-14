package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import Model.Employee;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE = "ABCClothing.db";

    public DBHandler(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTable = "CREATE TABLE " + EmployeeInfo.Employees.TABLE_NAME_EMPLOYEE +
                "(" + EmployeeInfo.Employees._ID + " INTEGER PRIMARY KEY," +
                EmployeeInfo.Employees.COLUMN_NAME_EMPNAME + " TEXT," +
                EmployeeInfo.Employees.COLUMN_NAME_EMPTEL + " INTEGER," +
                EmployeeInfo.Employees.COLUMN_NAME_GENDER + " TEXT," +
                EmployeeInfo.Employees.COLUMN_NAME_EMAIL + " TEXT," +
                EmployeeInfo.Employees.COLUMN_NAME_Type + " TEXT);";

        sqLiteDatabase.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addEmployee(String name, int tel, String gender, String email,String type){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(EmployeeInfo.Employees.COLUMN_NAME_EMPNAME, name);
        contentValues.put(EmployeeInfo.Employees.COLUMN_NAME_EMPTEL, tel);
        contentValues.put(EmployeeInfo.Employees.COLUMN_NAME_GENDER, gender);
        contentValues.put(EmployeeInfo.Employees.COLUMN_NAME_EMAIL, email);
        contentValues.put(EmployeeInfo.Employees.COLUMN_NAME_Type, type);

        Log.i("Email", email);

        long res = db.insert(EmployeeInfo.Employees.TABLE_NAME_EMPLOYEE, null, contentValues);

        if(res > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean updateEmployee(int id, String name, int tel, String gender, String email,String type){
        SQLiteDatabase db = getReadableDatabase();

        String whereclause = EmployeeInfo.Employees._ID + " = ?";
        String whereArgs[] = {String.valueOf(id)};

        ContentValues contentValues = new ContentValues();
        contentValues.put(EmployeeInfo.Employees.COLUMN_NAME_EMPNAME, name);
        contentValues.put(EmployeeInfo.Employees.COLUMN_NAME_EMPTEL, tel);
        contentValues.put(EmployeeInfo.Employees.COLUMN_NAME_GENDER, gender);
        contentValues.put(EmployeeInfo.Employees.COLUMN_NAME_EMAIL, email);
        contentValues.put(EmployeeInfo.Employees.COLUMN_NAME_Type, type);

        long res = db.update(EmployeeInfo.Employees.TABLE_NAME_EMPLOYEE, contentValues, whereclause, whereArgs);

        if(res > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public ArrayList<Employee> search(){
        SQLiteDatabase db = getReadableDatabase();

        String[] columns = {EmployeeInfo.Employees._ID, EmployeeInfo.Employees.COLUMN_NAME_EMPNAME,
                EmployeeInfo.Employees.COLUMN_NAME_EMPTEL, EmployeeInfo.Employees.COLUMN_NAME_GENDER,
                EmployeeInfo.Employees.COLUMN_NAME_EMAIL, EmployeeInfo.Employees.COLUMN_NAME_Type};

        String sortOrder = EmployeeInfo.Employees._ID;

        Cursor values = db.query(EmployeeInfo.Employees.TABLE_NAME_EMPLOYEE, columns, null, null, null, null, sortOrder);

        ArrayList<Employee> employees = new ArrayList<>();

        while (values.moveToNext()){
            Employee emp = new Employee();
            emp.setId(values.getInt(values.getColumnIndexOrThrow(EmployeeInfo.Employees._ID)));
            emp.setEmpName(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_EMPNAME)));
            emp.setTelephone(values.getInt(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_EMPTEL)));
            emp.setGender(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_GENDER)));
            emp.setEmail(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_EMAIL)));
            emp.setType(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_Type)));
            employees.add(emp);
        }

        return employees;
    }

    public ArrayList<Employee> search(int id){
        SQLiteDatabase db = getReadableDatabase();

        String[] columns = {EmployeeInfo.Employees._ID, EmployeeInfo.Employees.COLUMN_NAME_EMPNAME,
                EmployeeInfo.Employees.COLUMN_NAME_EMPTEL, EmployeeInfo.Employees.COLUMN_NAME_GENDER,
                EmployeeInfo.Employees.COLUMN_NAME_EMAIL, EmployeeInfo.Employees.COLUMN_NAME_Type};

        String sortOrder = EmployeeInfo.Employees._ID;

        String selection = EmployeeInfo.Employees._ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor values = db.query(EmployeeInfo.Employees.TABLE_NAME_EMPLOYEE, columns, selection, selectionArgs, null, null, sortOrder);

        ArrayList<Employee> employees = new ArrayList<>();

        while (values.moveToNext()){
            Employee emp = new Employee();
            emp.setId(values.getInt(values.getColumnIndexOrThrow(EmployeeInfo.Employees._ID)));
            emp.setEmpName(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_EMPNAME)));
            emp.setTelephone(values.getInt(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_EMPTEL)));
            emp.setGender(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_GENDER)));
            emp.setType(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_Type)));
            emp.setEmail(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_EMAIL)));
            employees.add(emp);
        }

        return employees;
    }

    public ArrayList<Employee> search(String type){
        SQLiteDatabase db = getReadableDatabase();

        String[] columns = {EmployeeInfo.Employees._ID, EmployeeInfo.Employees.COLUMN_NAME_EMPNAME,
                EmployeeInfo.Employees.COLUMN_NAME_EMPTEL, EmployeeInfo.Employees.COLUMN_NAME_GENDER,
                EmployeeInfo.Employees.COLUMN_NAME_Type};

        String sortOrder = EmployeeInfo.Employees._ID;

        String selection = EmployeeInfo.Employees.COLUMN_NAME_Type + " = ?";
        String[] selectionArgs = {type};

        Cursor values = db.query(EmployeeInfo.Employees.TABLE_NAME_EMPLOYEE, columns, selection, selectionArgs, null, null, sortOrder);

        ArrayList<Employee> employees = new ArrayList<>();

        while (values.moveToNext()){
            Employee emp = new Employee();
            emp.setId(values.getInt(values.getColumnIndexOrThrow(EmployeeInfo.Employees._ID)));
            emp.setEmpName(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_EMPNAME)));
            emp.setTelephone(values.getInt(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_EMPTEL)));
            emp.setGender(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_GENDER)));
            emp.setType(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_Type)));
            employees.add(emp);
        }

        return employees;
    }

    public ArrayList<Employee> search(int id, String type){
        SQLiteDatabase db = getReadableDatabase();

        String[] columns = {EmployeeInfo.Employees._ID, EmployeeInfo.Employees.COLUMN_NAME_EMPNAME,
                EmployeeInfo.Employees.COLUMN_NAME_EMPTEL, EmployeeInfo.Employees.COLUMN_NAME_GENDER,
                EmployeeInfo.Employees.COLUMN_NAME_EMAIL, EmployeeInfo.Employees.COLUMN_NAME_Type};

        String sortOrder = EmployeeInfo.Employees._ID;

        String selection = EmployeeInfo.Employees._ID + " = ? OR " + EmployeeInfo.Employees.COLUMN_NAME_Type + " = ?";
        String[] selectionArgs = {  String.valueOf(id), type};

        Cursor values = db.query(EmployeeInfo.Employees.TABLE_NAME_EMPLOYEE, columns, selection, selectionArgs, null, null, sortOrder);

        ArrayList<Employee> employees = new ArrayList<>();

        while (values.moveToNext()){
            Employee emp = new Employee();
            emp.setId(values.getInt(values.getColumnIndexOrThrow(EmployeeInfo.Employees._ID)));
            emp.setEmpName(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_EMPNAME)));
            emp.setTelephone(values.getInt(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_EMPTEL)));
            emp.setGender(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_GENDER)));
            emp.setEmail(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_EMAIL)));
            emp.setType(values.getString(values.getColumnIndexOrThrow(EmployeeInfo.Employees.COLUMN_NAME_Type)));
            employees.add(emp);
        }

        return employees;
    }
}
