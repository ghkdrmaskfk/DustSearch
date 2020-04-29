package com.hoon.dustsearch.model.MsrstnAcctoRltmMesureDnsty

import com.google.gson.annotations.SerializedName

data class MsrstnAcctoRltmMesureDnstyResponse(
    @SerializedName("ArpltnInforInqireSvcVo")
    val ArpltnInforInqireSvcV: MsrstnAcctoRltmMesureDnsty)

//data class MsrstnAcctoRltmMesureDnstyResponse(@SerializedName("list") val list : List<MsrstnAcctoRltmMesureDnsty>,
//                                              @SerializedName("parm") val parm : MsrstnAcctoRltmMesureDnsty,
//                                              @SerializedName("ArpltnInforInqireSvcVo") val ArpltnInforInqireSvcVo
//                                              : MsrstnAcctoRltmMesureDnsty,
//                                              @SerializedName("totalCount") val totalCount : Int)