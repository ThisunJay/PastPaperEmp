package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pastpaperemp.R;

import java.util.ArrayList;

import Database.DBHandler;
import Model.Employee;

public class EmployeeAdapter extends BaseAdapter {

    ArrayList<Employee> list;
    Context context;
    DBHandler db;

    public EmployeeAdapter(Context c){
        context = c;
        db = new DBHandler(c);
        list = db.search();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View row = layoutInflater.inflate(R.layout.listitemsview, viewGroup, false);

        TextView empId = row.findViewById(R.id.listId);
        TextView empName = row.findViewById(R.id.listName);
        TextView empGender = row.findViewById(R.id.listGender);
        TextView empTel = row.findViewById(R.id.listTel);
        TextView empType = row.findViewById(R.id.listType);

        Employee emp = list.get(i);

        empId.setText(String.valueOf(emp.getId()));
        empName.setText(emp.getEmpName());
        empGender.setText(emp.getGender());
        empTel.setText(String.valueOf(emp.getTelephone()));
        empType.setText(emp.getType());

        return row;
    }
}
