package com.example.appprofile.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appprofile.adapter.EducationLevelAdapter
import com.example.appprofile.model.EducationLevel
import com.example.appprofile.R
import com.example.appprofile.databinding.FragmentEducationLevelBinding
import kotlinx.android.synthetic.main.fragment_education_level.*

class EducationLevelFragment : Fragment() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<EducationLevel>
    lateinit var nameSchool: Array<String>
    lateinit var nameCertificate : Array<String>
    private lateinit var binding: FragmentEducationLevelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_education_level, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameSchool = arrayOf(
            "Trường tiểu học Tân Việt",
            "Trường trung học cơ sở Tân Việt",
            "Trường trung học phổ thông Minh Châu",
            "Trường Đại học Giao thông vận tải"
        )
        nameCertificate = arrayOf("Bằng cấp: Giỏi", "Bằng cấp: Giỏi", "Bằng cấp: Giỏi", "Bằng cấp: Xuất sắc")

        newRecyclerView = view.findViewById(R.id.rcvHv)
        newRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<EducationLevel>()
        getUserData()

        binding.btnNext2.setOnClickListener {
            findNavController().navigate(R.id.action_educationLevelFragment2_to_workExperienceFragment)
        }
    }

    private fun getUserData() {
        for (i in nameSchool.indices) {
            val educationLevel = EducationLevel(nameSchool[i], nameCertificate[i])
            newArrayList.add(educationLevel)
        }

        newRecyclerView.adapter = EducationLevelAdapter(newArrayList)
    }

}