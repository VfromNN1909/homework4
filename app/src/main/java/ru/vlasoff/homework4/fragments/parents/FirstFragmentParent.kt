package ru.vlasoff.homework4.fragments.parents

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.vlasoff.homework4.R
import ru.vlasoff.homework4.fragments.children.FirstFragmentChild
import ru.vlasoff.homework4.util.ArgumentManager

class FirstFragmentParent : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            replace(R.id.containerViewParentFirst, FirstFragmentChild())
            commit()
        }

    }


}