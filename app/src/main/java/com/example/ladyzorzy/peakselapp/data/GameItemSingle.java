package com.example.ladyzorzy.peakselapp.data;

public class GameItemSingle {

    String _id;
    String _date,date_gmt,guid_rendered;
    String _modified;
    String modified_gmt;
    String slug;
    String status;
    String _type;
    String _link;
    String content_rendered;
    String title_rendered;
    String author;
    String featured_media;
    String template;

    String acf_android_app_url ;
    String acf_ipone_app_url ;
    String acf_amazon_app_url ;
    String  acf_windows_phone_app_url ;
    String acf_video_link ;
    String acf_social_fb_url ;
    String acf_press_kit_url ;
    String acf_app_icon ;
    String acf_stream_app_url;
    String acf_printable_pdf;
    String acf_game_price ;
    String acf_game_wallpaper ;
    String acf_promo_text ;


    String ScreenshootMedium1;
    String ScreenshootMedium2;
    String ScreenshootMedium3;
    String ScreenshootMedium4;
    String ScreenshootMedium5;
    String ScreenshootMedium6;
    String ScreenshootMedium7;
    String ScreenshootMedium8;
    String ScreenshootFull1;
    String ScreenshootFull2;
    String ScreenshootFull3;
    String ScreenshootFull4;
    String ScreenshootFull5;
    String ScreenshootFull6;
    String ScreenshootFull7;
    String ScreenshootFull8;


    String featured_image;
    String app_icon;

    public GameItemSingle() {
    }

    public GameItemSingle(String _id, String _date, String date_gmt, String guid_rendered, String _modified, String modified_gmt, String slug, String status,
                          String _type, String _link, String content_rendered, String title_rendered, String author, String featured_media, String template,
                          String acf_android_app_url, String acf_ipone_app_url, String acf_amazon_app_url, String acf_windows_phone_app_url, String acf_video_link,
                          String acf_social_fb_url, String acf_press_kit_url, String acf_app_icon, String acf_stream_app_url, String acf_printable_pdf,
                          String acf_game_price, String acf_game_wallpaper, String acf_promo_text,String featured_image, String app_icon, String screenshootMedium1, String screenshootMedium2,
                          String screenshootMedium3, String screenshootMedium4, String screenshootMedium5, String screenshootMedium6, String screenshootMedium7,
                          String screenshootMedium8, String screenshootFull1, String screenshootFull2, String screenshootFull3, String screenshootFull4,
                          String screenshootFull5, String screenshootFull6, String screenshootFull7, String screenshootFull8) {
        this._id = _id;
        this._date = _date;
        this.date_gmt = date_gmt;
        this.guid_rendered = guid_rendered;
        this._modified = _modified;
        this.modified_gmt = modified_gmt;
        this.slug = slug;
        this.status = status;
        this._type = _type;
        this._link = _link;
        this.content_rendered = content_rendered;
        this.title_rendered = title_rendered;
        this.author = author;
        this.featured_media = featured_media;
        this.template = template;
        this.acf_android_app_url = acf_android_app_url;
        this.acf_ipone_app_url = acf_ipone_app_url;
        this.acf_amazon_app_url = acf_amazon_app_url;
        this.acf_windows_phone_app_url = acf_windows_phone_app_url;
        this.acf_video_link = acf_video_link;
        this.acf_social_fb_url = acf_social_fb_url;
        this.acf_press_kit_url = acf_press_kit_url;
        this.acf_app_icon = acf_app_icon;
        this.acf_stream_app_url = acf_stream_app_url;
        this.acf_printable_pdf = acf_printable_pdf;
        this.acf_game_price = acf_game_price;
        this.acf_game_wallpaper = acf_game_wallpaper;
        this.acf_promo_text = acf_promo_text;
        this.featured_image = featured_image;
        this.app_icon = app_icon;
        this.ScreenshootMedium1 = screenshootMedium1;
        this.ScreenshootMedium2 = screenshootMedium2;
        this.ScreenshootMedium3 = screenshootMedium3;
        this.ScreenshootMedium4 = screenshootMedium4;
        this.ScreenshootMedium5 = screenshootMedium5;
        this.ScreenshootMedium6 = screenshootMedium6;
        this.ScreenshootMedium7 = screenshootMedium7;
        this.ScreenshootMedium8 = screenshootMedium8;
        this.ScreenshootFull1 = screenshootFull1;
        this.ScreenshootFull2 = screenshootFull2;
        this.ScreenshootFull3 = screenshootFull3;
        this.ScreenshootFull4 = screenshootFull4;
        this.ScreenshootFull5 = screenshootFull5;
        this.ScreenshootFull6 = screenshootFull6;
        this.ScreenshootFull7 = screenshootFull7;
        this.ScreenshootFull8 = screenshootFull8;

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_date() {
        return _date;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public String getDate_gmt() {
        return date_gmt;
    }

    public void setDate_gmt(String date_gmt) {
        this.date_gmt = date_gmt;
    }

    public String getGuid_rendered() {
        return guid_rendered;
    }

    public void setGuid_rendered(String guid_rendered) {
        this.guid_rendered = guid_rendered;
    }

    public String get_modified() {
        return _modified;
    }

    public void set_modified(String _modified) {
        this._modified = _modified;
    }

    public String getModified_gmt() {
        return modified_gmt;
    }

    public void setModified_gmt(String modified_gmt) {
        this.modified_gmt = modified_gmt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String get_link() {
        return _link;
    }

    public void set_link(String _link) {
        this._link = _link;
    }

    public String getContent_rendered() {
        return content_rendered;
    }

    public void setContent_rendered(String content_rendered) {
        this.content_rendered = content_rendered;
    }

    public String getTitle_rendered() {
        return title_rendered;
    }

    public void setTitle_rendered(String title_rendered) {
        this.title_rendered = title_rendered;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeatured_media() {
        return featured_media;
    }

    public void setFeatured_media(String featured_media) {
        this.featured_media = featured_media;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getAcf_android_app_url() {
        return acf_android_app_url;
    }

    public void setAcf_android_app_url(String acf_android_app_url) {
        this.acf_android_app_url = acf_android_app_url;
    }

    public String getAcf_ipone_app_url() {
        return acf_ipone_app_url;
    }

    public void setAcf_ipone_app_url(String acf_ipone_app_url) {
        this.acf_ipone_app_url = acf_ipone_app_url;
    }

    public String getAcf_amazon_app_url() {
        return acf_amazon_app_url;
    }

    public void setAcf_amazon_app_url(String acf_amazon_app_url) {
        this.acf_amazon_app_url = acf_amazon_app_url;
    }

    public String getAcf_windows_phone_app_url() {
        return acf_windows_phone_app_url;
    }

    public void setAcf_windows_phone_app_url(String acf_windows_phone_app_url) {
        this.acf_windows_phone_app_url = acf_windows_phone_app_url;
    }

    public String getAcf_video_link() {
        return acf_video_link;
    }

    public void setAcf_video_link(String acf_video_link) {
        this.acf_video_link = acf_video_link;
    }

    public String getAcf_social_fb_url() {
        return acf_social_fb_url;
    }

    public void setAcf_social_fb_url(String acf_social_fb_url) {
        this.acf_social_fb_url = acf_social_fb_url;
    }

    public String getAcf_press_kit_url() {
        return acf_press_kit_url;
    }

    public void setAcf_press_kit_url(String acf_press_kit_url) {
        this.acf_press_kit_url = acf_press_kit_url;
    }

    public String getAcf_app_icon() {
        return acf_app_icon;
    }

    public void setAcf_app_icon(String acf_app_icon) {
        this.acf_app_icon = acf_app_icon;
    }

    public String getAcf_stream_app_url() {
        return acf_stream_app_url;
    }

    public void setAcf_stream_app_url(String acf_stream_app_url) {
        this.acf_stream_app_url = acf_stream_app_url;
    }

    public String getAcf_printable_pdf() {
        return acf_printable_pdf;
    }

    public void setAcf_printable_pdf(String acf_printable_pdf) {
        this.acf_printable_pdf = acf_printable_pdf;
    }

    public String getAcf_game_price() {
        return acf_game_price;
    }

    public void setAcf_game_price(String acf_game_price) {
        this.acf_game_price = acf_game_price;
    }

    public String getAcf_game_wallpaper() {
        return acf_game_wallpaper;
    }

    public void setAcf_game_wallpaper(String acf_game_wallpaper) {
        this.acf_game_wallpaper = acf_game_wallpaper;
    }

    public String getAcf_promo_text() {
        return acf_promo_text;
    }

    public void setAcf_promo_text(String acf_promo_text) {
        this.acf_promo_text = acf_promo_text;
    }

    public String getScreenshootMedium1() {
        return ScreenshootMedium1;
    }

    public void setScreenshootMedium1(String screenshootMedium1) {
        ScreenshootMedium1 = screenshootMedium1;
    }

    public String getScreenshootMedium2() {
        return ScreenshootMedium2;
    }

    public void setScreenshootMedium2(String screenshootMedium2) {
        ScreenshootMedium2 = screenshootMedium2;
    }

    public String getScreenshootMedium3() {
        return ScreenshootMedium3;
    }

    public void setScreenshootMedium3(String screenshootMedium3) {
        ScreenshootMedium3 = screenshootMedium3;
    }

    public String getScreenshootMedium4() {
        return ScreenshootMedium4;
    }

    public void setScreenshootMedium4(String screenshootMedium4) {
        ScreenshootMedium4 = screenshootMedium4;
    }

    public String getScreenshootMedium5() {
        return ScreenshootMedium5;
    }

    public void setScreenshootMedium5(String screenshootMedium5) {
        ScreenshootMedium5 = screenshootMedium5;
    }

    public String getScreenshootMedium6() {
        return ScreenshootMedium6;
    }

    public void setScreenshootMedium6(String screenshootMedium6) {
        ScreenshootMedium6 = screenshootMedium6;
    }

    public String getScreenshootMedium7() {
        return ScreenshootMedium7;
    }

    public void setScreenshootMedium7(String screenshootMedium7) {
        ScreenshootMedium7 = screenshootMedium7;
    }

    public String getScreenshootMedium8() {
        return ScreenshootMedium8;
    }

    public void setScreenshootMedium8(String screenshootMedium8) {
        ScreenshootMedium8 = screenshootMedium8;
    }

    public String getScreenshootFull1() {
        return ScreenshootFull1;
    }

    public void setScreenshootFull1(String screenshootFull1) {
        ScreenshootFull1 = screenshootFull1;
    }

    public String getScreenshootFull2() {
        return ScreenshootFull2;
    }

    public void setScreenshootFull2(String screenshootFull2) {
        ScreenshootFull2 = screenshootFull2;
    }

    public String getScreenshootFull3() {
        return ScreenshootFull3;
    }

    public void setScreenshootFull3(String screenshootFull3) {
        ScreenshootFull3 = screenshootFull3;
    }

    public String getScreenshootFull4() {
        return ScreenshootFull4;
    }

    public void setScreenshootFull4(String screenshootFull4) {
        ScreenshootFull4 = screenshootFull4;
    }

    public String getScreenshootFull5() {
        return ScreenshootFull5;
    }

    public void setScreenshootFull5(String screenshootFull5) {
        ScreenshootFull5 = screenshootFull5;
    }

    public String getScreenshootFull6() {
        return ScreenshootFull6;
    }

    public void setScreenshootFull6(String screenshootFull6) {
        ScreenshootFull6 = screenshootFull6;
    }

    public String getScreenshootFull7() {
        return ScreenshootFull7;
    }

    public void setScreenshootFull7(String screenshootFull7) {
        ScreenshootFull7 = screenshootFull7;
    }

    public String getScreenshootFull8() {
        return ScreenshootFull8;
    }

    public void setScreenshootFull8(String screenshootFull8) {
        ScreenshootFull8 = screenshootFull8;
    }

    public String getFeatured_image() {
        return featured_image;
    }

    public void setFeatured_image(String featured_image) {
        this.featured_image = featured_image;
    }

    public String getApp_icon() {
        return app_icon;
    }

    public void setApp_icon(String app_icon) {


        this.app_icon = app_icon;
    }
}
