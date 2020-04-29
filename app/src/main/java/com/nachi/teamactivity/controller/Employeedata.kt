package com.nachi.teamactivity.controller

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.nachi.teamactivity.R
import kotlinx.android.synthetic.main.activity_updateemployee.*
import javax.microedition.khronos.egl.EGL10


class Employeedata(context: Context):SQLiteOpenHelper(context, dbname, factory, version) {
    lateinit var handler10: Updateemployee

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "create table employeedata(id integer primary key autoincrement," + "empname varchar(40),empid varchar(20)," +
                    "empcitrix varchar(20),empcats varchar(20),emptcsdate varchar(20),empwowdate varchar(20),empportfolio varchar(20), " +
                    "empproject varchar(20),emplocation varchar(20),empsublocation varchar(20), empbilling varchar(20), empstatus varchar(20)," +
                    "empvisastatus varchar(20),empsubdomain varchar(20),empdesignation varchar(20))"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertregisterdata(
        empid: String,
        empname: String,
        empcitrix: String,
        empcats: String,
        emptcsdate: String,
        empwowdate: String,
        empportfolio: String,
        empproject: String,
        empsubdomain: String,
        emplocation: String,
        empsublocation: String,
        empstatus: String,
        empbilling: String,
        empvisastatus: String,
        empdesignation: String
    ) {
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("empid", empid)
        values.put("empname", empname)
        values.put("empcitrix", empcitrix)
        values.put("empcats", empcats)
        values.put("emptcsdate", emptcsdate)
        values.put("empwowdate", empwowdate)
        values.put("empportfolio", empportfolio)
        values.put("empsubdomain", empsubdomain)
        values.put("empproject", empproject)
        values.put("emplocation", emplocation)
        values.put("empsublocation", empsublocation)
        values.put("empbilling", empbilling)
        values.put("empstatus", empstatus)
        values.put("empvisastatus", empvisastatus)
        values.put("empdesignation", empdesignation)

        db.insert("employeedata", null, values)
        db.close()
    }
    fun findemployee(ename: String): Userempdata? {
        val query = "Select * from employeedata where empid = '$ename'"
        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)
        var emdata: Userempdata? = null
        if (cursor.moveToFirst()) {
            cursor.moveToFirst()
            val empid1 = cursor.getString(2)
            val empname1 = cursor.getString(1)
            val subdomain = cursor.getString(14)
            val status = cursor.getString(12)
            val designation = cursor.getString(15)
            val project = cursor.getString(8)
            val sublocation = cursor.getString(10)
            val tcsjodate = cursor.getString(5)
            val wowjodate = cursor.getString(6)
            val citrix = cursor.getString(3)
            val cats = cursor.getString(4)
            val location = cursor.getString(9)
            val visastatus = cursor.getString(13)
            val billing = cursor.getString(11)
            val portfolio = cursor.getString(7)



            emdata = Userempdata(empid1, empname1,portfolio,subdomain,project,location,sublocation,citrix,cats,tcsjodate,wowjodate,billing,
            status,visastatus,designation)
            cursor.close()
        }
        db.close()
        return emdata
    }

    fun updateempdata(createempid2:String,
                      creatempname2:String,
                      createcitrid2:String,
                      createcats2:String,
                      createtcsdate2:String,
                      createwowdate2:String,
                      potfoliovalue2:String,
                      projectvalue2:String,
                      subdomainvalue2:String,
                      locationvalue2:String,
                      locationsubvalue2:String,
                      employeesttatusvalue2:String,
                      billingstatusvalue2:String,
                      visastatusvalue2:String,
                      designationvalue2:String):Boolean {
        val db = writableDatabase
        val query = "Select * from employeedata where empid = '$createempid2'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0) {
            cursor.close()
            return false
        } else {
            val db: SQLiteDatabase = writableDatabase
            val values: ContentValues = ContentValues()
            values.put("empid", createempid2)
            values.put("empname", creatempname2)
            values.put("empcitrix",createcitrid2)
            values.put("empcats", createcats2)
            values.put("emptcsdate", createtcsdate2)
            values.put("empwowdate", createwowdate2)
            values.put("empportfolio", potfoliovalue2)
            values.put("empsubdomain", subdomainvalue2)
            values.put("empproject", projectvalue2)
            values.put("emplocation", locationvalue2)
            values.put("empsublocation", locationsubvalue2)
            values.put("empbilling", billingstatusvalue2)
            values.put("empstatus", employeesttatusvalue2)
            values.put("empvisastatus", visastatusvalue2)
            values.put("empdesignation", designationvalue2)
            db.update("employeedata",values,"empid=?", arrayOf(createempid2))
            db.close()
            cursor.close()
            return true
        }
    }
    companion object {
        internal val dbname = "employeedata"
        internal val factory = null
        internal val version = 1

    }}


