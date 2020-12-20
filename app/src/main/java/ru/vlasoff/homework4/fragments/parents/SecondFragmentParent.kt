package ru.vlasoff.homework4.fragments.parents

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.vlasoff.homework4.R
import ru.vlasoff.homework4.fragments.children.SecondFragmentChild
import ru.vlasoff.homework4.util.ArgumentManager

class SecondFragmentParent : Fragment(R.layout.fragment_second_child) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            replace(R.id.containerViewParentSecond, SecondFragmentChild())
            commit()
        }

    }


}