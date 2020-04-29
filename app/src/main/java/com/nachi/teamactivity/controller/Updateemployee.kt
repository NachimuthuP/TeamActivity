package com.nachi.teamactivity.controller

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.nachi.teamactivity.R
import kotlinx.android.synthetic.main.activity_updateemployee.*
import kotlinx.android.synthetic.main.nav_drawer.*
import kotlinx.android.synthetic.main.registration.*
import java.text.SimpleDateFormat
import java.util.*

class Updateemployee : AppCompatActivity() {
    lateinit var handler7: Employeedata

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updateemployee)
        searchbutton.setOnClickListener {
            handler7 = Employeedata(this)

            val textView: TextView = findViewById(R.id.createtcsjoiningdate)
            //   textView.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())

            var cal = Calendar.getInstance()


            val dateSetListener =
                DatePickerDialog.OnDateSetListener { datepicker, year, monthOfYear, dayOfMonth ->
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, monthOfYear)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    val myFormat = "dd.MM.yyyy" // mention the format you need
                    val sdf = SimpleDateFormat(myFormat, Locale.US)
                    textView.text = sdf.format(cal.time)

                }
            textView.setOnClickListener {
                DatePickerDialog(
                    this, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

            val textView1: TextView = findViewById(R.id.createwowjoiningdate)
            val dateSetListener1 =
                DatePickerDialog.OnDateSetListener { datepicker, year, monthOfYear, dayOfMonth ->
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, monthOfYear)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    val myFormat = "dd.MM.yyyy" // mention the format you need
                    val sdf = SimpleDateFormat(myFormat, Locale.US)
                    textView1.text = sdf.format(cal.time)

                }
            textView1.setOnClickListener {
                DatePickerDialog(
                    this, dateSetListener1,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }


            var portfoliooption = findViewById(R.id.createportfolio) as Spinner
            var portfoliooptions =
                arrayOf("Please select", "Stores", "Enterprise", "PVC", "Digital", "Nonprod")
            portfoliooption.adapter = ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                portfoliooptions
            )
            var subdomainoption = findViewById(R.id.createsubdomain) as Spinner
            var subdomainoptions =
                arrayOf("Please select", "Stores", "WFO", "SOI", "Security")
            subdomainoption.adapter = ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                subdomainoptions
            )


            var projectoption = findViewById(R.id.createproject) as Spinner
            var projectoptions = arrayOf("Please select", "R10 BAU", "CT", "Store Central")
            projectoption.adapter = ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                projectoptions
            )

            var locationoption = findViewById(R.id.createlocation) as Spinner
            var locationoptions = arrayOf("Please select", "ON", "OFF")
            locationoption.adapter = ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                locationoptions
            )

            var locationsuboption = findViewById(R.id.createsublocation) as Spinner
            var locationsuboptions =
                arrayOf(
                    "Please select",
                    "Norwest",
                    "Chennai"
                )
            locationsuboption.adapter = ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                locationsuboptions
            )

            var employeestatus = findViewById(R.id.createstatus) as Spinner
            var statusoptions = arrayOf("Please select", "Active", "Released")
            employeestatus.adapter =
                ArrayAdapter<String>(
                    this,
                    R.layout.support_simple_spinner_dropdown_item,
                    statusoptions
                )

            var billingstatus = findViewById(R.id.createbilling) as Spinner
            var billingoptions = arrayOf("Please select", "Billable", "Non-billable", "Manager")
            billingstatus.adapter = ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                billingoptions
            )

            var visastatus = findViewById(R.id.createvisastatus) as Spinner
            var visaoptions = arrayOf(
                "Please select",
                "NA",
                "Active-Onshore",
                "Active-Offshore"
//                "Expired",
//                "Initiated"
            )
            visastatus.adapter =
                ArrayAdapter<String>(
                    this,
                    R.layout.support_simple_spinner_dropdown_item,
                    visaoptions
                )

            var designation = findViewById(R.id.createdesignation) as Spinner
            var designationoptions =
                arrayOf("Please select", "ITA", "AST")
            designation.adapter = ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                designationoptions
            )


            val product = handler7.findemployee(enterempid.text.toString())
            if (product != null) {
                createempid.setText(product.empId1.toString())
                createempname.setText(product.empName1.toString())
                createcatsid.setText(product.catsId.toString())
                createcitrixid.setText(product.citrixId.toString())
                createtcsjoiningdate.setText(product.tcsJdate.toString())
                createwowjoiningdate.setText(product.wowJdate.toString())
                var position: Int = 0
                if (product.portFolio == "Stores") {
                    position = 1
                } else if (product.portFolio == "Enterprise") {
                    position = 2
                } else if (product.portFolio == "PVC") {
                    position = 3
                } else if (product.portFolio == "Digital") {
                    position = 4
                } else if (product.portFolio == "Non prod") {
                    position = 5
                }
                createportfolio.setSelection(position)

                var position1: Int = 0
                if (product.subDomain == "Stores") {
                    position1 = 1
                } else if (product.subDomain == "WFO") {
                    position1 = 2
                } else if (product.subDomain == "SOI") {
                    position1 = 3
                } else if (product.subDomain == "Security") {
                    position1 = 4
                }
                createsubdomain.setSelection(position1)

                var position2: Int = 0
                if (product.proJect == "R10 BAU") {
                    position2 = 1
                } else if (product.proJect == "CT") {
                    position2 = 2
                } else if (product.proJect == "Store Central") {
                    position2 = 2
                }
                createproject.setSelection(position2)

                var position3: Int = 0
                if (product.locaTion == "ON") {
                    position3 = 1
                } else if (product.locaTion == "OFF") {
                    position3 = 2
                }
                createlocation.setSelection(position3)

                var position4: Int = 0
                if (product.subLocationvalue == "Norwest") {
                    position4 = 1
                } else if (product.subLocationvalue == "Chennai") {
                    position4 = 2
                }
                createsublocation.setSelection(position4)

                var position5: Int = 0
                if (product.staTus == "Active") {
                    position5 = 1
                } else if (product.staTus == "Released") {
                    position5 = 2
                }
                createstatus.setSelection(position5)

                var position6: Int = 0
                if (product.billIng == "Billable") {
                    position6 = 1
                } else if (product.billIng == "billable") {
                    position6 = 2
                } else if (product.billIng == "Manager") {
                    position6 = 2
                }
                createbilling.setSelection(position6)

                var position7: Int = 0
                if (product.visaStatus == "NA") {
                    position7 = 1
                } else if (product.visaStatus == "Active-Onshore") {
                    position7 = 2
                } else if (product.visaStatus == "Active-Offshore") {
                    position7 = 2
                }
                createvisastatus.setSelection(position7)

                var position8: Int = 0
                if (product.desiGnation == "ITA") {
                    position8 = 1
                } else if (product.desiGnation == "AST") {
                    position8 = 2
                }
                createdesignation.setSelection(position8)

            } else {
                Toast.makeText(
                    applicationContext,
                    "Employeee not found",
                    Toast.LENGTH_LONG
                ).show()
                val startpage = Intent(this, firstscreen1::class.java)
                startActivity(startpage)
            }

        }
        savebutton.setOnClickListener {
            var portfoliovalue = findViewById(R.id.createportfolio) as Spinner
            var subdomainvalue = findViewById(R.id.createsubdomain) as Spinner
            var projectvalue = findViewById(R.id.createproject) as Spinner
            var locationvalue = findViewById(R.id.createlocation) as Spinner
            var locationsubvalue = findViewById(R.id.createsublocation) as Spinner
            var employeesttatusvalue = findViewById(R.id.createstatus) as Spinner
            var billingstatusvalue = findViewById(R.id.createbilling) as Spinner
            var visastatusvalue = findViewById(R.id.createvisastatus) as Spinner
            var designationvalue = findViewById(R.id.createdesignation) as Spinner

            var portfoliovalue1 = portfoliovalue.selectedItem.toString()
            var subdomainvalue1 = subdomainvalue.selectedItem.toString()
            var projectvalue1 = projectvalue.selectedItem.toString()
            var locationvalue1 = locationvalue.selectedItem.toString()
            var locationsubvalue1 = locationsubvalue.selectedItem.toString()
            var employeesttatusvalue1 = employeesttatusvalue.selectedItem.toString()
            var billingstatusvalue1 = billingstatusvalue.selectedItem.toString()
            var visastatusvalue1 = visastatusvalue.selectedItem.toString()
            var designationvalue1 = designationvalue.selectedItem.toString()
            if (createempid.text.isBlank() || createempname.text.isBlank() || portfoliovalue1.equals(
                    "Please select"
                ) ||
                subdomainvalue1.equals("Please select") || projectvalue1.equals("Please select") || locationsubvalue1.equals(
                    "Please select"
                )
                || locationvalue1.equals("Please select") || employeesttatusvalue1.equals("Please select") || billingstatusvalue1.equals(
                    "Please select"
                )
                || visastatusvalue1.equals("Please select") || designationvalue1.equals("Please select") || createcatsid.text.isBlank()
                || createcitrixid.text.isBlank() || createtcsjoiningdate.text.isBlank() || createwowjoiningdate.text.isBlank()
            ) {
                Toast.makeText(
                    applicationContext,
                    "Please fill all the fields",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                var createempid2 = createempid.text.toString()
                var creatempname2 = createempname.text.toString()
                var createcitrid2 = createcitrixid.text.toString()
                var createcats2 = createcatsid.text.toString()
                var createtcsdate2 = createtcsjoiningdate.text.toString()
                var createwowdate2 = createwowjoiningdate.text.toString()
                var potfoliovalue2 = portfoliovalue.selectedItem.toString()
                var subdomainvalue2 = subdomainvalue.selectedItem.toString()
                var projectvalue2 = projectvalue.selectedItem.toString()
                var locationvalue2 = locationvalue.selectedItem.toString()
                var locationsubvalue2 = locationsubvalue.selectedItem.toString()
                var employeesttatusvalue2 = employeesttatusvalue.selectedItem.toString()
                var billingstatusvalue2 = billingstatusvalue.selectedItem.toString()
                var visastatusvalue2 = visastatusvalue.selectedItem.toString()
                var designationvalue2 = designationvalue.selectedItem.toString()

                if (handler7.updateempdata(
                        createempid2,
                        creatempname2,
                        createcitrid2,
                        createcats2,
                        createtcsdate2,
                        createwowdate2,
                        potfoliovalue2,
                        projectvalue2,
                        subdomainvalue2,
                        locationvalue2,
                        locationsubvalue2,
                        employeesttatusvalue2,
                        billingstatusvalue2,
                        visastatusvalue2,
                        designationvalue2)) {
                    Toast.makeText(
                        applicationContext,
                        "User updated successfully",
                        Toast.LENGTH_LONG
                    )
                        .show()
                    val startpage = Intent(this, firstscreen1::class.java)
                    startActivity(startpage)
                }

            }
        }
    }

}



