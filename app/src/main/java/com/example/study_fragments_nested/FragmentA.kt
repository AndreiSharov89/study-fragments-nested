package com.example.study_fragments_nested

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.study_fragments_nested.databinding.FragmentABinding

class FragmentA : Fragment(), SelectPage {
    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!
    var song: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text.text = requireArguments().getString(SONG_NAME)
            .plus(other = " | Parent")

        val adapter = PagerAdapter(hostFragment = this)
        binding.pager.adapter = adapter

    }

    override fun navigateTo(page: Int) {
        view?.findViewById<ViewPager2>(R.id.pager)?.currentItem = page
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        const val SONG_NAME = "SONG"
        fun newInstance(song: String) = FragmentA()
            .apply { arguments = bundleOf(SONG_NAME to song) }
    }
}


