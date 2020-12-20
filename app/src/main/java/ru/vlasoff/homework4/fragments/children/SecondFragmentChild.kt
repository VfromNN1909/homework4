package ru.vlasoff.homework4.fragments.children

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.vlasoff.homework4.R
import ru.vlasoff.homework4.databinding.FragmentSecondChildBinding
import ru.vlasoff.homework4.fragments.parents.SecondFragmentParent
import ru.vlasoff.homework4.util.ArgumentManager

class SecondFragmentChild : Fragment(R.layout.fragment_second_child) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentSecondChildBinding.bind(view)

        val argumentManager = ArgumentManager()
        val counter = argumentManager.getCounter(arguments)
        binding.textViewCounter2.text = "$counter"

        binding.root.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(
                    R.id.containerViewParentSecond,
                    SecondFragmentChild::class.java,
                    argumentManager.createArgs(counter + 1)
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}