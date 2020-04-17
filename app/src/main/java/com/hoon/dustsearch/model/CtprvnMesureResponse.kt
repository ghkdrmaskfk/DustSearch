package com.hoon.dustsearch.model

import com.google.gson.annotations.SerializedName

data class CtprvnMesureResponse(@SerializedName("list") val list : List<CtprvnMesure>,
                                @SerializedName("parm") val parm : CtprvnMesure,
                                @SerializedName("CtprvnMesureLIstVo") val CtprvnMesureLIstVo : CtprvnMesure,
                                @SerializedName("totalCount") val totalCount : Int)