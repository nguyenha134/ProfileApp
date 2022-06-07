package com.example.appprofile.model

import java.io.Serializable

data class User(
    val name: String,
    val sex: String,
    val birthday: String,
    val phoneNumber: String,
    val homeTown: String,
    val hobby: String,
    val email: String,
    val facebook: String,
    val primarySchool: EducationLevel,
    val secondarySchool: EducationLevel,
    val highSchool: EducationLevel,
    val university: EducationLevel,
    val thaiDetoxCompany : WorkExperience,
    val cmcGlobalCompany: WorkExperience,
    val misaCompany: WorkExperience,
    val namasCompany: WorkExperience,
    val fptCompany: WorkExperience

) : Serializable