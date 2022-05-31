package com.example.appprofile.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.appprofile.Model.User
import com.example.appprofile.R
import com.example.appprofile.ViewModel.UserViewModel
import com.example.appprofile.databinding.FragmentHomeBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    private val viewModel: UserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        // val viewModel: UserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
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
        binding.lifecycleOwner = this
        return binding.root
//        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get()
            .load("https://i.pinimg.com/564x/08/b9/7c/08b97c85e5794cda9da13fdc70577e5e.jpg")
            .placeholder(R.drawable.img1)
            .error(R.drawable.error)
            .into(ivMyImage)



//        val textContent: TextView = view.findViewById(R.id.tvContent)
//
//        textContent.movementMethod = LinkMovementMethod.getInstance()
//        textContent.setLinkTextColor(Color.BLUE)


        btnNext.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEducationLevelFragment2()
            findNavController().navigate(action)
        }
    }
}