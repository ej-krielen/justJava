package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    private int quantity = 1;
    private int unitPrice = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayQuantity(1);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity--;
        //quantity is not allowed to be less then zero
        if (quantity < 0) {
            quantity = 0;
            //show a message that it is not allowed to go below 0
            Toast.makeText(getApplicationContext(), getString(R.string.main_toast_less_then_0), Toast.LENGTH_SHORT).show();
        }
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
        displayPrice();
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(calculatePrice()));
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        Toast.makeText(getApplicationContext(),
                getString(R.string.main_toast_quantity) + quantity + "\n" +
                        getString(R.string.main_toast_total) + calculatePrice() + "\n" +
                        getString(R.string.main_toast_order),
                Toast.LENGTH_SHORT)
                .show();
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return total price
     */
    private int calculatePrice() {
        return quantity * unitPrice;
    }
}
