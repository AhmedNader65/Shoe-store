package com.udacity.shoestore.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentNewListingBinding
import com.udacity.shoestore.models.Shoe

class AddShoeFragment : Fragment() {

    private var _binding: FragmentNewListingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewListingBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.save.setOnClickListener {
            val newShoe = Shoe(
                binding.name.editText?.text.toString(),
                Integer.valueOf(binding.size.editText?.text.toString()),
                binding.company.editText?.text.toString(),
                binding.price.editText?.text.toString(),
                binding.description.editText?.text.toString()
            )
            findNavController().navigate(
                AddShoeFragmentDirections.actionAddShoeFragmentToListingFragment(
                    newShoe
                )
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}