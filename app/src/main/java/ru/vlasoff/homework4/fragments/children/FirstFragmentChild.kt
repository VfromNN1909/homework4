package ru.vlasoff.homework4.fragments.children

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.vlasoff.homework4.R
import ru.vlasoff.homework4.databinding.FragmentFirstChildBinding
import ru.vlasoff.homework4.fragments.parents.SecondFragmentParent
import ru.vlasoff.homework4.util.ArgumentManager


class FirstFragmentChild : Fragment(R.layout.fragment_first_child) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentFirstChildBinding.bind(view)

        val argumentManager = ArgumentManager()
        val counter = argumentManager.getCounter(arguments)
        binding.textViewCounter1.text = "$counter"

        binding.root.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(
                    R.id.containerViewParentFirst,
                    FirstFragmentChild::class.java,
                    argumentManager.createArgs(counter + 1)
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}