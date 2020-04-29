package com.nachi.teamactivity.controller

class Userempdata {

        var empId1: String? = null
        var empName1: String? = null
        var portFolio:String?=null
        var subDomain:String?=null
        var proJect:String?=null
        var locaTion:String?=null
        var subLocationvalue:String?=null
        var catsId:String?=null
        var citrixId:String?=null
        var tcsJdate:String?=null
        var wowJdate:String?=null
        var billIng:String?=null
        var staTus:String?=null
        var visaStatus:String?=null
        var desiGnation:String?=null



        constructor(empid1: String) {
                this.empId1 = empid1
        }


        constructor(empid1: String, empname1: String, portfolio:String,subdomain:String,project:String,location:String,
        sublocationvalue:String,citrixid:String,catsid:String,tcsjdate:String,wowjdate:String,billing:String,status:String,
        visastatus:String,designation:String) {
                this.empId1 = empid1
                this.empName1 = empname1
                this.portFolio=portfolio
                this.subDomain=subdomain
                this.proJect=project
                this.locaTion=location
                this.subLocationvalue=sublocationvalue
                this.catsId=catsid
                this.citrixId=citrixid
                this.tcsJdate=tcsjdate
                this.wowJdate=wowjdate
                this.billIng=billing
                this.staTus=status
                this.visaStatus=visastatus
                this.desiGnation=designation




        }

        constructor() {
        }

}
