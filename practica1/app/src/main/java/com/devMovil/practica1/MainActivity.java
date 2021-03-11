package com.devMovil.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText addresses;
    EditText subject;
    static final int REQUEST_SELECT_PHONE_NUMBER = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addresses= (EditText)findViewById(R.id.adresses);
    }







           public void selectContact(View view) {
               // Start an activity for the user to pick a phone number from contacts
               Intent intent = new Intent(Intent.ACTION_PICK);
               intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
               if (intent.resolveActivity(getPackageManager()) != null) {
                   startActivityForResult(intent, REQUEST_SELECT_PHONE_NUMBER);
               }
           }

           @Override
           protected void onActivityResult(int requestCode, int resultCode, Intent data) {
               super.onActivityResult(requestCode, resultCode, data);
               if (requestCode == REQUEST_SELECT_PHONE_NUMBER && resultCode == RESULT_OK) {
                   // Get the URI and query the content provider for the phone number
                   Uri contactUri = data.getData();
                   String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
                   Cursor cursor = getContentResolver().query(contactUri, projection,
                           null, null, null);
                   // If the cursor returned is valid, get the phone number
                   if (cursor != null && cursor.moveToFirst()) {
                       int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                       String number = cursor.getString(numberIndex);
                      addresses.setText(number);
                   }
               }
           }





}