package com.example.appprofile.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appprofile.Adapter.EducationLevelAdapter
import com.example.appprofile.Model.EducationLevel
import com.example.appprofile.R
import kotlinx.android.synthetic.main.fragment_education_level.*
import kotlinx.android.synthetic.main.fragment_home.*

class EducationLevelFragment : Fragment() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<EducationLevel>
    lateinit var nameSchool: Array<String>
    lateinit var nameCertificate : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_education_level, container, false)
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

        btnNext2.setOnClickListener {
            val action = EducationLevelFragmentDirections.actionEducationLevelFragment2ToWorkExperienceFragment()
            findNavController().navigate(action)
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