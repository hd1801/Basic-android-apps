package com.example.justjava;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        displayQuantity();
        String orderSummary = "ORDER SUMMARY:\nName: "+getUserName()+"\nQuantity: " + quantity + "\nTotal:" + NumberFormat.getCurrencyInstance().format(calculatePrice());
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_check_box);
        CheckBox Chocolate =(CheckBox) findViewById(R.id.chocolate_check_box);
        if (whippedCream.isChecked()) {
            orderSummary += "\nAdded: Whipped Cream";
        }
        if (Chocolate.isChecked()) {
            orderSummary += "\nAdded: Chocolates";
        }
        orderSummary += "\nThank You!";
        displayOrderSummary(orderSummary);
    }

    /**
     * this method calculates and return the price of the order
     */

    private int calculatePrice() {
        int price = 5;
        CheckBox Chocolate =(CheckBox) findViewById(R.id.chocolate_check_box);
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_check_box);
        if (whippedCream.isChecked())
            price += 2;
        if (Chocolate.isChecked())
            price += 3;

        return price * quantity;
    }

    /**
     * This method displays the given quantity value on the screen.
     */

    private void displayQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayOrderSummary(String message) {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_EMAIL,"email@example.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, "ordering a coffee");
            intent.putExtra(Intent.EXTRA_TEXT, message);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
    }

    /**
     * this method increments the quantity of the order
     */
    public void increment(View view) {
        quantity++;
        if(quantity>50)
        {   Context context = getApplicationContext();
            CharSequence text = "Quantity is limited to 50";
            int duration = Toast.LENGTH_SHORT;
            quantity--;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else
        {
        displayQuantity();  }
    }

    /**
     * this method decrements the quantity of the order
     */

    public void decrement(View view) {
        quantity--;
        if(quantity<1)
        {   Context context = getApplicationContext();
        CharSequence text = "Quantity cant be less than 1";
        int duration = Toast.LENGTH_SHORT;
        quantity++;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        }
        else {
            displayQuantity();
        }
    }
    /**
     * This method takes user name as input(in xml EditText) and return it
     *
     */
    private String getUserName()
    {
        EditText field= (EditText) findViewById(R.id.name_input);
        String name = field.getText().toString();
        return name;
    }
}