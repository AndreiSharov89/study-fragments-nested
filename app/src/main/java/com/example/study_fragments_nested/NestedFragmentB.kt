package com.example.study_fragments_nested

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.study_fragments_nested.databinding.FragmentBNestedBinding

class NestedFragmentB : Fragment() {
    private var _binding: FragmentBNestedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBNestedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text.text = (requireActivity() as SongNameProvider).getSongName()
            .plus(other = " | B")
        binding.button.setOnClickListener {
            parentFragmentManager.commit {
                (parentFragment as? SelectPage)?.navigateTo(page = 0)
            }
        }
    }
}