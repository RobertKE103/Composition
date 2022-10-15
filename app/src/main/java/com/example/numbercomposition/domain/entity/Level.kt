package com.example.numbercomposition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
enum class Level: Serializable, Parcelable {
    TEST,
    EASY,
    NORMAL,
    HARD
}