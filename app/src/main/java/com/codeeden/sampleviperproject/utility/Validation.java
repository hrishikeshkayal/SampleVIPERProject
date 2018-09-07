package com.codeeden.sampleviperproject.utility;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validation {

    //used to check if provided field is not null and having string lenght greater than 0
    public static boolean isBlankField(Context context, EditText et, String fieldNAme) {
        if (et == null)
            return false;

        if (et.getText().toString().trim().length() > 0)
            return true;
        else {
            Toast.makeText(context, fieldNAme + " should not be blank.", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    // check whether provided email id is valid or not
    public static boolean isValidEmail(Context context, EditText et, String msg) {

        if (et != null) {

            String email = et.getText().toString();
            if (email.length() > 0) {

                boolean isValid = emailValidator(email);
                if (isValid) {
                    return true;
                } else {
                    Toast.makeText(context, email + " is not a valid email", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(context, "PLease fill " + msg, Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(context, msg + " Should not be null", Toast.LENGTH_LONG).show();
        }

        return false;
    }

    //check whether provided DOBstring is greater than 18 or not.
    public static boolean isDOBAbove18(Context context, EditText et) {

        if (et != null) {
            //String strDOB="20-11-1998";
            String strDOB = et.getText().toString();
            if (strDOB.length() > 0) {
                //String input = "20-11-1995";
                Date date = null;
                try {
                    date = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH).parse(strDOB);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long milliseconds = date.getTime();
                //long millisecondsFromNow = milliseconds - (new Date()).getTime();
                if (getAge(milliseconds)) {
                    return true;
                } else {
                    Toast.makeText(context, "DOB is less than 18 years", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(context, "DOB string is null", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(context, et + " Should not be null", Toast.LENGTH_LONG).show();
        }


        return false;
    }

    //Check whether password lenght is more than 5 character ot not.
    public static boolean isPasswordLenght8(Context context, EditText et) {

        if (et != null) {

            String pasword = et.getText().toString();
            if (pasword != null) {
                if (pasword.length() == 0) {
                    AppData.showToast(context, "Please fill password.");
                    return false;
                } else if (pasword.length() > 5) {
                    return true;
                } else {
                    Toast.makeText(context, "Password should be more than 5 characters", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(context, "Password string is null", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(context, et + " Should not be null", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    public static boolean emailValidator(String mail) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(mail);
        return matcher.matches();
    }

    public static boolean getAge(long selectedMilli) {

        Date dateOfBirth = new Date(selectedMilli);
        Calendar dob = Calendar.getInstance();
        dob.setTime(dateOfBirth);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
            age--;
        } else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) < dob
                .get(Calendar.DAY_OF_MONTH)) {
            age--;
        }

        if (age > 18) {
            //do something
            return true;
        }

        return false;
    }


}
