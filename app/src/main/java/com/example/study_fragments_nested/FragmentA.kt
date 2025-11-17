package com.example.study_fragments_nested

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.study_fragments_nested.databinding.FragmentABinding

class FragmentA : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentABinding.inflate(inflater, container, false).root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val song = requireArguments().getString(SONG_NAME)
        view.findViewById<TextView>(R.id.song).text = song
        childFragmentManager.beginTransaction()
            .add(R.id.fragment_child_container, NestedFragmentA())
            .commit()
    }
    companion object {
        const val SONG_NAME = "SONG"
        fun newInstance(song: String) = FragmentA()
            .apply { arguments = bundleOf(SONG_NAME to song) }
    }
}


