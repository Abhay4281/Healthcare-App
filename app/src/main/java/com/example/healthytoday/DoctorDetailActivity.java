package com.example.healthytoday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {

    private String[][] doctor_details1=
            {
                    {"Doctor Name : Ajit Saste ","Hospital Address : Max Vaishali ","Experience = 5 years","Mobile = 9898989899","Fees =600"},
                    {"Doctor Name : Shaelendra Sharma ","Hospital Address : Garg Hospital ","Experience = 7 years","Mobile = 9800009901","Fees =500"},
                    {"Doctor Name : Kajal Sharma ","Hospital Address : Clinic Shahdra ","Experience = 4 years","Mobile = 9811111982","Fees =1100"},
                    {"Doctor Name : Vikas Singh ","Hospital Address : Max Vaishali ","Experience = 5 years","Mobile = 9898900899","Fees =600"},
                    {"Doctor Name : Renuka Sharma ","Hospital Address : Max Patparganj ","Experience = 6 years","Mobile = 9898989899","Fees =600"}
            };

    private String[][] doctor_details2=
            {
                    {"Doctor Name : Swati Bajpai ","Hospital Address : Max Vaishali ","Experience = 5 years","Mobile = 9898989899","Fees =600"},
                    {"Doctor Name : Anush Sharma ","Hospital Address : Garg Hospital ","Experience = 6 years","Mobile = 9800001221","Fees =500"},
                    {"Doctor Name : Amit Sharma ","Hospital Address : Clinic Shahdra ","Experience = 6 years","Mobile = 9811111112","Fees =1100"},
                    {"Doctor Name : Kapil Singh ","Hospital Address : Max Vaishali ","Experience = 1 years","Mobile = 9898989999","Fees =600"},
                    {"Doctor Name : Dharam ","Hospital Address : Max Patparganj ","Experience = 8 years","Mobile = 9898989669","Fees =600"}
            };

    private String[][] doctor_details3=
            {
                    {"Doctor Name : Abhijeet Talwar ","Hospital Address : Max Vaishali ","Experience = 5 years","Mobile = 9898989899","Fees =600"},
                    {"Doctor Name : Piyush Jain ","Hospital Address : Jain Hospital ","Experience = 10 years","Mobile = 9800000000","Fees =500"},
                    {"Doctor Name : Kalpana Jain ","Hospital Address : Jain Hospital ","Experience = 10 years","Mobile = 9900000000","Fees =1100"},
                    {"Doctor Name : Vikas Dubey ","Hospital Address : Max Vaishali ","Experience = 9 years","Mobile = 9898900119","Fees =600"},
                    {"Doctor Name : Akshit sharma ","Hospital Address : Max BKG ","Experience = 6 years","Mobile = 9891239899","Fees =600"}
            };


    private String[][] doctor_details4=
            {
                    {"Doctor Name : Ajit Singh ","Hospital Address : Max Vaishali ","Experience = 6 years","Mobile = 9898912349","Fees =600"},
                    {"Doctor Name : Dipa Sharma ","Hospital Address : Jain Hospital ","Experience = 7 years","Mobile = 9200009901","Fees =500"},
                    {"Doctor Name : Kajal Singh ","Hospital Address : Clinic Shahdra ","Experience = 4 years","Mobile = 8811111982","Fees =1500"},
                    {"Doctor Name : Vikas Singh ","Hospital Address : Max Vaishali ","Experience = 5 years","Mobile = 9898900899","Fees =800"},
                    {"Doctor Name : Shraddha sharma","Hospital Address : Shahdra Clinic ","Experience = 1 years","Mobile = 9898989899","Fees =200"}
            };

    private String[][] doctor_details5=
            {
                    {"Doctor Name : Ajay singh ","Hospital Address : Max Partparganj ","Experience = 5 years","Mobile = 9823989899","Fees =900"},
                    {"Doctor Name : Deepak Garg ","Hospital Address : Garg Hospital ","Experience = 7 years","Mobile = 9800009901","Fees =600"},
                    {"Doctor Name : Dilip sharma ","Hospital Address : Clinic Shahdra ","Experience = 4 years","Mobile = 9811111982","Fees =1200"},
                    {"Doctor Name : Vivek sharma","Hospital Address : Max Vaishali ","Experience = 5 years","Mobile = 9898900899","Fees =650"},
                    {"Doctor Name : Riaa dua","Hospital Address : Max Patparganj ","Experience = 6 years","Mobile = 9898989899","Fees =600"}
            };
    TextView tv;
    Button btn;

    String[][] doctor_details={};

    HashMap<String,String>item;
    ArrayList List;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        tv=findViewById(R.id.textViewBMDtitle);
        btn=findViewById(R.id.buttonBMDBack);

        Intent it= getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

       if(title.compareTo("Family Physicians")==0)
           doctor_details=doctor_details1;
       else if(title.compareTo("Dietician")==0)
           doctor_details=doctor_details2;
       else if(title.compareTo("Dentist")==0)
           doctor_details=doctor_details3;
       else if(title.compareTo("Surgeon")==0)
           doctor_details=doctor_details4;
       else
           doctor_details=doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(DoctorDetailActivity.this,FindDoctor.class));
            }
        });

        List = new ArrayList<>();
        for(int i=0;i< doctor_details.length;i++)
        {
          item=new HashMap<String,String>();
          item.put("line1",doctor_details[i][0]);
          item.put("line2",doctor_details[i][1]);
          item.put("line3",doctor_details[i][2]);
          item.put("line4",doctor_details[i][3]);
          item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
          List.add(item);
        }
        sa= new SimpleAdapter(this,List,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst=findViewById(R.id.listViewOD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}