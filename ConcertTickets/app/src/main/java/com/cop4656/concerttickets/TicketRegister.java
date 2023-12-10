package com.cop4656.concerttickets;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cop4656.concerttickets.model.Concert;
import com.cop4656.concerttickets.model.Ticket;
import com.cop4656.concerttickets.repo.ConcertRepository;


public class TicketRegister extends AppCompatActivity {


    CheckBox isDisabled;
    RadioGroup paymentType;
    EditText name, email, phoneNumber, ticketCount;
    Spinner concerts;
    ArrayAdapter<CharSequence> concerts_adapter;

    Button submit;

    Boolean disabled = false;
    String payment_type = "Mobile";
    private ConcertRepository concertRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_register);

        concertRepo = ConcertRepository.getInstance(getApplicationContext());

        submit = findViewById(R.id.button1);
        submit.setOnClickListener(v -> {

            if(concertRepo.getFromTitle(concerts.getSelectedItem().toString()) != null){
                Concert concert = concertRepo.getFromTitle(concerts.getSelectedItem().toString());

                Ticket ticket = new Ticket(name.getText().toString(), email.getText().toString(), phoneNumber.getText().toString(), ticketCount.getText().toString(), disabled, payment_type);

                ticket.setConcertId(concert.getId());
                concertRepo.addTicket(ticket);
            }
        });

        // Spinner
        //concerts = findViewById(R.id.breed_text_view);
        concerts = findViewById(R.id.concerts_spinner);
        concerts_adapter = ArrayAdapter.createFromResource(this,
                R.array.concerts_array, android.R.layout.simple_spinner_item);
        concerts_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        concerts.setAdapter(concerts_adapter);

        concerts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        // CheckBox
        isDisabled = findViewById(R.id.isDisabled);
        isDisabled.setChecked(false);
        isDisabled.setOnClickListener(view -> {
            // checked
            // not checked
            disabled = ((CompoundButton) view).isChecked();
        });

        // Radio Buttons
        paymentType = findViewById(R.id.radio_group_payment);
        // paymentType.check(R.id.radio_card);
        paymentType.setOnClickListener(v -> {

           /* if(paymentType.getCheckedRadioButtonId() == R.id.radio_cash){
                payment_type = "Cash";
            }*/
            if(paymentType.getCheckedRadioButtonId() == R.id.radio_card){
                payment_type = "Card";
            }
            else{
                payment_type = "Mobile";
            }


        });

        // Name Edit Text
        name = findViewById(R.id.name_edit_text);
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        // Email Edit Text
        email = findViewById(R.id.email_edit_text);
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        // Name Edit Text
        phoneNumber = findViewById(R.id.phone_edit_text);
        phoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        // Name Edit Text
        ticketCount = findViewById(R.id.tickets_edit_text);
        ticketCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


    }

    public void onBackClick(View view){
        Intent i = new Intent(TicketRegister.this,MainActivity.class);
        startActivity(i);
    }
}
