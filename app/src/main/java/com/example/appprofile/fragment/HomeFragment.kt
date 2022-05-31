package com.example.appprofile.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.appprofile.model.User
import com.example.appprofile.R
import com.example.appprofile.viewmodel.UserViewModel
import com.example.appprofile.databinding.FragmentHomeBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        val user = User(
            name = "HA",
            sex = "nu",
            birthday = "13/04/2001",
            phoneNumber = "0358604666",
            homeTown = "HY",
            hobby = "sdsd",
            email = "ng@gmail.com",
            facebook = "avsavdh"
        )
        binding.user = user
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get()
            .load("https://i.pinimg.com/564x/08/b9/7c/08b97c85e5794cda9da13fdc70577e5e.jpg")
            .placeholder(R.drawable.img1)
            .error(R.drawable.error)
            .into(binding.ivMyImage)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_educationLevelFragment2)
        }
    }
}