package com.cbellmont.ejemploandroidfragment1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cbellmont.ejemploandroidfragment1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var nextFragment : Fragment = FragmentRojo()
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.frameLayout, nextFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            nextFragment = if (nextFragment is FragmentRojo) FragmentAmarillo() else FragmentRojo()
        }
    }
}