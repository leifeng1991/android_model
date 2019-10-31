package com.leifeng.android.base.mvvm.model

import java.io.Serializable
import java.util.ArrayList

class DynamicListBean : Serializable {
    /**
     * id : 11
     * title :
     * uid : 111346
     * pv : 0
     * upper : 0
     * comment : 0
     * img : ["http://zhaolin-10029121.image.myqcloud.com/sample1506325183629","http://zhaolin-10029121.image.myqcloud.com/sample1506325183884"]
     * addtime : 1506325184
     * simg : http://zhaolin-10029121.image.myqcloud.com/sample1493868934023
     * sex : 2
     * birthday : 936806400
     * constellation : 处女座
     * username : 李奇不不不跨步不我额
     * is_upper : 0
     * juli : 0
     * icon : []
     * age : 18
     */

    var id: String? = null
    var title: String? = null
    var uid: String? = null
    var addtime: String? = null
    var longitude: String? = null
    var latitude: String? = null
    var pv: String? = null
    var upper: String? = null
    var comment: String? = null
    var location: String? = null
    var video: String? = null
    var video_img: String? = null
    var is_upper: String? = null
    var count: String? = null
    var img = ArrayList<String>()

}
