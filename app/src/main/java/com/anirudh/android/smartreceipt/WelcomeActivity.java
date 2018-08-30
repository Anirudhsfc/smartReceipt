package com.anirudh.android.smartreceipt;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class WelcomeActivity extends AppCompatActivity {

    private FirebaseUser user;
    private TextView textViewOctopus;
    private ImageView imageView;
    private TextView textViewEmail;
    private StorageReference mStorageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
// Write a message to the database


        imageView=(ImageView)findViewById(R.id.imageView);
        textViewOctopus=(TextView)findViewById(R.id.textViewOctopus);
        textViewEmail=(TextView)findViewById(R.id.textViewEmail);

         user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String octopus = user.getDisplayName();
            String email = user.getEmail();
            textViewOctopus.setText(octopus);
            textViewEmail.setText(email);

        }
        mStorageReference= FirebaseStorage.getInstance().getReference("images/").child(user.getDisplayName());
        Glide.with(this /* context */)
                .using(new FirebaseImageLoader())
                .load(mStorageReference)
                .centerCrop()
                .into(imageView);

    }
}
