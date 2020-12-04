package com.mattrobertson.advent.data.json

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import org.junit.Test

class AdventFeedsParserTest {
    @Test
    fun `parse advent feed json`() {
        val json = "{\"sections\":[{\"title\":\"Advent Devotionals Feeds\",\"items\":[{\"label\":\"PrayerMate Advent Devotional 2020\",\"subtitle\":\"\",\"feed_url\":\"https://prayermate.s3-eu-west-1.amazonaws.com/f5308ae92fbad141a19f71c2616720644faa5.json\",\"image_url\":\"http://prayermate.s3.amazonaws.com/prayer_diaries/logo_images/000/005/375/square/2D7CA372-2328-4C0A-826E-5C3314068B51.png\"},{\"label\":\"Church Society: How to Be a Christian\",\"subtitle\":\"\",\"feed_url\":\"https://prayermate.s3-eu-west-1.amazonaws.com/f5306814d8abc1efc6660e7de7d7466166a3a.json\",\"image_url\":\"http://prayermate.s3.amazonaws.com/prayer_diaries/logo_images/000/005/373/square/howtobeachristian.jpg\"},{\"label\":\"Tearfund Our present: Hope\",\"subtitle\":\"\",\"feed_url\":\"https://prayermate.s3-eu-west-1.amazonaws.com/f5307ca951dd7cd9e12a7e91ed31104eab796.json\",\"image_url\":\"http://prayermate.s3.amazonaws.com/prayer_diaries/logo_images/000/005/374/square/You_version_640_x_640_AW-2.png\"},{\"label\":\"31 Days of Purity\",\"subtitle\":\"\",\"feed_url\":\"https://prayermate.s3-eu-west-1.amazonaws.com/f16431ca89e5ea09059327390510bd8e774ce.json\",\"image_url\":\"https://prayermate.s3-eu-west-1.amazonaws.com/feed_images/feed_fb21ac28-1210-4cbc-b0ca-2cee67bd7156.png\"},{\"label\":\"Come Let Us Adore Him\",\"subtitle\":\"\",\"feed_url\":\"https://prayermate.s3-eu-west-1.amazonaws.com/f53099732d1388c85eadd3c16a0a49a3eae8a.json\",\"image_url\":\"https://prayermate.s3-eu-west-1.amazonaws.com/feed_images/feed_8746f1d3-5343-4f34-9743-483500b6de0a.png\"},{\"label\":\"The Dawning of Indestructible Joy\",\"subtitle\":\"\",\"feed_url\":\"https://prayermate.s3-eu-west-1.amazonaws.com/f5311420debb72167a86324663a6a9285f026.json\",\"image_url\":\"https://prayermate.s3-eu-west-1.amazonaws.com/feed_images/feed_46618c34-be38-49f4-b106-e6b98c560814.png\"},{\"label\":\"Praying Through Advent\",\"subtitle\":\"\",\"feed_url\":\"https://prayermate.s3-eu-west-1.amazonaws.com/f5312e165484ab30ae893565e85dd5cabd8df.json\",\"image_url\":\"http://prayermate.s3.amazonaws.com/prayer_diaries/logo_images/000/002/178/square/praying_through_advent.png\"},{\"label\":\"See your organisation here\",\"web_url\":\"https://blog.prayermate.net/how-to-create-a-prayermate-feed-for-your-organisation-332cb51faa94/?utm_source=prayermate\\u0026utm_medium=app\\u0026utm_campaign=publisher_see_yourself_here\",\"image_resource\":\"gallery_add\"}]}]}"

        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<AdventFeedsList> = moshi.adapter(AdventFeedsList::class.java)
        val feeds = adapter.fromJson(json)
    }
}