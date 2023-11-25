package com.ftg.famasale.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.ftg.famasale.Models.EmployeeDetails
import com.ftg.famasale.Models.EmployeeVisitDetails
import com.ftg.famasale.R

class EmployeesCheckOutAdapter(
    private val employees:List<EmployeeVisitDetails>,
    private val checkIn: (EmployeeVisitDetails) -> Unit
): RecyclerView.Adapter<EmployeesCheckOutAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.employee_name)
        val id: TextView = itemView.findViewById(R.id.employee_id)
        val action: AppCompatButton = itemView.findViewById(R.id.check_out)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employee_checkout_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employee = employees[position]

        holder.name.text = employee.Employee?.employee_name
        holder.id.text = "#${employee.employee_id}"

        holder.action.setOnClickListener { checkIn(employee) }
    }
}