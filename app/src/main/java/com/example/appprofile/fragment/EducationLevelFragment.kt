package com.example.appprofile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appprofile.Constants
import com.example.appprofile.R
import com.example.appprofile.adapter.EducationLevelAdapter
import com.example.appprofile.databinding.FragmentEducationLevelBinding
import com.example.appprofile.model.User

class EducationLevelFragment : Fragment() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var binding: FragmentEducationLevelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_education_level, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data: User = arguments?.getSerializable(Constants.BundleKey.KEY_USER) as User
        val educationLevels = arrayListOf(
            data.primarySchool,
            data.secondarySchool,
            data.highSchool,
            data.university
        )

        newRecyclerView = view.findViewById(R.id.rcvHv)
        newRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        newRecyclerView.setHasFixedSize(true)
        newRecyclerView.adapter = EducationLevelAdapter(educationLevels)

        binding.btnNext2.setOnClickListener {
            val bundle = bundleOf()
            val user: User = arguments?.getSerializable(Constants.BundleKey.KEY_USER) as User
            bundle.putSerializable(Constants.BundleKey.KEY_USER, user)
            findNavController().navigate(
                R.id.action_educationLevelFragment2_to_workExperienceFragment,
                bundle
            )
        }
    }
}