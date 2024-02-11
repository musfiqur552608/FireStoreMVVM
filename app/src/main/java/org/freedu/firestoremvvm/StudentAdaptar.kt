package org.freedu.firestoremvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.freedu.firestoremvvm.model.Student

class StudentAdaptar(var studentList: List<Student>):
    RecyclerView.Adapter<StudentAdaptar.StudentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.student_list, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position])
    }
    class StudentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var sname = itemView.findViewById<TextView>(R.id.studentNameTxt)
        var id = itemView.findViewById<TextView>(R.id.studentIdTxt)
        var email = itemView.findViewById<TextView>(R.id.studentEmailTxt)
        var address = itemView.findViewById<TextView>(R.id.studentAddressTxt)
        var age = itemView.findViewById<TextView>(R.id.studentAgeTxt)
        var phone = itemView.findViewById<TextView>(R.id.studentPhoneNoTxt)
        var section = itemView.findViewById<TextView>(R.id.studentSectionTxt)
        fun bind(student: Student) {
            sname.text = student.name
            id.text = student.studentId
            email.text = student.email
            address.text = student.address
            age.text = student.age.toString()
            phone.text = student.phoneNumber
            section.text = student.section
        }
    }
}