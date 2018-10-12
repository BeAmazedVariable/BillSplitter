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
                //Tip percentages for each quality of service option
                final double[] tip = {0.15, 0.10, 0.5};

                double mealBill;            //Collect the total meal's bill
                int peopleInGroup;          //Collect the number of people in the group
                int satisfactionChoice;     //Decide how much satisfy the customer is with our service
                double billForEach;         //Bill that each person has to pay
                double tipForEach;          //Tip that each person has to pay
                double total;               //Total amount of money that each person has to pay
                double tipPercent;          //Tip percent

                //Collect the user input include: the total bill, number of peoples in a group and the user choice for tip
                mealBill = Double.parseDouble(bill.getText().toString());
                peopleInGroup = Integer.parseInt(people.getText().toString());
                satisfactionChoice = satisfaction.getSelectedItemPosition();

                //Declare an output format for the output
                DecimalFormat currency = new DecimalFormat("$###,###.##");

                //Decide tip percent appropriate with the quality of service
                tipPercent = tip[satisfactionChoice];

                //Calculate the bill and tip for each person and the total bill
                billForEach = mealBill / peopleInGroup;
                tipForEach = tipPercent * billForEach;
                total = tipForEach + billForEach;

                //Indicate the result for bill, tip and total bill for each person
                billResult.setText("Bill for each person is " + currency.format(billForEach));
                tipResult.setText("Tip for each person is " + currency.format(tipForEach));
                totalResult.setText("Total bill for each person is " + currency.format(total));
                givingThanks.setText(R.string.txtThanks);
            }
        });
    }
}
