package com.example.appdocsachv2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    private static final String DATABASE_NAME = "BookApp.db";
    private static final int DATABASE_VERSION = 2; // Tăng version để áp dụng nâng cấp
    // Tên bảng và cột
    public static final String TABLE_USER = "User";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";

    // Tạo bảng User
    private static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS User (" +
            "user_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "username TEXT NOT NULL UNIQUE," +
            "password TEXT NOT NULL," +
            "email TEXT UNIQUE" +
            ")";

    // Tạo bảng Book (thêm cột summary)
    private static final String CREATE_TABLE_BOOK = "CREATE TABLE IF NOT EXISTS Book (" +
            "book_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "title TEXT NOT NULL," +
            "author TEXT," +
            "genre TEXT," +
            "file_path TEXT NOT NULL," +
            "cover_image TEXT," +
            "total_pages INTEGER," +
            "summary TEXT" + // Thêm cột summary
            ")";

    // Tạo bảng Chapter
    private static final String CREATE_TABLE_CHAPTER = "CREATE TABLE IF NOT EXISTS Chapter (" +
            "chapter_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "book_id INTEGER NOT NULL," +
            "title TEXT NOT NULL," +
            "start_page INTEGER," +
            "end_page INTEGER," +
            "FOREIGN KEY (book_id) REFERENCES Book(book_id) ON DELETE CASCADE" +
            ")";

    // Tạo bảng FavoriteBook
    private static final String CREATE_TABLE_FAVORITE_BOOK = "CREATE TABLE IF NOT EXISTS FavoriteBook (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "user_id INTEGER NOT NULL," +
            "book_id INTEGER NOT NULL," +
            "FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE," +
            "FOREIGN KEY (book_id) REFERENCES Book(book_id) ON DELETE CASCADE," +
            "UNIQUE (user_id, book_id)" +
            ")";

    // Tạo bảng ReadingProgress
    private static final String CREATE_TABLE_READING_PROGRESS = "CREATE TABLE IF NOT EXISTS ReadingProgress (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "user_id INTEGER NOT NULL," +
            "book_id INTEGER NOT NULL," +
            "current_page INTEGER DEFAULT 0," +
            "FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE," +
            "FOREIGN KEY (book_id) REFERENCES Book(book_id) ON DELETE CASCADE," +
            "UNIQUE (user_id, book_id)" +
            ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        Log.d(TAG, "User table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if (oldVersion < 2) {
//            // Thêm cột summary vào bảng Book nếu chưa tồn tại
//            db.execSQL("ALTER TABLE Book ADD COLUMN summary TEXT");
//        }
//        // Thêm các nâng cấp khác nếu có trong tương lai
//        // Ví dụ: nếu cần thêm cột mới hoặc thay đổi cấu trúc khác
    }
    // Hàm này đảm bảo tài khoản admin tồn tại
    public void ensureDefaultAdminExists() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_USER + " WHERE " + COLUMN_USERNAME + " = ?", new String[]{"admin"});
        if (cursor != null) {
            if (cursor.moveToFirst() && cursor.getInt(0) == 0) {
                ContentValues values = new ContentValues();
                values.put(COLUMN_USERNAME, "admin");
                values.put(COLUMN_PASSWORD, "123456");
                values.put(COLUMN_EMAIL, "admin@example.com");
                long result = db.insert(TABLE_USER, null, values);
                Log.d(TAG, result != -1 ? "Tài khoản admin đã được tạo." : "Tạo admin thất bại.");
            } else {
                Log.d(TAG, "Tài khoản admin đã tồn tại.");
            }
            cursor.close();
        }
    }

    //  Hàm kiểm tra đăng nhập
    public boolean checkUserLogin(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_USERNAME + " = ? AND " + COLUMN_PASSWORD + " = ?",
                new String[]{username, password}
        );
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }
}