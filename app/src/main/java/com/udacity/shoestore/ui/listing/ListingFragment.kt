package com.udacity.shoestore.ui.listing

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.setMargins
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.ui.ViewModel


class ListingFragment : Fragment() {

    private lateinit var viewModel: ViewModel
    private var _binding: FragmentListingBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<ListingFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]
        _binding = FragmentListingBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        val root: View = binding.root
        return root.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.model = viewModel
        binding.lifecycleOwner = this
        binding.fab.setOnClickListener {
            findNavController().navigate(ListingFragmentDirections.actionListingFragmentToAddShoeFragment())
        }
        args.shoe?.let {
            viewModel.addNewShoe(it)
        }
        viewModel.shoesList.observe(viewLifecycleOwner) {
            it.forEachIndexed { index, shoe ->

                val inflatedView =
                    LayoutInflater.from(requireContext()).inflate(R.layout.item_shoe, null)
                val bg = inflatedView.findViewById<CardView>(R.id.card)
                val img = inflatedView.findViewById<ImageView>(R.id.shoes1_img)
                val name = inflatedView.findViewById<TextView>(R.id.name1)
                val price = inflatedView.findViewById<TextView>(R.id.price1)
                val company = inflatedView.findViewById<TextView>(R.id.company1)
                val description = inflatedView.findViewById<TextView>(R.id.desc1)
                img.setImageResource(viewModel.getImage(index))
                name.text = shoe.name
                price.text = "${shoe.price}$ - size:${shoe.size}"
                company.text = shoe.company
                description.text = shoe.description
                bg.setCardBackgroundColor(Color.parseColor(viewModel.getRandomColor()))
                // set up margings
                val cardViewParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                );
                cardViewParams.setMargins(48, 48, 48, 0)
                inflatedView.layoutParams = cardViewParams
                binding.listParent.addView(inflatedView)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ListingFragmentDirections.actionListingFragmentToLoginFragment())
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}