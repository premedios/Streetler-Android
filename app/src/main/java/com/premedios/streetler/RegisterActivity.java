package com.premedios.streetler;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.premedios.streetler.helper.SQLiteHandler;
import com.premedios.streetler.helper.SessionManager;
import com.premedios.streetler.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements CalendarDatePickerDialogFragment.OnDateSetListener {
    private static final String TAG = RegisterActivity.class.getSimpleName();
    private final String DATE_PICKER = "Date Picker";
    private Button btnRegister;
    private TextView txtLinkToLogin;
    private EditText inputFirstName;
    private EditText inputLastName;
    private EditText inputCity;
    private EditText inputEmail;
    private EditText inputPassword;
    private TextView inputDateOfBirth;
    private Spinner spinSex;
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        String sex[] = {"Male", "Female"};

        inputFirstName = (EditText) findViewById(R.id.first_name);
        inputLastName = (EditText) findViewById(R.id.last_name);
        inputCity = (EditText) findViewById(R.id.city);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        inputDateOfBirth = (TextView) findViewById(R.id.date_of_birth);
        spinSex = (Spinner) findViewById(R.id.sex);
        btnRegister = (Button) findViewById(R.id.register_button);
        txtLinkToLogin = (TextView) findViewById(R.id.login_text);

        ArrayAdapter<String> sexAdapter = new ArrayAdapter<>(this, R.layout.sex_spinner_item_layout, R.id.sex_item, sex);
        spinSex.setAdapter(sexAdapter);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // Session manager
        session = new SessionManager(getApplicationContext());

        // SQLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(RegisterActivity.this, StreetlerActivity.class);
            startActivity(intent);
            finish();
        }

        // Register Button Click event
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String first_name = inputFirstName.getText().toString().trim();
                String last_name = inputLastName.getText().toString().trim();
                String city = inputCity.getText().toString().trim();
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                SimpleDateFormat dateOfBirthFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
                Date date_of_birth = new Date();
                try {
                    date_of_birth = dateOfBirthFormat.parse(inputDateOfBirth.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String sex = spinSex.getSelectedItem().toString();

                if (!first_name.isEmpty() && !last_name.isEmpty() &&
                        !email.isEmpty() && !password.isEmpty())
                    registerUser(first_name, last_name, city, date_of_birth, sex, email, password);
                else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

        // Link to Login Screen
        txtLinkToLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        inputDateOfBirth.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Calendar myCalendar = Calendar.getInstance();
                CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                        .setOnDateSetListener(RegisterActivity.this)
                        .setFirstDayOfWeek(Calendar.MONDAY)
                        .setPreselectedDate(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH)
                        .setDoneText("Done")
                        .setCancelText("Cancel");
                cdp.show(getSupportFragmentManager(), DATE_PICKER);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        CalendarDatePickerDialogFragment calendarDatePickerDialogFragment = (CalendarDatePickerDialogFragment) getSupportFragmentManager().findFragmentByTag(DATE_PICKER);
        if (calendarDatePickerDialogFragment != null) {
            calendarDatePickerDialogFragment.setOnDateSetListener(this);
        }
    }

    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        Calendar myCalendar = Calendar.getInstance();
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, monthOfYear);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        inputDateOfBirth.setText(sdf.format(myCalendar.getTime()));
    }

    /**
     * Function to store user in MySQL database will post params(tag, name,
     * email, password) to register url
     */
    private void registerUser(final String first_name, final String last_name,
                              final String city, final Date date_of_birth,
                              final String sex, final String email,
                              final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_register";

        pDialog.setMessage("Registering ...");
        showDialog();

        StringRequest strReq = new StringRequest(Method.POST, AppConfig.URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response);
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        // User successfully stored in MySQL
                        // Now store the user in sqlite
                        String uid = jObj.getString("uid");

                        JSONObject user = jObj.getJSONObject("user");
                        String firstname = user.getString("first_name");
                        String lastname = user.getString("last_name");
                        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
                        Date dateOfBirth = null;
                        try {
                            dateOfBirth = dateFormat.parse(user.getString("date_of_birth"));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        String email = user.getString("email");
                        String created_at = user
                                .getString("created_at");

                        // Inserting row in users table
                        //db.addUser(name, email, uid, created_at);
                        User registeringUser = new User();

                        registeringUser.firstname = firstname;
                        registeringUser.lastname = lastname;
                        registeringUser.city = city;
                        registeringUser.dateOfBirth = (java.sql.Date) dateOfBirth;
                        registeringUser.save();

                        Toast.makeText(getApplicationContext(), "User successfully registered. Try login now!", Toast.LENGTH_LONG).show();

                        // Launch login activity
                        Intent intent = new Intent(
                                RegisterActivity.this,
                                LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<>();
                params.put("first_name", first_name);
                params.put("last_name", last_name);
                params.put("email", email);
                params.put("password", password);
                params.put("gender", String.valueOf(sex.charAt(0)));
                params.put("city", city);
                DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
                String dateString = dateFormat.format(date_of_birth);
                params.put("date_of_birth", dateString);
                params.put("action", "register");

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}