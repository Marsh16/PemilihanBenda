package com.uc.pemilihanbenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.uc.pemilihanbenda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var database = FirebaseDatabase.getInstance().reference
        //get data
        var getdata= object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                var sb = StringBuilder()
                var sb1 = StringBuilder()
                var sb2 = StringBuilder()
                var sb3 = StringBuilder()
                for (i in p0.children){
                    var a= i.child("a").getValue()
                    var b= i.child("b").getValue()
                    var c= i.child("c").getValue()
                    var d= i.child("d").getValue()
                    sb.append("$a")
                    sb1.append("$b")
                    sb2.append("$c")
                    sb3.append("$d")
                }
                binding.tvShow.text= sb
                binding.tv2Show.text= sb1
                binding.tv3Show.text= sb2
                binding.tv4Show.text= sb3
            }


        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)
    }

}