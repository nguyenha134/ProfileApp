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
import com.example.appprofile.Adapter.WorkExperienceAdapter
import com.example.appprofile.Model.EducationLevel
import com.example.appprofile.Model.WorkExperience
import com.example.appprofile.R
import kotlinx.android.synthetic.main.fragment_work_experience.*

class WorkExperienceFragment : Fragment() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<WorkExperience>
    lateinit var nameCompany: Array<String>
    lateinit var position : Array<String>
    lateinit var description : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work_experience, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameCompany = arrayOf(
            "ThaiDetox",
            "CMC Global",
            "Misa",
            "Namas",
            "FPT"
        )

        position = arrayOf(
            "Marketing",
            "Android Developer",
            "Android Developer",
            "Marketing",
            "Android Developer"
        )

        description = arrayOf(
            "- Viết bài SEO website\n" +
                    "- Chăm sóc khách hàng\n" +
                    "- Bán sản phẩm",
            "- Thiết kế và phát triển các phần mềm và ứng dụng nâng cao cho nền tảng Android.\n" +
                    "- Xử lý nguồn dữ liệu bên ngoài và API.\n" +
                    "- Phát hiện và sửa lỗi trên phần mềm.\n" +
                    "- Thực hiện các công việc để đảm bảo hiệu suất hoạt động, chất lượng và độ phản hồi tốt nhất của ứng dụng.",

            "- Thiết kế và phát triển các phần mềm và ứng dụng nâng cao cho nền tảng Android.\n" +
                    "- Xử lý nguồn dữ liệu bên ngoài và API.\n" +
                    "- Phát hiện và sửa lỗi trên phần mềm.\n" +
                    "- Thực hiện các công việc để đảm bảo hiệu suất hoạt động, chất lượng và độ phản hồi tốt nhất của ứng dụng.",
            "- Viết bài SEO website\n" +
                    "- Chăm sóc khách hàng\n" +
                    "- Bán sản phẩm",
            "- Thiết kế và phát triển các phần mềm và ứng dụng nâng cao cho nền tảng Android.\n" +
                    "- Xử lý nguồn dữ liệu bên ngoài và API.\n" +
                    "- Phát hiện và sửa lỗi trên phần mềm.\n" +
                    "- Thực hiện các công việc để đảm bảo hiệu suất hoạt động, chất lượng và độ phản hồi tốt nhất của ứng dụng.",
        )

        newRecyclerView = view.findViewById(R.id.rcvLv)
        newRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<WorkExperience>()
        getUserData()

        btnHome.setOnClickListener {
            val action = WorkExperienceFragmentDirections.actionWorkExperienceFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }

    private fun getUserData() {

        for (i in nameCompany.indices) {
            val workExperience = WorkExperience(nameCompany[i], position[i], description[i])
            newArrayList.add(workExperience)
        }

        newRecyclerView.adapter = WorkExperienceAdapter(newArrayList)
    }

}