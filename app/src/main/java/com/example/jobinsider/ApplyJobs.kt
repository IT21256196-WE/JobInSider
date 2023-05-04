package com.example.jobinsider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jobinsider.databinding.ActivityAddJobBinding

import com.example.jobinsider.databinding.ActivityApplyJobsBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ApplyJobs : AppCompatActivity() {

    private lateinit var binding : ActivityApplyJobsBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApplyJobsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.applyBtn.setOnClickListener {

            val jobtitle = binding.JSName.text.toString()
            val jobdesc = binding.Town.text.toString()
            val jobqualification = binding.jstime.text.toString()


            database = FirebaseDatabase.getInstance().getReference("Job Applications")
            val Job = JobApplications(jobtitle,jobdesc,jobqualification)
            database.child(jobtitle).setValue(Job).addOnSuccessListener {

                binding.JSName.text.clear()
                binding.Town.text.clear()
                binding.jstime.text.clear()


                Toast.makeText(this,"Successfully Saved", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{

                Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()


            }


        }

    }}
