package com.example.jamesmai.billsplitter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;


public class SplitBill extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_bill);

        //Display the Action Bar Icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //Initiate instance of an object of the layout file
        final EditText bill=findViewById(R.id.txtBill);
        final EditText people=findViewById(R.id.txtPeople);
        final Spinner satisfaction=findViewById(R.id.spnTip);
        Button btnSplit=findViewById(R.id.btnSplit);
        final TextView billResult= findViewById(R.id.txtBillResult);
        final TextView tipResult= findViewById(R.id.txtTipResult);
        final TextView totalResult= findViewById(R.id.txtTotal);
        final TextView givingThanks= findViewById(R.id.txtBye);

        //Make actions when the user clicks the button
        btnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declare constant variable which decide the tip appropriate with the restaurant services
                final double excellentTip = 0.15;
                final double averageTip = 0.10;
                final double poorTip = 0.05;
                //Declare variable to collect the total bill, tip for calculate and variables to indicate the bill and tip for each person
                double mealBill;
                int peopleInGroup;
                int satisfactionChoice;
                double billForEach;
                double tipForEach;
                double total;
                double tip = 0;

                //Collect the user input include: the total bill, number of peoples in a group and the user choice for tip
                mealBill = Double.parseDouble(bill.getText().toString());
                peopleInGroup = Integer.parseInt(people.getText().toString());
                satisfactionChoice = satisfaction.getSelectedItemPosition();

                //Declare an output format for the output
                DecimalFormat currency = new DecimalFormat("$###,###.##");

                //Decision making statements decide which tip wage should be use
                switch(satisfactionChoice)
                {
                    case 0:
                        tip = excellentTip;
                        break;
                    case 1:
                        tip = averageTip;
                        break;
                    case 2:
                        tip = poorTip;
                        break;
                }

                //Calculate the bill and tip for each person and the total bill
                billForEach = mealBill / peopleInGroup;
                tipForEach = tip * billForEach;
                total = tipForEach + billForEach;

                //Indicate the result for bill, tip and total bill for each person
                billResult.setText("Bill for each person is " + currency.format(billForEach));
                tipResult.setText("Tip for each person is " + currency.format(tipForEach));
                totalResult.setText("Bill for each person is " + currency.format(total));
                givingThanks.setText("Thanks you ! Hope to serve you again soon !");
            }
        });
    }
}
