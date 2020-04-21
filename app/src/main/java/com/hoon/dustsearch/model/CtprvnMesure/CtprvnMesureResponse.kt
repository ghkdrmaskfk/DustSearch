package com.hoon.dustsearch.model.CtprvnMesure

import com.google.gson.annotations.SerializedName
import com.hoon.dustsearch.model.CtprvnMesure.CtprvnMesure

data class CtprvnMesureResponse(@SerializedName("list") val list : List<CtprvnMesure>,
                                @SerializedName("parm") val parm : CtprvnMesure,
                                @SerializedName("CtprvnMesureLIstVo") val CtprvnMesureLIstVo
                                : CtprvnMesure,
                                @SerializedName("totalCount") val totalCount : Int)