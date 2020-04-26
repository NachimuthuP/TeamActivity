package com.nachi.teamactivity.controller

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class Registrationdb(context: Context):SQLiteOpenHelper(context, dbname, factory, version){


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table registeruser(id integer primary key autoincrement,"+"name varchar(20),password varchar(20))")
        print("cretion")
    }
    fun insertregisterdata(name: String, password: String){
        print("ïnsertion")
        val db: SQLiteDatabase=writableDatabase
        val values:ContentValues= ContentValues()
        values.put("name", name)
        values.put("password",password)
        db.insert("registeruser",null,values)
        db.close()
    }
    fun registeruserpresent(name:String,password:String):Boolean{
        val db = writableDatabase
        val query="Select * from registeruser where name = '$name' and password= '$password'"
        val cursor=db.rawQuery(query, null)
        if (cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
    fun deleteregisterdata(name: String):Boolean{
        val db = writableDatabase
        val query="Select * from registeruser where name = '$name'"
        val cursor=db.rawQuery(query, null)
        if (cursor.count<=0){
            cursor.close()
            return false
        }else {
            val db: SQLiteDatabase=writableDatabase
            val values:ContentValues= ContentValues()
            values.put("name", name)
            db.delete("registeruser",name,null)
            db.close()
            cursor.close()
            return true
        }

    }
    fun updateegisterdata(name: String, password: String):Boolean {
        val db = writableDatabase
        val query = "Select * from registeruser where name = '$name'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0) {
            cursor.close()
            return false
        } else {
            val db: SQLiteDatabase = writableDatabase
            val values: ContentValues = ContentValues()
            values.put("name", name)
            values.put("password", password)
            db.update("registeruser", values, name, null)
            db.close()
            cursor.close()
            return true
        }
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    companion object {
    internal val dbname = "Registerdb"
    internal val factory = null
    internal val version = 1
}

}
