package com.minjee.basicmvvmexample.model

import android.os.Parcel
import android.os.Parcelable

data class MyParcelableDataArgs(val email:String?): Parcelable {
    var userName: String?=null
    var password: Int=1

    constructor(parcel: Parcel) : this(parcel.readString()) {
        userName = parcel.readString()
        password = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(email)
        parcel.writeString(userName)
        parcel.writeInt(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyParcelableDataArgs> {
        override fun createFromParcel(parcel: Parcel): MyParcelableDataArgs {
            return MyParcelableDataArgs(parcel)
        }

        override fun newArray(size: Int): Array<MyParcelableDataArgs?> {
            return arrayOfNulls(size)
        }
    }
}