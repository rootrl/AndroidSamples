package com.rootrl.androidsamples.Gson.Ads;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Data struct
 * {
 *         status: 0,
 *         message: "Data request ok",
 *         data: {
 *             count: 3,
 *             adList: [
 *             {
 *                 type: 1,
 *                 src: "http://baidu.com",
 *                 date: "2018-09-15"
 *             },
 *             {
 *                  type: 2,
 *                  src: "http://baidu.com",
 *                  date: "2018-09-16"
 *             },
 *             {
 *                 type: 3,
 *                 src: "http://baidu.com",
 *                 date: "2018-09-11"
 *             }
 *             ]
 *         }
 * }
 */
public class Ad {
    public int status;

    @SerializedName("message")
    public String message;

    public Data data;
}
