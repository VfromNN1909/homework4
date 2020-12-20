package ru.vlasoff.homework4

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.vlasoff.homework4.databinding.ActivityMainBinding
import ru.vlasoff.homework4.fragments.parents.FirstFragmentParent
import ru.vlasoff.homework4.fragments.parents.SecondFragmentParent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment1 = FirstFragmentParent()
        val fragment2 = SecondFragmentParent()


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(R.id.fragmentContainerView, fragment1)
                add(R.id.fragmentContainerView, fragment2)
                setPrimaryNavigationFragment(fragment1)

                commit()
            }

            binding.textViewButtonFirst.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .hide(fragment2)
                    .show(fragment1)
                    .setPrimaryNavigationFragment(fragment1)
                    .commit()
            }
            binding.textViewButtonSecond.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .hide(fragment1)
                    .show(fragment2)
                    .setPrimaryNavigationFragment(fragment2)
                    .commit()
            }

        }
    }

}