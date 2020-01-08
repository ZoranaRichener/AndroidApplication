package com.example.ladyzorzy.peakselapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ladyzorzy.peakselapp.data.GameItemSingle;
import com.example.ladyzorzy.peakselapp.data.GamesItemHome;
import com.example.ladyzorzy.peakselapp.data.TestimonialsItem;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {


    ///// HOME //////////
    public static String KEY_ID_GAME = "_id";
    public static String KEY_TITLE = "title";
    public static String KEY_IMAGE = "image";
    public static String KEY_FEATURED_IMAGE_HOME = "featured_image";
    public static String KEY_CATEGORY = "category";
    public static String KEY_LINK_HOME = "link";

    static String DATABASE_NAME = "peaksel.db";

    static String DATABASE_TABLE_SLIDER = "slider_table";
    static String DATABASE_TABLE_TOP_APPS = "top_apps_table";
    static String DATABASE_TABLE_VIRTUAL_GAMES = "virtual_games_table";
    static String DATABASE_TABLE_QUIZ_GAMES = "quiz_games_table";
    static String DATABASE_TABLE_MATH_GAMES = "math_games_table";
    static String DATABASE_TABLE_CASUAL_GAMES = "casual_games_table";
    static String DATABASE_TABLE_COLORING_PAGES = "coloring_pages_table";
    static String DATABASE_TABLE_DO_NOT_MISS = "do_not_miss_table";

    static final String TAG = "TAG";

    String DATABASE_CREATE = "CREATE TABLE " + DATABASE_TABLE_SLIDER + " (" +
            KEY_ID_GAME + " INTEGER PRIMARY KEY ," +
            KEY_TITLE + " TEXT," +
            KEY_IMAGE + " TEXT ," +
            KEY_FEATURED_IMAGE_HOME + " TEXT ," +
            KEY_CATEGORY + " TEXT ," +
            KEY_LINK_HOME + " TEXT );";

    String TABLE_TOP_APPS_CREATE = "CREATE TABLE " + DATABASE_TABLE_TOP_APPS + " (" +
            KEY_ID_GAME + " INTEGER PRIMARY KEY ," +
            KEY_TITLE + " TEXT," +
            KEY_IMAGE + " TEXT ," +
            KEY_FEATURED_IMAGE_HOME + " TEXT ," +
            KEY_CATEGORY + " TEXT ," +
            KEY_LINK_HOME + " TEXT );";

    String TABLE_VIRTUAL_GAMES_CREATE = "CREATE TABLE " + DATABASE_TABLE_VIRTUAL_GAMES + " (" +
            KEY_ID_GAME + " INTEGER PRIMARY KEY ," +
            KEY_TITLE + " TEXT," +
            KEY_IMAGE + " TEXT ," +
            KEY_FEATURED_IMAGE_HOME + " TEXT ," +
            KEY_CATEGORY + " TEXT ," +
            KEY_LINK_HOME + " TEXT );";

    String TABLE_QUIZ_GAMES_CREATE = "CREATE TABLE " + DATABASE_TABLE_QUIZ_GAMES + " (" +
            KEY_ID_GAME + " INTEGER PRIMARY KEY ," +
            KEY_TITLE + " TEXT," +
            KEY_IMAGE + " TEXT ," +
            KEY_FEATURED_IMAGE_HOME + " TEXT ," +
            KEY_CATEGORY + " TEXT ," +
            KEY_LINK_HOME + " TEXT );";

    String TABLE_MATH_GAMES_CREATE = "CREATE TABLE " + DATABASE_TABLE_MATH_GAMES + " (" +
            KEY_ID_GAME + " INTEGER PRIMARY KEY ," +
            KEY_TITLE + " TEXT," +
            KEY_IMAGE + " TEXT ," +
            KEY_FEATURED_IMAGE_HOME + " TEXT ," +
            KEY_CATEGORY + " TEXT ," +
            KEY_LINK_HOME + " TEXT );";

    String TABLE_CASUAL_GAMES_CREATE = "CREATE TABLE " + DATABASE_TABLE_CASUAL_GAMES + " (" +
            KEY_ID_GAME + " INTEGER PRIMARY KEY ," +
            KEY_TITLE + " TEXT," +
            KEY_IMAGE + " TEXT ," +
            KEY_FEATURED_IMAGE_HOME + " TEXT ," +
            KEY_CATEGORY + " TEXT ," +
            KEY_LINK_HOME + " TEXT );";

    String TABLE_COLORING_GAMES_CREATE = "CREATE TABLE " + DATABASE_TABLE_COLORING_PAGES + " (" +
            KEY_ID_GAME + " INTEGER PRIMARY KEY ," +
            KEY_TITLE + " TEXT," +
            KEY_IMAGE + " TEXT ," +
            KEY_FEATURED_IMAGE_HOME + " TEXT ," +
            KEY_CATEGORY + " TEXT ," +
            KEY_LINK_HOME + " TEXT );";

    String TABLE_DO_NOT_MISS_CREATE = "CREATE TABLE " + DATABASE_TABLE_DO_NOT_MISS + " (" +
            KEY_ID_GAME + " INTEGER PRIMARY KEY ," +
            KEY_TITLE + " TEXT," +
            KEY_IMAGE + " TEXT ," +
            KEY_FEATURED_IMAGE_HOME + " TEXT ," +
            KEY_CATEGORY + " TEXT ," +
            KEY_LINK_HOME + " TEXT );";

    //SINGLE PAGE

    public static  String KEY_ID = "id";
    public static  String KEY_DATE = "date";
    public static  String KEY_DATE_GMT = "date_gmt";
    public static  String KEY_GUID_RENDERED = "guid_rendered";
    public static  String KEY_MODIFIED = "modified";
    public static  String KEY_MODIFIED_GMT = "modified_gmt";
    public static  String KEY_SLUG = "slug";
    public static  String KEY_STATUS = "status";
    public static  String KEY_TYPE = "_type";
    public static  String KEY_LINK = "_link";
    public static  String KEY_CONTENT_RENDERED = "content_rendered";
    public static  String KEY_TITLE_RENDERED = "title_rendered";
    public static  String KEY_AUTHOR = "key_author";
    public static  String KEY_FEATURED_MEDIA = "key_featured_media";
    public static  String KEY_TEMPLATE = "template";


    public static String KEY_ACF_ANDROID_APP_URL = "acf_android_app_url" ;
    public static String KEY_ACF_IPHONE_APP_URL = "acf_ipone_app_url";
    public static String KEY_ACF_AMAZON_APP_URL=  "acf_amazon_app_url" ;
    public static String KEY_ACF_WINDOWS_PHONE_APP_URL= "acf_windows_phone_app_url" ;
    public static String KEY_ACF_VIDEO_LINK =  "acf_video_link" ;
    public static String KEY_ACF_SOCIAL_FB_URL = "acf_social_fb_url" ;
    public static String KEY_ACF_PRESS_KIT_URL = "acf_press_kit_url" ;
    public static String KEY_ACF_APP_ICON = "acf_app_icon" ;
    public static String KEY_ACF_STREAM_APP_URL = "acf_stream_app_url";
    public static String KEY_ACF_PRINTABLE_PDF= "acf_printable_pdf";
    public static String KEY_ACF_GAME_PRICE = "acf_game_price" ;
    public static String KEY_ACF_GAME_WALLPAPER = "acf_game_wallpaper" ;
    public static String KEY_ACF_PROMO_TEXT = "acf_promo_text" ;

    public static  String KEY_FEATURED_IMAGE = "featured_image";
    public static  String KEY_APP_ICON = "app_icon_image";

    public static String KEY_SCREENSHOOT_MEDIUM1=  "ScreenshootMedium1";
    public static String KEY_SCREENSHOOT_MEDIUM2 ="ScreenshootMedium2";
    public static String KEY_SCREENSHOOT_MEDIUM3 ="ScreenshootMedium3";
    public static  String KEY_SCREENSHOOT_MEDIUM4 = "ScreenshootMedium4";
    public static String KEY_SCREENSHOOT_MEDIUM5 ="ScreenshootMedium5";
    public static String KEY_SCREENSHOOT_MEDIUM6 ="ScreenshootMedium6";
    public static String KEY_SCREENSHOOT_MEDIUM7 ="ScreenshootMedium7";
    public static  String KEY_SCREENSHOOT_MEDIUM8 ="ScreenshootMedium8";
    public static String KEY_SCREENSHOOT_FULL1 = "ScreenshootFull1";
    public static  String KEY_SCREENSHOOT_FULL2 = "ScreenshootFull2";
    public static String KEY_SCREENSHOOT_FULL3 = "ScreenshootFull3";
    public static String KEY_SCREENSHOOT_FULL4 = "ScreenshootFull4";
    public static String KEY_SCREENSHOOT_FULL5= "ScreenshootFull5";
    public static String KEY_SCREENSHOOT_FULL6= "ScreenshootFull6";
    public static String KEY_SCREENSHOOT_FULL7 = "ScreenshootFull7";
    public static  String KEY_SCREENSHOOT_FULL8 = "ScreenshootFull8";


    public static  String DATABASE_TABLE_SINGLE_PAGE = "games";

    static String DATABASE_TABLE_NAME_TESTIMONIALS = "testimonials";

    public static  String KEY_TESTIMONIALS_ID = "testimonial_id";
    public static String KEY_GAME_ID = "id";
    public static  String KEY_COLUMN_CONTENT = "content";
    public static  String KEY_COLUMN_AUTHOR = "author";
    public static  String KEY_COLUMN_RATING = "rating";

    String DATABASE_CREATE_TESTIMONIALS = "CREATE TABLE " + DATABASE_TABLE_NAME_TESTIMONIALS + " (" +
            KEY_TESTIMONIALS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            KEY_GAME_ID + " TEXT ," +
            KEY_COLUMN_CONTENT + " TEXT ," +
            KEY_COLUMN_AUTHOR + " TEXT ," +
            KEY_COLUMN_RATING + " TEXT ," + " TEXT );";


    //static final String TAG = "TAG";

    String DATABASE_CREATE_SINGLE_TABLE = "CREATE TABLE " + DATABASE_TABLE_SINGLE_PAGE + " (" +
            KEY_ID + " INTEGER PRIMARY KEY ," +
            KEY_DATE + " TEXT," +
            KEY_DATE_GMT + " TEXT ," +
            KEY_GUID_RENDERED + " TEXT ," +
            KEY_MODIFIED + " TEXT ," +
            KEY_MODIFIED_GMT + " TEXT ," +
            KEY_SLUG + " TEXT ," +
            KEY_STATUS + " TEXT ," +
            KEY_TYPE + " TEXT ," +
            KEY_LINK + " TEXT ," +
            KEY_CONTENT_RENDERED + " TEXT ," +
            KEY_TITLE_RENDERED + " TEXT ," +
            KEY_AUTHOR + " TEXT ," +
            KEY_FEATURED_MEDIA + " TEXT ," +
            KEY_TEMPLATE + " TEXT ," +

            KEY_ACF_ANDROID_APP_URL + " TEXT ," +
            KEY_ACF_IPHONE_APP_URL + " TEXT ," +
            KEY_ACF_AMAZON_APP_URL + " TEXT ," +
            KEY_ACF_WINDOWS_PHONE_APP_URL + " TEXT ," +
            KEY_ACF_VIDEO_LINK + " TEXT ," +
            KEY_ACF_SOCIAL_FB_URL + " TEXT ," +
            KEY_ACF_PRESS_KIT_URL + " TEXT ," +
            KEY_ACF_APP_ICON + " TEXT ," +
            KEY_ACF_STREAM_APP_URL + " TEXT ," +
            KEY_ACF_PRINTABLE_PDF + " TEXT ," +
            KEY_ACF_GAME_PRICE + " TEXT ," +
            KEY_ACF_GAME_WALLPAPER + " TEXT ," +
            KEY_ACF_PROMO_TEXT + " TEXT ," +

            KEY_SCREENSHOOT_MEDIUM1 + " TEXT ," +
            KEY_SCREENSHOOT_MEDIUM2 + " TEXT ," +
            KEY_SCREENSHOOT_MEDIUM3 + " TEXT ," +
            KEY_SCREENSHOOT_MEDIUM4 + " TEXT ," +
            KEY_SCREENSHOOT_MEDIUM5 + " TEXT ," +
            KEY_SCREENSHOOT_MEDIUM6 + " TEXT ," +
            KEY_SCREENSHOOT_MEDIUM7 + " TEXT ," +
            KEY_SCREENSHOOT_MEDIUM8 + " TEXT ," +

            KEY_SCREENSHOOT_FULL1 + " TEXT ," +
            KEY_SCREENSHOOT_FULL2 + " TEXT ," +
            KEY_SCREENSHOOT_FULL3 + " TEXT ," +
            KEY_SCREENSHOOT_FULL4 + " TEXT ," +
            KEY_SCREENSHOOT_FULL5 + " TEXT ," +
            KEY_SCREENSHOOT_FULL6 + " TEXT ," +
            KEY_SCREENSHOOT_FULL7 + " TEXT ," +
            KEY_SCREENSHOOT_FULL8 + " TEXT ," +

            KEY_FEATURED_IMAGE + " TEXT ," +
            KEY_APP_ICON + " TEXT ," + " TEXT );";


    ////////////////

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{

            ///SINGLE
            db.execSQL(DATABASE_CREATE_SINGLE_TABLE);
            db.execSQL(DATABASE_CREATE_TESTIMONIALS);


            //HOME

            db.execSQL(DATABASE_CREATE);
            db.execSQL(TABLE_DO_NOT_MISS_CREATE);
            db.execSQL(TABLE_VIRTUAL_GAMES_CREATE);
            db.execSQL(TABLE_TOP_APPS_CREATE);
            db.execSQL(TABLE_CASUAL_GAMES_CREATE);
            db.execSQL(TABLE_COLORING_GAMES_CREATE);
            db.execSQL(TABLE_MATH_GAMES_CREATE);
            db.execSQL(TABLE_QUIZ_GAMES_CREATE);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // db.execSQL("DROP TABLE IF EXISTS "+TABLE+" ;");

        Log.w(TAG, "Ažuriranje verzije baze podataka sa " + oldVersion + " na verziju "
                + newVersion + ", a to će uništiti postojeće podatke");
        db.execSQL("DROP TABLE IF EXISTS single_page_table");
        db.execSQL("DROP TABLE IF EXISTS top_apps_table ");
        db.execSQL("DROP TABLE IF EXISTS virtual_games_table ");
        db.execSQL("DROP TABLE IF EXISTS quiz_games_table ");
        db.execSQL("DROP TABLE IF EXISTS math_games_table ");
        db.execSQL("DROP TABLE IF EXISTS casual_games_table ");
        db.execSQL("DROP TABLE IF EXISTS coloring_pages_table ");
        db.execSQL("DROP TABLE IF EXISTS do_not_miss_table ");

        ///SINGLE
        db.execSQL("DROP TABLE IF EXISTS single_page_table ");

        //TESTIMONIALS
        db.execSQL("DROP TABLE IF EXISTS testimonials ");


        onCreate(db);
    }

    //DELETE CONTENT
//    deletePreviousContent();
//        this.getWritableDatabase().beginTransaction();
//
//    //dole
//        this.getWritableDatabase().setTransactionSuccessful();
//        this.getWritableDatabase().endTransaction();

    private void deletePreviousContent()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE_SINGLE_PAGE, null, null);
        db.close();
    }

    private void deleteSliderItemPreviousContent()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE_SLIDER, null, null);
        db.close();
    }


    //---umetanje slider array liste u bazu---
    public void insertSliderItemArray(ArrayList<GamesItemHome> argList) {

        deleteSliderItemPreviousContent();
        this.getWritableDatabase().beginTransaction();

        for (GamesItemHome gameItem : argList) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues initialValues = new ContentValues();
            initialValues.put(KEY_ID_GAME, gameItem.getID());
            initialValues.put(KEY_TITLE, gameItem.getTitle());
            initialValues.put(KEY_IMAGE, gameItem.getImage());
            initialValues.put(KEY_FEATURED_IMAGE_HOME, gameItem.getFeautred_image());
            initialValues.put(KEY_CATEGORY, gameItem.getCategory());
            initialValues.put(KEY_LINK_HOME, gameItem.getLink());
            db.insert(DATABASE_TABLE_SLIDER, null, initialValues);
        }

        this.getWritableDatabase().setTransactionSuccessful();
        this.getWritableDatabase().endTransaction();

    }

    // povlacenje podataka iz baze
    public ArrayList<GamesItemHome> getSliderData() {

        ArrayList<GamesItemHome> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + DATABASE_TABLE_SLIDER + " ;", null);
        StringBuffer stringBuffer = new StringBuffer();
        GamesItemHome gamesItem = null;
        while (cursor.moveToNext()) {
            gamesItem = new GamesItemHome();
            String id =cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
            String category = cursor.getString(cursor.getColumnIndexOrThrow("category"));
            String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
            String featured_image = cursor.getString(cursor.getColumnIndexOrThrow("featured_image"));
            gamesItem.setID(id);
            gamesItem.setTitle(title);
            gamesItem.setCategory(category);
            gamesItem.setImage(image);
            gamesItem.setFeautred_image(featured_image);

            stringBuffer.append(gamesItem);
            data.add(gamesItem);
        }

        for (GamesItemHome gi:data ) {


        }


        return data;
    }


    private void deleteTopAppsPreviousContent()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE_TOP_APPS, null, null);
        db.close();
    }

    //---umetanje top_apps_and_games array liste u bazu---
    public void insertTopAppsItemArray(ArrayList<GamesItemHome> argList) {

        deleteTopAppsPreviousContent();
        this.getWritableDatabase().beginTransaction();

        for (GamesItemHome gameItem : argList) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues initialValues = new ContentValues();
            initialValues.put(KEY_ID_GAME, gameItem.getID());
            initialValues.put(KEY_TITLE, gameItem.getTitle());
            initialValues.put(KEY_IMAGE, gameItem.getImage());
            initialValues.put(KEY_FEATURED_IMAGE_HOME, gameItem.getFeautred_image());
            initialValues.put(KEY_CATEGORY, gameItem.getCategory());
            initialValues.put(KEY_LINK_HOME, gameItem.getLink());
            this.getWritableDatabase().insert(DATABASE_TABLE_TOP_APPS, null, initialValues);
            db.insert(DATABASE_TABLE_TOP_APPS, null, initialValues);
        }

        this.getWritableDatabase().setTransactionSuccessful();
        this.getWritableDatabase().endTransaction();

    }

    // povlacenje Top Apps and Games podataka iz baze
    public ArrayList<GamesItemHome> getTopAppsData() {

        ArrayList<GamesItemHome> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + DATABASE_TABLE_TOP_APPS + " ;", null);
        StringBuffer stringBuffer = new StringBuffer();
        GamesItemHome gamesItem = null;
        while (cursor.moveToNext()) {
            gamesItem = new GamesItemHome();
            String id =cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
            String category = cursor.getString(cursor.getColumnIndexOrThrow("category"));
            String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
            String featured_image= cursor.getString(cursor.getColumnIndexOrThrow("featured_image"));

            gamesItem.setID(id);
            gamesItem.setTitle(title);
            gamesItem.setCategory(category);
            gamesItem.setImage(image);
            gamesItem.setFeautred_image(featured_image);

            stringBuffer.append(gamesItem);
            data.add(gamesItem);
        }


        return data;
    }
    private void deleteVirtualPetGamesPreviousContent()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE_VIRTUAL_GAMES, null, null);
        db.close();
    }

    //---umetanje virtual_games array liste u bazu---
    public void insertVirtualGamesItemArray(ArrayList<GamesItemHome> argList) {

        deleteVirtualPetGamesPreviousContent();
        this.getWritableDatabase().beginTransaction();

        for (GamesItemHome gameItem : argList) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues initialValues = new ContentValues();
            initialValues.put(KEY_ID_GAME, gameItem.getID());
            initialValues.put(KEY_TITLE, gameItem.getTitle());
            initialValues.put(KEY_IMAGE, gameItem.getImage());
            initialValues.put(KEY_FEATURED_IMAGE_HOME, gameItem.getFeautred_image());
            initialValues.put(KEY_CATEGORY, gameItem.getCategory());
            initialValues.put(KEY_LINK_HOME, gameItem.getLink());
            db.insert(DATABASE_TABLE_VIRTUAL_GAMES, null, initialValues);
        }

        this.getWritableDatabase().setTransactionSuccessful();
        this.getWritableDatabase().endTransaction();
    }


    // povlacenje Virtual Games podataka iz baze
    public ArrayList<GamesItemHome> getVirtualGamesData() {

        ArrayList<GamesItemHome> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + DATABASE_TABLE_VIRTUAL_GAMES + " ;", null);
        StringBuffer stringBuffer = new StringBuffer();
        GamesItemHome gamesItem = null;
        while (cursor.moveToNext()) {
            gamesItem = new GamesItemHome();
            String id = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
            String category = cursor.getString(cursor.getColumnIndexOrThrow("category"));
            String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
            gamesItem.setTitle(title);
            gamesItem.setCategory(category);
            gamesItem.setImage(image);
            gamesItem.setID(id);

            stringBuffer.append(gamesItem);
            data.add(gamesItem);
        }


        return data;
    }

    private void deleteDoNotMissPreviousContent()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE_DO_NOT_MISS, null, null);
        db.close();
    }

    //---umetanje do_not_miss array liste u bazu---
    public void insertDo_Not_MissItemArray(ArrayList<GamesItemHome> argList) {

        deleteDoNotMissPreviousContent();
        this.getWritableDatabase().beginTransaction();

        for (GamesItemHome gameItem : argList) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues initialValues = new ContentValues();
            initialValues.put(KEY_ID_GAME, gameItem.getID());
            initialValues.put(KEY_TITLE, gameItem.getTitle());
            initialValues.put(KEY_IMAGE, gameItem.getImage());
            initialValues.put(KEY_FEATURED_IMAGE_HOME, gameItem.getFeautred_image());
            initialValues.put(KEY_CATEGORY, gameItem.getCategory());
            initialValues.put(KEY_LINK_HOME, gameItem.getLink());
            db.insert(DATABASE_TABLE_DO_NOT_MISS, null, initialValues);
        }

        this.getWritableDatabase().setTransactionSuccessful();
        this.getWritableDatabase().endTransaction();

    }

    // povlacenje Do Not Miss podataka iz baze
    public ArrayList<GamesItemHome> getDoNotMissData() {

        ArrayList<GamesItemHome> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + DATABASE_TABLE_DO_NOT_MISS + " ;", null);
        StringBuffer stringBuffer = new StringBuffer();
        GamesItemHome gamesItem = null;
        while (cursor.moveToNext()) {
            gamesItem = new GamesItemHome();
            String id =cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
            String category = cursor.getString(cursor.getColumnIndexOrThrow("category"));
            String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
            String featured_image= cursor.getString(cursor.getColumnIndexOrThrow("featured_image"));
            gamesItem.setID(id);
            gamesItem.setTitle(title);
            gamesItem.setCategory(category);
            gamesItem.setImage(image);
            gamesItem.setFeautred_image(featured_image);

            stringBuffer.append(gamesItem);
            data.add(gamesItem);
        }



        return data;
    }

    private void deleteQuizGamesPreviousContent()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE_QUIZ_GAMES, null, null);
        db.close();
    }

    //---umetanje QUIZ GAMES array liste u bazu---
    public void insertQuizGamesItemArray(ArrayList<GamesItemHome> argList) {

        deleteQuizGamesPreviousContent();
        this.getWritableDatabase().beginTransaction();

        for (GamesItemHome gameItem : argList) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues initialValues = new ContentValues();
            initialValues.put(KEY_ID_GAME, gameItem.getID());
            initialValues.put(KEY_TITLE, gameItem.getTitle());
            initialValues.put(KEY_IMAGE, gameItem.getImage());
            initialValues.put(KEY_FEATURED_IMAGE_HOME, gameItem.getFeautred_image());
            initialValues.put(KEY_CATEGORY, gameItem.getCategory());
            initialValues.put(KEY_LINK_HOME, gameItem.getLink());
            db.insert(DATABASE_TABLE_QUIZ_GAMES, null, initialValues);
        }

        this.getWritableDatabase().setTransactionSuccessful();
        this.getWritableDatabase().endTransaction();

    }

    // povlacenje Quiz Games podataka iz baze
    public ArrayList<GamesItemHome> getQuizData() {

        ArrayList<GamesItemHome> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + DATABASE_TABLE_QUIZ_GAMES + " ;", null);
        StringBuffer stringBuffer = new StringBuffer();
        GamesItemHome gamesItem = null;
        while (cursor.moveToNext()) {
            gamesItem = new GamesItemHome();
            String id =cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
            String category = cursor.getString(cursor.getColumnIndexOrThrow("category"));
            String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
            gamesItem.setID(id);
            gamesItem.setTitle(title);
            gamesItem.setCategory(category);
            gamesItem.setImage(image);

            stringBuffer.append(gamesItem);
            data.add(gamesItem);
        }


        return data;
    }

    private void deleteColoringPagesPreviousContent()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE_COLORING_PAGES, null, null);
        db.close();
    }

    // umetanje coloring_pages array liste u bazu
    public void insertColoringPagesItemArray(ArrayList<GamesItemHome> argList) {

        deleteColoringPagesPreviousContent();
        this.getWritableDatabase().beginTransaction();

        for (GamesItemHome gameItem : argList) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues initialValues = new ContentValues();
            initialValues.put(KEY_ID_GAME, gameItem.getID());
            initialValues.put(KEY_TITLE, gameItem.getTitle());
            initialValues.put(KEY_IMAGE, gameItem.getImage());
            initialValues.put(KEY_FEATURED_IMAGE_HOME, gameItem.getFeautred_image());
            initialValues.put(KEY_CATEGORY, gameItem.getCategory());
            initialValues.put(KEY_LINK_HOME, gameItem.getLink());
            db.insert(DATABASE_TABLE_COLORING_PAGES, null, initialValues);
        }

        this.getWritableDatabase().setTransactionSuccessful();
        this.getWritableDatabase().endTransaction();

    }

    // povlacenje Coloring pages podataka iz baze
    public ArrayList<GamesItemHome> getColoringPagesDataFromHomePage() {

        ArrayList<GamesItemHome> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + DATABASE_TABLE_COLORING_PAGES + " ;", null);
        StringBuffer stringBuffer = new StringBuffer();
        GamesItemHome gamesItem = null;
        while (cursor.moveToNext()) {
            gamesItem = new GamesItemHome();
            String id =cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
            String category = cursor.getString(cursor.getColumnIndexOrThrow("category"));
            String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
            gamesItem.setID(id);
            gamesItem.setTitle(title);
            gamesItem.setCategory(category);
            gamesItem.setImage(image);

            stringBuffer.append(gamesItem);
            // stringBuffer.append(dataModel);
            data.add(gamesItem);
        }


        return data;
    }
    //umetanje math_games  array liste u bazu

    private void deleteMathGamesPreviousContent()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE_MATH_GAMES, null, null);
        db.close();
    }

    public void insertMathGamesItemArray(ArrayList<GamesItemHome> argList) {

        deleteMathGamesPreviousContent();
        this.getWritableDatabase().beginTransaction();

        for (GamesItemHome gameItem : argList) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues initialValues = new ContentValues();
            initialValues.put(KEY_ID_GAME, gameItem.getID());
            initialValues.put(KEY_TITLE, gameItem.getTitle());
            initialValues.put(KEY_IMAGE, gameItem.getImage());
            initialValues.put(KEY_FEATURED_IMAGE_HOME, gameItem.getFeautred_image());
            initialValues.put(KEY_CATEGORY, gameItem.getCategory());
            initialValues.put(KEY_LINK_HOME, gameItem.getLink());
            db.insert(DATABASE_TABLE_MATH_GAMES, null, initialValues);
        }

        this.getWritableDatabase().setTransactionSuccessful();
        this.getWritableDatabase().endTransaction();

    }

    // povlacenje Math Games podataka iz baze
    public ArrayList<GamesItemHome> getMathData() {

        ArrayList<GamesItemHome> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + DATABASE_TABLE_MATH_GAMES + " ;", null);
        StringBuffer stringBuffer = new StringBuffer();
        GamesItemHome gamesItem = null;
        while (cursor.moveToNext()) {
            gamesItem = new GamesItemHome();
            String id =cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
            String category = cursor.getString(cursor.getColumnIndexOrThrow("category"));
            String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
            gamesItem.setID(id);
            gamesItem.setTitle(title);
            gamesItem.setCategory(category);
            gamesItem.setImage(image);

            stringBuffer.append(gamesItem);
            data.add(gamesItem);
        }



        return data;
    }

    private void deleteCasualGamesPreviousContent()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE_CASUAL_GAMES, null, null);
        db.close();
    }

    public void insertCasualGamesItemArray(ArrayList<GamesItemHome> argList) {

        deleteCasualGamesPreviousContent();
        this.getWritableDatabase().beginTransaction();

        for (GamesItemHome gameItem : argList) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues initialValues = new ContentValues();
            initialValues.put(KEY_ID_GAME, gameItem.getID());
            initialValues.put(KEY_TITLE, gameItem.getTitle());
            initialValues.put(KEY_IMAGE, gameItem.getImage());
            initialValues.put(KEY_FEATURED_IMAGE_HOME, gameItem.getFeautred_image());
            initialValues.put(KEY_CATEGORY, gameItem.getCategory());
            initialValues.put(KEY_LINK_HOME, gameItem.getLink());
            db.insert(DATABASE_TABLE_CASUAL_GAMES, null, initialValues);
        }

        this.getWritableDatabase().setTransactionSuccessful();
        this.getWritableDatabase().endTransaction();

    }

    // povlacenje Casual Games podataka iz baze
    public ArrayList<GamesItemHome> getCasualData() {

        ArrayList<GamesItemHome> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + DATABASE_TABLE_CASUAL_GAMES + " ;", null);
        StringBuffer stringBuffer = new StringBuffer();
        GamesItemHome gamesItem = null;
        while (cursor.moveToNext()) {
            gamesItem = new GamesItemHome();
            String id =cursor.getString(cursor.getColumnIndexOrThrow("_id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
            String category = cursor.getString(cursor.getColumnIndexOrThrow("category"));
            String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
            gamesItem.setID(id);
            gamesItem.setTitle(title);
            gamesItem.setCategory(category);
            gamesItem.setImage(image);

            stringBuffer.append(gamesItem);
            data.add(gamesItem);
        }


        return data;
    }

    //---umetanje SinglePageItem liste u bazu---
    public void inserSinglePageItemArray(ArrayList<GameItemSingle> argList)
    {
        deletePreviousContent();
        this.getWritableDatabase().beginTransaction();


        for( GameItemSingle singlePageItem: argList)
        {

            ContentValues initialValues = new ContentValues();
            initialValues.put(KEY_ID,singlePageItem.get_id());
            initialValues.put(KEY_DATE,singlePageItem.get_date());

            initialValues.put(KEY_DATE_GMT,singlePageItem.getDate_gmt());
            initialValues.put(KEY_GUID_RENDERED,singlePageItem.getGuid_rendered());
            initialValues.put(KEY_MODIFIED,singlePageItem.get_modified());
            initialValues.put(KEY_MODIFIED_GMT,singlePageItem.getModified_gmt());
            initialValues.put(KEY_SLUG,singlePageItem.getSlug());
            initialValues.put(KEY_STATUS,singlePageItem.getStatus());
            initialValues.put(KEY_TYPE,singlePageItem.get_type());
            initialValues.put(KEY_LINK,singlePageItem.get_link());
            initialValues.put(KEY_TITLE_RENDERED,singlePageItem.getTitle_rendered());
            initialValues.put(KEY_CONTENT_RENDERED,singlePageItem.getContent_rendered());
            initialValues.put(KEY_AUTHOR,singlePageItem.getAuthor());
            initialValues.put(KEY_FEATURED_MEDIA,singlePageItem.getFeatured_media());
            initialValues.put(KEY_TEMPLATE,singlePageItem.getTemplate());

            initialValues.put(KEY_ACF_ANDROID_APP_URL,singlePageItem.getAcf_android_app_url());
            initialValues.put(KEY_ACF_IPHONE_APP_URL,singlePageItem.getAcf_ipone_app_url());
            initialValues.put(KEY_ACF_AMAZON_APP_URL,singlePageItem.getAcf_amazon_app_url());
            initialValues.put(KEY_ACF_WINDOWS_PHONE_APP_URL,singlePageItem.getAcf_windows_phone_app_url());
            initialValues.put(KEY_ACF_VIDEO_LINK,singlePageItem.getAcf_video_link());
            initialValues.put(KEY_ACF_SOCIAL_FB_URL ,singlePageItem.getAcf_social_fb_url());
            initialValues.put(KEY_ACF_PRESS_KIT_URL,singlePageItem.getAcf_press_kit_url());
            initialValues.put(KEY_APP_ICON,singlePageItem.getApp_icon());
            initialValues.put(KEY_ACF_STREAM_APP_URL,singlePageItem.getAcf_stream_app_url());
            initialValues.put(KEY_ACF_PRINTABLE_PDF,singlePageItem.getAcf_printable_pdf());
            initialValues.put(KEY_ACF_GAME_PRICE,singlePageItem.getAcf_game_price());
            initialValues.put(KEY_ACF_GAME_WALLPAPER,singlePageItem.getAcf_game_wallpaper());
            initialValues.put(KEY_ACF_PROMO_TEXT,singlePageItem.getAcf_promo_text());

            initialValues.put(KEY_SCREENSHOOT_MEDIUM1,singlePageItem.getScreenshootMedium1());
            initialValues.put(KEY_SCREENSHOOT_MEDIUM2,singlePageItem.getScreenshootMedium2());
            initialValues.put(KEY_SCREENSHOOT_MEDIUM3,singlePageItem.getScreenshootMedium3());
            initialValues.put(KEY_SCREENSHOOT_MEDIUM4,singlePageItem.getScreenshootMedium4());
            initialValues.put(KEY_SCREENSHOOT_MEDIUM5,singlePageItem.getScreenshootMedium5());
            initialValues.put(KEY_SCREENSHOOT_MEDIUM6,singlePageItem.getScreenshootMedium6());
            initialValues.put(KEY_SCREENSHOOT_MEDIUM7,singlePageItem.getScreenshootMedium7());
            initialValues.put(KEY_SCREENSHOOT_MEDIUM8,singlePageItem.getScreenshootMedium8());

            initialValues.put(KEY_SCREENSHOOT_FULL1,singlePageItem.getScreenshootFull1());
            initialValues.put(KEY_SCREENSHOOT_FULL2,singlePageItem.getScreenshootFull2());
            initialValues.put(KEY_SCREENSHOOT_FULL3,singlePageItem.getScreenshootFull3());
            initialValues.put(KEY_SCREENSHOOT_FULL4,singlePageItem.getScreenshootFull4());
            initialValues.put(KEY_SCREENSHOOT_FULL5,singlePageItem.getScreenshootFull5());
            initialValues.put(KEY_SCREENSHOOT_FULL6,singlePageItem.getScreenshootFull6());
            initialValues.put(KEY_SCREENSHOOT_FULL7,singlePageItem.getScreenshootFull7());
            initialValues.put(KEY_SCREENSHOOT_FULL8,singlePageItem.getScreenshootFull8());
            initialValues.put(KEY_FEATURED_IMAGE,singlePageItem.getFeatured_image());
            initialValues.put(KEY_APP_ICON,singlePageItem.getApp_icon());
            this.getWritableDatabase().insert(DATABASE_TABLE_SINGLE_PAGE, null, initialValues);
        }
        this.getWritableDatabase().setTransactionSuccessful();
        this.getWritableDatabase().endTransaction();
    }


    private void deleteTestimonialsPreviousContent()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE_NAME_TESTIMONIALS, null, null);
        db.close();
    }


    public void insertTestimonialItemArray (ArrayList<TestimonialsItem> argList){

        deleteTestimonialsPreviousContent();
        this.getWritableDatabase().beginTransaction();
        for( TestimonialsItem testimonialsItem : argList)
        {
            ContentValues initialValues = new ContentValues();
            initialValues.put(KEY_GAME_ID,testimonialsItem.getGame_id());
            initialValues.put(KEY_COLUMN_CONTENT,testimonialsItem.getContent());
            initialValues.put(KEY_COLUMN_AUTHOR,testimonialsItem.getAuthor());
            initialValues.put(KEY_COLUMN_RATING,testimonialsItem.getRating());

            this.getWritableDatabase().insert(DATABASE_TABLE_NAME_TESTIMONIALS, null, initialValues);
        }
        this.getWritableDatabase().setTransactionSuccessful();
        this.getWritableDatabase().endTransaction();
    }



    // povlacenje svih podataka iz baze
    public ArrayList<GameItemSingle> getAllData(){

        ArrayList<GameItemSingle> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+DATABASE_TABLE_SINGLE_PAGE+" ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        GameItemSingle singlePageItem = null;
        while (cursor.moveToNext()) {

            singlePageItem= new GameItemSingle();
            String id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title_rendered"));
            String content = cursor.getString(cursor.getColumnIndexOrThrow("content_rendered"));
            String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
            String screenshootMedium1 = cursor.getString(cursor.getColumnIndexOrThrow("ScreenshootMedium1"));
            singlePageItem.setTitle_rendered(title);
            singlePageItem.setContent_rendered(content);
            singlePageItem.set_date(date);
            singlePageItem.set_id(id);
            singlePageItem.setScreenshootMedium1(screenshootMedium1);

            stringBuffer.append(singlePageItem);
            data.add(singlePageItem);
        }


        return data;
    }

    // povlacenje svih podataka iz baze
    public ArrayList<TestimonialsItem> getAllTestimonialData(int id){

        ArrayList<TestimonialsItem> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+DATABASE_TABLE_NAME_TESTIMONIALS+ " WHERE id LIKE " + id + " ;",null);
        //   Cursor cursor = db.rawQuery("select * from "+DATABASE_TABLE_SINGLE_PAGE+ " WHERE _type LIKE " + " '%coloring_pages%'"+ " ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        TestimonialsItem testimonialItem = null;
        while (cursor.moveToNext()) {

            testimonialItem = new TestimonialsItem();
            String game_id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
            String content = cursor.getString(cursor.getColumnIndexOrThrow("content"));
            String author = cursor.getString(cursor.getColumnIndexOrThrow("author"));
            String rating = cursor.getString(cursor.getColumnIndexOrThrow("rating"));

            testimonialItem.setGame_id(game_id);
            testimonialItem.setContent(content);
            testimonialItem.setAuthor(author);
            testimonialItem.setRating(rating);

            stringBuffer.append(testimonialItem);
            data.add(testimonialItem);
        }



        return data;
    }

    // povlacenje SinglePageItem podataka iz baze
    public  GameItemSingle getSinglePageData(String game_id){

        GameItemSingle singlePageItem = new GameItemSingle();
        SQLiteDatabase db = this.getWritableDatabase();

        String [] columns = {KEY_ID,KEY_DATE,KEY_DATE_GMT,KEY_GUID_RENDERED,KEY_MODIFIED,KEY_MODIFIED_GMT,KEY_SLUG,KEY_STATUS,KEY_TYPE,KEY_LINK,KEY_CONTENT_RENDERED,KEY_TITLE_RENDERED,
                KEY_AUTHOR,KEY_FEATURED_MEDIA,KEY_TEMPLATE,KEY_ACF_ANDROID_APP_URL,KEY_ACF_IPHONE_APP_URL,KEY_ACF_AMAZON_APP_URL,KEY_ACF_WINDOWS_PHONE_APP_URL,KEY_ACF_VIDEO_LINK,
                KEY_ACF_SOCIAL_FB_URL,KEY_ACF_PRESS_KIT_URL,KEY_ACF_APP_ICON,KEY_ACF_STREAM_APP_URL,KEY_ACF_PRINTABLE_PDF,KEY_ACF_GAME_PRICE,KEY_ACF_GAME_WALLPAPER,KEY_ACF_PROMO_TEXT,
                KEY_SCREENSHOOT_MEDIUM1,  KEY_SCREENSHOOT_MEDIUM2,KEY_SCREENSHOOT_MEDIUM3,KEY_SCREENSHOOT_MEDIUM4,KEY_SCREENSHOOT_MEDIUM5,KEY_SCREENSHOOT_MEDIUM6,KEY_SCREENSHOOT_MEDIUM7,KEY_SCREENSHOOT_MEDIUM8,
                KEY_SCREENSHOOT_FULL1,KEY_SCREENSHOOT_FULL2,KEY_SCREENSHOOT_FULL3,KEY_SCREENSHOOT_FULL4,KEY_SCREENSHOOT_FULL5,KEY_SCREENSHOOT_FULL6,KEY_SCREENSHOOT_FULL7,KEY_SCREENSHOOT_FULL8,KEY_FEATURED_IMAGE,KEY_APP_ICON};
        String selection = KEY_ID + " =?";
        //Arguments for selection
        String [] selectionArgs = {game_id};
        Cursor cursor = db.query(DATABASE_TABLE_SINGLE_PAGE ,columns,selection,selectionArgs ,null,null,null);
        if (null != cursor) {
            cursor.moveToFirst();
            singlePageItem.set_date(cursor.getString(0));
            singlePageItem.setDate_gmt(cursor.getString(1));
            singlePageItem.setGuid_rendered(cursor.getString(2));
            singlePageItem.set_modified(cursor.getString(3));
            singlePageItem.setModified_gmt(cursor.getString(4));
            singlePageItem.setSlug(cursor.getString(5));
            singlePageItem.setStatus(cursor.getString(6));
            singlePageItem.set_type(cursor.getString(8));
            singlePageItem.set_link(cursor.getString(9));
            singlePageItem.setContent_rendered(cursor.getString(10));
            singlePageItem.setTitle_rendered(cursor.getString(11));
            singlePageItem.setAuthor(cursor.getString(12));
            singlePageItem.setFeatured_media(cursor.getString(13));
            singlePageItem.setTemplate(cursor.getString(14));
            singlePageItem.setAcf_android_app_url(cursor.getString(15));
            singlePageItem.setAcf_ipone_app_url(cursor.getString(16));
            singlePageItem.setAcf_amazon_app_url(cursor.getString(17));
            singlePageItem.setAcf_windows_phone_app_url(cursor.getString(18));
            singlePageItem.setAcf_video_link(cursor.getString(19));
            singlePageItem.setAcf_social_fb_url(cursor.getString(20));
            singlePageItem.setAcf_press_kit_url(cursor.getString(21));
            singlePageItem.setAcf_app_icon(cursor.getString(22));
            singlePageItem.setAcf_stream_app_url(cursor.getString(23));
            singlePageItem.setAcf_printable_pdf(cursor.getString(24));
            singlePageItem.setAcf_game_price(cursor.getString(25));
            singlePageItem.setAcf_game_wallpaper(cursor.getString(26));
            singlePageItem.setAcf_promo_text(cursor.getString(27));
            singlePageItem.setScreenshootMedium1(cursor.getString(28));
            singlePageItem.setScreenshootMedium2(cursor.getString(29));
            singlePageItem.setScreenshootMedium3(cursor.getString(30));
            singlePageItem.setScreenshootMedium4(cursor.getString(31));
            singlePageItem.setScreenshootMedium5(cursor.getString(32));
            singlePageItem.setScreenshootMedium6(cursor.getString(33));
            singlePageItem.setScreenshootMedium7(cursor.getString(34));
            singlePageItem.setScreenshootMedium8(cursor.getString(35));
            singlePageItem.setScreenshootFull1(cursor.getString(36));
            singlePageItem.setScreenshootFull2(cursor.getString(37));
            singlePageItem.setScreenshootFull3(cursor.getString(38));
            singlePageItem.setScreenshootFull4(cursor.getString(39));
            singlePageItem.setScreenshootFull5(cursor.getString(40));
            singlePageItem.setScreenshootFull6(cursor.getString(41));
            singlePageItem.setScreenshootFull7(cursor.getString(42));
            singlePageItem.setScreenshootFull8(cursor.getString(43));
            singlePageItem.setFeatured_image(cursor.getString(44));
            singlePageItem.setApp_icon(cursor.getString(45));

        }
        db.close();
        return singlePageItem;
    }

    // povlacenje Coloring Pages podataka iz baze
    public ArrayList<GameItemSingle> getColoringPagesData(){

        ArrayList<GameItemSingle> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+DATABASE_TABLE_SINGLE_PAGE+ " WHERE _type LIKE " + " '%coloring_pages%'"+ " ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        GameItemSingle singlePageItem = null;
        while (cursor.moveToNext()) {

            singlePageItem= new GameItemSingle();
            String id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title_rendered"));
            String content = cursor.getString(cursor.getColumnIndexOrThrow("content_rendered"));
            String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
            String app_icon= cursor.getString(cursor.getColumnIndexOrThrow("app_icon_image"));
            ;

            singlePageItem.setTitle_rendered(title);
            singlePageItem.setContent_rendered(content);
            singlePageItem.set_date(date);
            singlePageItem.setApp_icon(app_icon);
            singlePageItem.set_id(id);

            stringBuffer.append(singlePageItem);
            data.add(singlePageItem);
        }

        return data;
    }

    // povlacenje podataka Virtual Games iz baze
    // povlacenje podataka Virtual Games iz baze
    public ArrayList<GameItemSingle> getVirtualGameData(){

        ArrayList<GameItemSingle> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+DATABASE_TABLE_SINGLE_PAGE + " WHERE _type LIKE " + " '%virtual_pet_games%'"+ " ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        GameItemSingle singlePageItem = null;
        while (cursor.moveToNext()) {

            singlePageItem= new GameItemSingle();
            String id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title_rendered"));
            String content = cursor.getString(cursor.getColumnIndexOrThrow("content_rendered"));
            String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
            String app_icon = cursor.getString(cursor.getColumnIndexOrThrow("app_icon_image"));
            singlePageItem.setTitle_rendered(title);
            singlePageItem.setContent_rendered(content);
            singlePageItem.set_date(date);
            singlePageItem.setApp_icon(app_icon);
            singlePageItem.set_id(id);

            stringBuffer.append(singlePageItem);
            data.add(singlePageItem);
        }

        return data;
    }

    // povlacenje podataka Casual Game iz baze
    public ArrayList<GameItemSingle> getCasualGameData(){

        ArrayList<GameItemSingle> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+DATABASE_TABLE_SINGLE_PAGE + " WHERE _type LIKE " + " '%casual_games%'"+ " ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        GameItemSingle singlePageItem = null;
        while (cursor.moveToNext()) {

            singlePageItem= new GameItemSingle();
            String id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title_rendered"));
            String content = cursor.getString(cursor.getColumnIndexOrThrow("content_rendered"));
            String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
            String app_icon= cursor.getString(cursor.getColumnIndexOrThrow("app_icon_image"));
            singlePageItem.setTitle_rendered(title);
            singlePageItem.setContent_rendered(content);
            singlePageItem.set_date(date);
            singlePageItem.setApp_icon(app_icon);
            singlePageItem.set_id(id);

            stringBuffer.append(singlePageItem);
            data.add(singlePageItem);
        }


        return data;
    }

    // povlacenje podataka Casual Game iz baze koji imaju package id
    public ArrayList<GameItemSingle> getCasualGameWhitPackageID(){

        ArrayList<GameItemSingle> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+DATABASE_TABLE_SINGLE_PAGE + " WHERE _type LIKE " + " '%casual_games%'"+  " AND acf_android_app_url LIKE 'c%'" +
                " ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        GameItemSingle singlePageItem = null;
        while (cursor.moveToNext()) {

            singlePageItem= new GameItemSingle();
            String id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title_rendered"));
            String content = cursor.getString(cursor.getColumnIndexOrThrow("content_rendered"));
            String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
            String app_icon= cursor.getString(cursor.getColumnIndexOrThrow("app_icon_image"));
            singlePageItem.setTitle_rendered(title);
            singlePageItem.setContent_rendered(content);
            singlePageItem.set_date(date);
            singlePageItem.setApp_icon(app_icon);
            singlePageItem.set_id(id);

            stringBuffer.append(singlePageItem);
            data.add(singlePageItem);
        }


        return data;
    }

    // povlacenje podataka Math Game iz baze
    public ArrayList<GameItemSingle> getMathGameData(){

        ArrayList<GameItemSingle> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+DATABASE_TABLE_SINGLE_PAGE + " WHERE _type LIKE " + " '%math_games%'"+ " ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        GameItemSingle singlePageItem = null;
        while (cursor.moveToNext()) {

            singlePageItem= new GameItemSingle();
            String id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title_rendered"));
            String content = cursor.getString(cursor.getColumnIndexOrThrow("content_rendered"));
            String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
            String app_icon= cursor.getString(cursor.getColumnIndexOrThrow("app_icon_image"));
            singlePageItem.setTitle_rendered(title);
            singlePageItem.setContent_rendered(content);
            singlePageItem.set_date(date);
            singlePageItem.setApp_icon(app_icon);
            singlePageItem.set_id(id);

            stringBuffer.append(singlePageItem);
            data.add(singlePageItem);
        }


        return data;
    }
    // povlacenje podataka Quiz Game iz baze
    public ArrayList<GameItemSingle> getQuizGameData(){

        ArrayList<GameItemSingle> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+DATABASE_TABLE_SINGLE_PAGE + " WHERE _type LIKE " + " '%quiz_games%'"+ " ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        GameItemSingle singlePageItem = null;
        while (cursor.moveToNext()) {

            singlePageItem= new GameItemSingle();
            String id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title_rendered"));
            String content = cursor.getString(cursor.getColumnIndexOrThrow("content_rendered"));
            String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
            String app_icon= cursor.getString(cursor.getColumnIndexOrThrow("app_icon_image"));
            singlePageItem.setTitle_rendered(title);
            singlePageItem.setContent_rendered(content);
            singlePageItem.set_date(date);
            singlePageItem.setApp_icon(app_icon);
            singlePageItem.set_id(id);

            stringBuffer.append(singlePageItem);
            data.add(singlePageItem);
        }


        return data;
    }

    // povlacenje podataka Quiz Game iz baze
    public ArrayList<GameItemSingle> getGamesByCategory (String category){

        ArrayList<GameItemSingle> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+DATABASE_TABLE_SINGLE_PAGE + " WHERE _type LIKE " + "'%" + category + "%'" +  " ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        GameItemSingle singlePageItem = null;
        while (cursor.moveToNext()) {

            singlePageItem= new GameItemSingle();
            String id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title_rendered"));
            String content = cursor.getString(cursor.getColumnIndexOrThrow("content_rendered"));
            String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
            String app_icon= cursor.getString(cursor.getColumnIndexOrThrow("app_icon_image"));
            singlePageItem.setTitle_rendered(title);
            singlePageItem.setContent_rendered(content);
            singlePageItem.set_date(date);
            singlePageItem.setApp_icon(app_icon);
            singlePageItem.set_id(id);

            stringBuffer.append(singlePageItem);
            data.add(singlePageItem);
        }


        return data;
    }

    public ArrayList<GameItemSingle> GetGamesBySearchTerm (String searchTerm){

        ArrayList<GameItemSingle> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+DATABASE_TABLE_SINGLE_PAGE + " WHERE title_rendered LIKE " + "'%" + searchTerm + "%'" +  " ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        GameItemSingle singlePageItem = null;
        while (cursor.moveToNext()) {

            singlePageItem= new GameItemSingle();

            String id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title_rendered"));
            String content = cursor.getString(cursor.getColumnIndexOrThrow("content_rendered"));
            String type = cursor.getString(cursor.getColumnIndexOrThrow("_type"));
            String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
            String app_icon= cursor.getString(cursor.getColumnIndexOrThrow("app_icon_image"));
            singlePageItem.setTitle_rendered(title);
            singlePageItem.setContent_rendered(content);
            singlePageItem.set_type(type);
            singlePageItem.set_date(date);
            singlePageItem.setApp_icon(app_icon);
            singlePageItem.set_id(id);

            stringBuffer.append(singlePageItem);
            data.add(singlePageItem);
        }


        return data;
    }



}


