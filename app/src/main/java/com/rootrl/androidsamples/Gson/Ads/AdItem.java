package com.rootrl.androidsamples.Gson.Ads;

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
public class AdItem {
    public int type;

    public String src;

    public String date;
}
