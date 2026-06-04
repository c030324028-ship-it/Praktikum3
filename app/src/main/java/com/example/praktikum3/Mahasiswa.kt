package com.example.praktikum3

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//@SuppressLint("ParcelCreator")
data class Mahasiswa(
    val nama: String?,
    val nim: String?,
    val nilai: Int?,
    val grade: String?

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeString(nama)
        p0.writeString(nim)
        p0.writeInt(nilai ?: 0)
        p0.writeString(grade)
    }

    companion object CREATOR : Parcelable.Creator<Mahasiswa> {
        override fun createFromParcel(parcel: Parcel): Mahasiswa {
            return Mahasiswa(parcel)
        }

        override fun newArray(size: Int): Array<Mahasiswa?> {
            return arrayOfNulls(size)
        }
    }
}
