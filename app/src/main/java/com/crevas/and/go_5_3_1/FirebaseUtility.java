package com.crevas.and.go_5_3_1;

import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class FirebaseUtility extends AppCompatActivity {

    public static FirebaseDatabase mFirebaseDatabase;
    public static DatabaseReference mChoicesRef;
    public static String mChoicesId;




    public static void updateChoice(ChoicesDetail userChoice1,
                                    ChoicesDetail userChoice2,
                                    ChoicesDetail userChoice3,
                                    ChoicesDetail userChoice4,
                                    ChoicesDetail userChoice5) {


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mChoicesRef = mFirebaseDatabase.getReference();
        mChoicesId = mChoicesRef.push().getKey();

        ChoicesObject choices = new ChoicesObject(userChoice1, userChoice2,
                userChoice3, userChoice4, userChoice5, null);

        mChoicesRef.child(mChoicesId).setValue(choices);

    }

    public static void setFinalChoice(String name, String address) {
        mFirebaseDatabase = FirebaseDatabase.getInstance();

//        mChoicesRef.child(mChoicesId).setValue(choices);

        Map<String, Object> finalChoice = new HashMap<>();
        finalChoice.put("finalName", name);
        finalChoice.put("finalAddress", address);

        mChoicesRef.child(mChoicesId).updateChildren(finalChoice);
    }


}
