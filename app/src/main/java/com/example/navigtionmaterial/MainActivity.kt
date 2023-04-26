package com.example.navigtionmaterial


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var btnAdd: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        btnAdd = findViewById(R.id.fab)
        bottomNavigationView.background = null

        val fragment = HomeFragment()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content, fragment, "")
        fragmentTransaction.commit()
        bottomNavigationView.setOnNavigationItemSelectedListener(selectedListener);

        btnAdd.setOnClickListener {
            startForResult.launch(Intent(this, AddActivity::class.java))
        }
    }

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
            }
        }

    private val selectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    val fragment = HomeFragment()
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.content, fragment, "")
                    fragmentTransaction.commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.personal -> {
                    val fragment1 = PersonalFragment()
                    val fragmentTransaction1 = supportFragmentManager.beginTransaction()
                    fragmentTransaction1.replace(R.id.content, fragment1)
                    fragmentTransaction1.commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.map -> {
                    val fragment2 = MapFragment()
                    val fragmentTransaction2 = supportFragmentManager.beginTransaction()
                    fragmentTransaction2.replace(R.id.content, fragment2, "")
                    fragmentTransaction2.commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.favorite -> {
                    Toast.makeText(this@MainActivity, "fa", Toast.LENGTH_SHORT).show()
                    val listFragment = FavoriteFragment()
                    val fragmentTransaction3 = supportFragmentManager.beginTransaction()
                    fragmentTransaction3.replace(R.id.content, listFragment, "")
                    fragmentTransaction3.commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


}