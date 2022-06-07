package com.example.appprofile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appprofile.Constants
import com.example.appprofile.R
import com.example.appprofile.databinding.FragmentHomeBinding
import com.example.appprofile.model.EducationLevel
import com.example.appprofile.model.User
import com.example.appprofile.model.WorkExperience
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val user = User(
        name = "Nguyễn Thị Thu Hà",
        sex = "Nữ",
        birthday = "13/04/2001",
        phoneNumber = "0358604666",
        homeTown = "Hưng Yên",
        hobby = "Đá cầu, bóng chuyền, cầu lông, đọc sách, nghe nhạc, đi du lịch,...",
        email = "nguyenthuha@gmail.com",
        facebook = "https://www.facebook.com/profile.php?id=100006607638182",
        primarySchool = EducationLevel(
            nameSchool = "Trường tiểu học Tân Việt",
            certificate = "Bằng cấp: giỏi"
        ),
        secondarySchool = EducationLevel(
            nameSchool = "Trường trung học cơ sở Tân Việt",
            certificate = "Bằng cấp: giỏi"
        ),
        highSchool = EducationLevel(
            nameSchool = "Trường trung học phổ thông Minh Châu",
            certificate = "Bằng cấp: giỏi"
        ),
        university = EducationLevel(
            nameSchool = "Trường đại học Giao thông vân tải",
            certificate = "Bằng cấp xuất sắc"
        ),
        thaiDetoxCompany = WorkExperience(
            nameCompany = "ThaiDetox",
            position = "Marketing",
            description = "- Viết bài SEO website\n" +
                    "- Chăm sóc khách hàng\n" +
                    "- Bán sản phẩm"
        ),
        cmcGlobalCompany = WorkExperience(
            nameCompany = "CMC Global",
            position = "Android Developer",
            description = "- Thiết kế và phát triển các phần mềm và ứng dụng nâng cao cho nền tảng Android.\n" +
                    "- Xử lý nguồn dữ liệu bên ngoài và API.\n" +
                    "- Phát hiện và sửa lỗi trên phần mềm.\n" +
                    "- Thực hiện các công việc để đảm bảo hiệu suất hoạt động, chất lượng và độ phản hồi tốt nhất của ứng dụng."
        ),
        misaCompany = WorkExperience(
            nameCompany = "Misa",
            position = "Android Developer",
            description = "- Thiết kế và phát triển các phần mềm và ứng dụng nâng cao cho nền tảng Android.\n" +
                    "- Xử lý nguồn dữ liệu bên ngoài và API.\n" +
                    "- Phát hiện và sửa lỗi trên phần mềm.\n" +
                    "- Thực hiện các công việc để đảm bảo hiệu suất hoạt động, chất lượng và độ phản hồi tốt nhất của ứng dụng."
        ),
        namasCompany = WorkExperience(
            nameCompany = "Namas",
            position = "Marketing",
            description = "- Viết bài SEO website\n" +
                    "- Chăm sóc khách hàng\n" +
                    "- Bán sản phẩm"
        ),
        fptCompany = WorkExperience(
            nameCompany = "FPT",
            position = "Android Developer",
            description = "- Thiết kế và phát triển các phần mềm và ứng dụng nâng cao cho nền tảng Android.\n" +
                    "- Xử lý nguồn dữ liệu bên ngoài và API.\n" +
                    "- Phát hiện và sửa lỗi trên phần mềm.\n" +
                    "- Thực hiện các công việc để đảm bảo hiệu suất hoạt động, chất lượng và độ phản hồi tốt nhất của ứng dụng."
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
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
            val bundle = bundleOf()
            bundle.putSerializable(Constants.BundleKey.KEY_USER, user)
            findNavController().navigate(
                R.id.action_homeFragment_to_educationLevelFragment2,
                bundle
            )
        }
    }
}