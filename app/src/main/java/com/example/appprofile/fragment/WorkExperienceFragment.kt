package com.example.appprofile.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appprofile.Constants
import com.example.appprofile.adapter.WorkExperienceAdapter
import com.example.appprofile.model.WorkExperience
import com.example.appprofile.R
import com.example.appprofile.databinding.FragmentWorkExperienceBinding
import com.example.appprofile.model.User
import kotlinx.android.synthetic.main.fragment_work_experience.*

class WorkExperienceFragment : Fragment() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<WorkExperience>
    lateinit var nameCompany: Array<String>
    lateinit var position: Array<String>
    lateinit var description: Array<String>
    private lateinit var binding: FragmentWorkExperienceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_work_experience, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data:User = arguments?.getSerializable(Constants.BundleKey.KEY_USER) as User

        val companies = arrayListOf(
            data.thaiDetoxCompany,
            data.cmcGlobalCompany,
            data.misaCompany,
            data.namasCompany,
            data.fptCompany
        )
        newRecyclerView = view.findViewById(R.id.rcvLv)
        newRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        newRecyclerView.setHasFixedSize(true)
        newRecyclerView.adapter = WorkExperienceAdapter(companies)

        btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_workExperienceFragment_to_homeFragment)
        }
    }

}